# 单词助手 (Word Assistant)

[English](./README_EN.md)

一个简洁高效的Android单词学习背诵应用，支持导入JSON格式的单词表，按列表分组管理，提供搜索、标记等功能。

## 功能特性

- **JSON单词表导入**：支持从外部导入标准JSON格式的单词数据
- **按列表分组**：自动按list字段分组显示单词
- **单词搜索**：支持按单词或中文含义搜索
- **单词标记**：可标记重要单词，标记状态持久化
- **展开/折叠**：点击单词可展开/折叠查看含义
- **分页浏览**：支持在不同单词列表间切换
- **响应式设计**：适配不同屏幕尺寸

## 技术栈

- **Android Kotlin**：原生Android开发
- **WebView**：加载HTML界面
- **HTML/CSS/JavaScript**：前端界面
- **JSON**：数据存储格式

## 项目结构

```
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/words/app/    # 主代码
│   │   │   ├── assets/                # 静态资源
│   │   │   ├── res/                   # Android资源
│   │   │   └── AndroidManifest.xml    # 应用清单
│   │   ├── androidTest/               # 仪器化测试
│   │   └── test/                      # 单元测试
│   ├── build.gradle.kts               # 应用构建配置
│   └── proguard-rules.pro             # 代码混淆规则
├── gradle/
│   ├── wrapper/                       # Gradle包装器
│   └── libs.versions.toml             # 依赖版本管理
├── build.gradle.kts                   # 项目构建配置
├── settings.gradle.kts                # 项目设置
├── gradle.properties                  # Gradle属性
├── gradlew                            # Gradle执行脚本
├── gradlew.bat                        # Windows Gradle执行脚本
├── README.md                          # 项目说明文档
└── README_EN.md                       # 英文说明文档
```

## 快速开始

### 环境要求

- Android Studio
- Android SDK
- Java Development Kit (JDK)

### 构建步骤

1. 克隆项目到本地
   ```bash
   git clone https://github.com/admin6a/word-assistant.git
   ```

2. 打开Android Studio，选择"Open an existing project"

3. 选择项目目录

4. 等待Gradle同步完成

5. 构建并运行项目

### 导入单词表

1. 准备JSON格式的单词表，格式如下：
   ```json
   [
    { "word": "apple", "meaning": "n. 苹果", "list": "list1" },

    { "word": "banana", "meaning": "n. 香蕉", "list": "list2" },
    { "word": "orange", "meaning": "n. 橘子", "list": "list2" },

    { "word": "mango", "meaning": "n. 芒果", "list": "list3" }
   ]
   ```

2. 启动应用后，点击"导入 JSON 单词表"按钮

3. 选择准备好的JSON文件

4. 应用会自动加载并分组显示单词

## 使用说明

- **查看单词含义**：点击单词项展开/折叠含义
- **标记单词**：点击复选框标记单词
- **搜索单词**：在搜索框中输入关键词进行搜索
- **切换列表**：使用底部导航栏在不同单词列表间切换
- **清除标记**：点击"清除本页标记"按钮取消当前页所有标记
- **展开/折叠全部**：点击"展开全部"/"折叠全部"按钮

## 数据存储

- 单词数据存储在应用内部存储的`words_data.json`文件中
- 标记状态存储在WebView的localStorage中
- 上次查看的列表存储在Android SharedPreferences中



## 许可证

本项目采用 MIT 许可证 - 详见 [LICENSE](LICENSE) 文件

## 贡献

欢迎提交问题和Pull Request！

## 联系方式

- 项目地址：https://github.com/admin6a/word-assistant
- 问题反馈：https://github.com/admin6a/word-assistant/issues

---

**享受学习单词的乐趣！** 📚✨