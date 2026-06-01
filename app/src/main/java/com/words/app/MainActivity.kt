package com.words.app

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.webkit.JavascriptInterface
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.webkit.JsResult
import androidx.activity.OnBackPressedCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.webkit.WebSettingsCompat
import androidx.webkit.WebViewFeature
import org.json.JSONArray
import java.io.File
import com.words.app.R

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private val allWordsMap = mutableMapOf<String, JSONArray>()
    private val listNames = mutableListOf<String>()
    private val DATA_FILE_NAME = "words_data.json"

    private val filePickerLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            result.data?.data?.let { uri ->
                importExternalJson(uri)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)
        setupWebView()

        if (checkDataExists()) {
            loadAndGroupWords()
        }
        
        webView.loadUrl("file:///android_asset/index.html")

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (webView.canGoBack()) {
                    webView.goBack()
                } else {
                    finish()
                }
            }
        })
    }

    private fun setupWebView() {
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true
        webSettings.allowFileAccess = true
        webSettings.allowContentAccess = true

        // 适配深色模式
        val nightModeFlags = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        if (nightModeFlags == Configuration.UI_MODE_NIGHT_YES) {
            if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)) {
                WebSettingsCompat.setForceDark(webSettings, WebSettingsCompat.FORCE_DARK_ON)
            }
        }
        
        webView.addJavascriptInterface(AndroidWordBridge(), "AndroidBridge")
        
        webView.webChromeClient = object : WebChromeClient() {
            override fun onJsConfirm(view: WebView?, url: String?, message: String?, result: JsResult?): Boolean {
                AlertDialog.Builder(this@MainActivity)
                    .setTitle("提示")
                    .setMessage(message)
                    .setPositiveButton("确定") { _, _ -> result?.confirm() }
                    .setNegativeButton("取消") { _, _ -> result?.cancel() }
                    .setCancelable(false)
                    .show()
                return true
            }
        }

        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                webView.evaluateJavascript("javascript:initFromAndroid()", null)
            }
        }
    }

    private fun checkDataExists(): Boolean {
        return File(filesDir, DATA_FILE_NAME).exists()
    }

    private fun loadAndGroupWords() {
        try {
            allWordsMap.clear()
            listNames.clear()
            val file = File(filesDir, DATA_FILE_NAME)
            if (!file.exists()) return
            
            val jsonString = file.readText()
            val fullArray = JSONArray(jsonString)
            for (i in 0 until fullArray.length()) {
                val item = fullArray.getJSONObject(i)
                val listName = item.optString("list", "default")
                if (!allWordsMap.containsKey(listName)) {
                    allWordsMap[listName] = JSONArray()
                    listNames.add(listName)
                }
                allWordsMap[listName]?.put(item)
            }
        } catch (e: Exception) {
            Log.e("WordApp", "解析数据失败", e)
        }
    }

    private fun importExternalJson(uri: Uri) {
        try {
            contentResolver.openInputStream(uri)?.use { input ->
                val targetFile = File(filesDir, DATA_FILE_NAME)
                targetFile.writeBytes(input.readBytes())
            }
            loadAndGroupWords()
            webView.reload()
        } catch (e: Exception) {
            showError("导入失败: ${e.message}")
        }
    }

    private fun showError(msg: String) {
        AlertDialog.Builder(this).setMessage(msg).setPositiveButton("确定", null).show()
    }

    inner class AndroidWordBridge {
        @JavascriptInterface
        fun hasData(): Boolean = checkDataExists()

        @JavascriptInterface
        fun getListNames(): String = JSONArray(listNames).toString()

        @JavascriptInterface
        fun getWordsByListName(name: String): String = allWordsMap[name]?.toString() ?: "[]"

        @JavascriptInterface
        fun getLastListName(): String {
            val prefs = getSharedPreferences("WordApp", Context.MODE_PRIVATE)
            return prefs.getString("last_list", if(listNames.isNotEmpty()) listNames[0] else "") ?: ""
        }

        @JavascriptInterface
        fun saveCurrentList(name: String) {
            getSharedPreferences("WordApp", Context.MODE_PRIVATE).edit().putString("last_list", name).apply()
        }

        @JavascriptInterface
        fun requestExternalImport() {
            runOnUiThread {
                val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
                    type = "application/json"
                    addCategory(Intent.CATEGORY_OPENABLE)
                }
                filePickerLauncher.launch(intent)
            }
        }
    }
}