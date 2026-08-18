# Word Assistant

[中文](./README.md)

A simple and efficient Android word learning app that supports importing JSON format word lists, managing words by list groups, and providing search, marking, and review features.

## Features

- **JSON Word List Import**: Supports importing standard JSON format word data from external sources.
- **List Grouping**: Automatically groups words by the "list" field.
- **Study Mode**:
    - **Word Search**: Supports searching by word or Chinese meaning.
    - **Word Marking**: Can mark important words, marking status is persistent.
    - **Expand/Collapse**: Click on words to expand/collapse meanings.
    - **Pagination**: Supports switching between different word lists.
- **Review Mode**:
    - **Random Test**: Multiple-choice tests with a randomized order for the current list.
    - **Smart Distractors**: Automatically extracts distractors from the entire word library.
    - **Instant Feedback**: Shows correctness immediately; automatically jumps to the next question on correct answers.
    - **State Memory**: Supports reviewing the previous question and its answer status during the review session.
- **Dark Mode Support**: Perfectly supports the system dark mode.
- **Responsive Design**: Adapts to different screen sizes.

## Technology Stack

- **Android Kotlin**: Native Android development.
- **WebView**: Loads HTML interface.
- **HTML/CSS/JavaScript**: Front-end interface logic.
- **JSON**: Data storage format.

## Project Structure

```
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/words/app/    # Main code
│   │   │   ├── assets/                # Static resources (index.html, etc.)
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
├── README.md                          # Chinese documentation
└── README_EN.md                       # English documentation
```

## Quick Start

### Environment Requirements

- Android Studio
- Android SDK
- Java Development Kit (JDK) 17+

### Build Steps

1. Clone the project locally:
   ```bash
   git clone https://github.com/admin6a/word-assistant.git
   ```

2. Open Android Studio and select "Open an existing project".

3. Select the project directory.

4. Wait for Gradle synchronization to complete.

5. Build and run the project.

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

2. After starting the app, click the "Import JSON Word List" button.

3. Select the prepared JSON file.

4. The app will automatically load and display words grouped by list.

## Usage Instructions

- **Switch Modes**: Click "Go Review" at the bottom to enter test mode, and click "Go Study" at the top to return to list mode.
- **Study Mode**: Click word items to expand meanings, and check the box to mark words.
- **Review Mode**: Select the correct meaning from four options. The system will automatically record your progress.
- **Search Words**: Enter keywords in the search box in Study Mode (supports fuzzy matching).
- **Clear Marks**: Click "Clear Current Page Marks" to reset the check status for the current list.

## Data Storage

- Word Data: Stored in `words_data.json` in the app's internal storage.
- Marking Status: Stored in the WebView's `localStorage`.
- Configuration: The last viewed list name is stored in Android `SharedPreferences`.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contributing

Welcome to submit Issues and Pull Requests!

## Contact

- Project Address: https://github.com/admin6a/word-assistant
- Issue Feedback: https://github.com/admin6a/word-assistant/issues

---

**Enjoy the fun of learning words!** 📚✨