# Word Assistant

[中文](./README.md)

A simple and efficient Android word learning app that supports importing JSON format word lists, managing words by list groups, and providing search, marking, and other features.

## Features

- **JSON Word List Import**: Supports importing standard JSON format word data from external sources
- **List Grouping**: Automatically groups words by the "list" field
- **Word Search**: Supports searching by word or Chinese meaning
- **Word Marking**: Can mark important words, marking status is persistent
- **Expand/Collapse**: Click on words to expand/collapse meanings
- **Pagination**: Supports switching between different word lists
- **Responsive Design**: Adapts to different screen sizes

## Technology Stack

- **Android Kotlin**: Native Android development
- **WebView**: Loads HTML interface
- **HTML/CSS/JavaScript**: Front-end interface
- **JSON**: Data storage format

## Project Structure

```
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/words/app/    # Main code
│   │   │   ├── assets/                # Static resources
│   │   │   ├── res/                   # Android resources
│   │   │   └── AndroidManifest.xml    # App manifest
│   │   ├── androidTest/               # Instrumented tests
│   │   └── test/                      # Unit tests
│   ├── build.gradle.kts               # App build configuration
│   └── proguard-rules.pro             # Code obfuscation rules
├── gradle/
│   ├── wrapper/                       # Gradle wrapper
│   └── libs.versions.toml             # Dependency version management
├── build.gradle.kts                   # Project build configuration
├── settings.gradle.kts                # Project settings
├── gradle.properties                  # Gradle properties
├── gradlew                            # Gradle execution script
├── gradlew.bat                        # Windows Gradle execution script
├── README.md                          # Chinese documentation
└── README_EN.md                       # English documentation
```

## Quick Start

### Environment Requirements

- Android Studio
- Android SDK
- Java Development Kit (JDK)

### Build Steps

1. Clone the project locally
   ```bash
   git clone https://github.com/admin6a/word-assistant.git
   ```

2. Open Android Studio and select "Open an existing project"

3. Select the project directory

4. Wait for Gradle synchronization to complete

5. Build and run the project

### Import Word List

1. Prepare a JSON format word list with the following format:
   ```json
   [
    { "word": "apple", "meaning": "n. apple", "list": "list1" },

    { "word": "banana", "meaning": "n. banana", "list": "list2" },
    { "word": "orange", "meaning": "n. orange", "list": "list2" },

    { "word": "mango", "meaning": "n. mango", "list": "list3" }
   ]
   ```

2. After starting the app, click the "Import JSON Word List" button

3. Select the prepared JSON file

4. The app will automatically load and display words by groups

## Usage Instructions

- **View Word Meanings**: Click on word items to expand/collapse meanings
- **Mark Words**: Click checkboxes to mark words
- **Search Words**: Enter keywords in the search box to search
- **Switch Lists**: Use the bottom navigation bar to switch between different word lists
- **Clear Marks**: Click the "Clear Current Page Marks" button to cancel all marks on the current page
- **Expand/Collapse All**: Click the "Expand All"/"Collapse All" button

## Data Storage

- Word data is stored in the `words_data.json` file in the app's internal storage
- Marking status is stored in WebView's localStorage
- Last viewed list is stored in Android SharedPreferences

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details

## Contributing

Welcome to submit issues and Pull Requests!

## Contact

- Project Address: https://github.com/admin6a/word-assistant
- Issue Feedback: https://github.com/admin6a/word-assistant/issues

---

**Enjoy the fun of learning words!** 📚✨