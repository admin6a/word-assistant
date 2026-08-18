# 单词助手 (Word Assistant)

[English](./README_EN.md)

一个简洁高效的Android单词学习背诵应用，支持导入JSON格式的单词表，按列表分组管理，提供搜索、标记、复习等功能。

## 功能特性

- **JSON单词表导入**：支持从外部导入标准JSON格式的单词数据
- **按列表分组**：自动按list字段分组显示单词
- **学习模式**：
    - **单词搜索**：支持按单词或中文含义搜索
    - **单词标记**：可标记重要单词，标记状态持久化
    - **展开/折叠**：点击单词可展开/折叠查看含义
    - **分页浏览**：支持在不同单词列表间快速切换
- **复习模式**：
    - **随机测试**：针对当前列表进行随机顺序的四选一测试
    - **智能干扰项**：从完整单词库中自动抽取干扰项
    - **即时反馈**：答题后立即显示对错，正确时自动跳转下一题
    - **状态记忆**：复习过程中支持查看上一题及其答题状态
- **深色模式适配**：完美支持系统深色模式
- **响应式设计**：适配不同屏幕尺寸

## 技术栈

- **Android Kotlin**：原生Android开发
- **WebView**：加载HTML界面
- **HTML/CSS/JavaScript**：前端界面逻辑处理
- **JSON**：数据存储格式

## 项目结构

```
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/words/app/    # 主代码
│   │   │   ├── assets/                # 静态资源 (index.html 等)
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
├── README.md                          # 项目说明文档
└── README_EN.md                       # 英文说明文档
```

## 快速开始

### 环境要求

- Android Studio
- Android SDK
- Java Development Kit (JDK) 17+

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

- **切换模式**：点击底部的“去复习”进入测试模式，点击顶部的“去学习”返回列表模式。
- **查看模式 (学习)**：点击单词项展开含义，勾选复选框进行标记。
- **测试模式 (复习)**：从四个选项中选出正确含义，系统会自动记录本轮答题状态。
- **搜索单词**：在学习模式搜索框输入关键词，支持模糊匹配。
- **清除标记**：点击“清除本页标记”可重置当前页面的勾选状态。

## 数据存储

- 单词数据：存储在应用内部存储的 `words_data.json`
- 标记状态：存储在 WebView 的 `localStorage` 中
- 配置信息：上次查看的列表名存储在 Android `SharedPreferences`

## 许可证

本项目采用 MIT 许可证 - 详见 [LICENSE](LICENSE) 文件

## 贡献

欢迎提交 Issue 和 Pull Request！

## 联系方式

- 项目地址：https://github.com/admin6a/word-assistant
- 问题反馈：https://github.com/admin6a/word-assistant/issues

---

**享受学习单词的乐趣！** 📚✨