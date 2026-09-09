# Word Assistant

[中文](./README.md)

A simple and efficient Android app for learning and memorizing words, featuring a Single Page Application (SPA) architecture with global search, word marking, randomized review, and contextual example learning.

## Features

- **JSON Word List Import**: Supports importing standard JSON word data with complex structures including example sentences and translations.
- **List Grouping**: Automatically identifies and groups words by the `list` field from the JSON data.
- **3-in-1 Integrated Interface (SPA)**:
    - **Study Mode**: Efficient list-based browsing. Click a word to expand its meaning, and mark words for persistent review.
    - **Review Mode**: randomized multiple-choice tests for the current list, featuring instant feedback, smart distractors, and progress memory.
    - **Sentence Mode**: Automatically displays original example sentences. Click to toggle English-Chinese translations for better contextual memorization.
- **Comprehensive Search**: Global fuzzy search across words, meanings, and example sentences (including translations) in Study and Sentence modes.
- **Unified UI Experience**: Card-style top navigation puts pagination, jumping, and mode switching right at your fingertips.
- **Perfect Dark Mode**: Fully supports system-level Dark Mode for a comfortable reading experience.

## Technology Stack

- **Android Kotlin**: Native Android development framework.
- **WebView**: High-performance Web container for the core UI logic.
- **HTML/CSS/JavaScript**: Responsive front-end interface and business logic.
- **JSON**: Standard format for data storage and exchange.

## Project Structure

```
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/words/app/    # Native logic
│   │   │   ├── assets/                # Core assets (index.html)
│   │   │   ├── res/                   # Android resources
│   │   │   └── AndroidManifest.xml    # Manifest
│   └── build.gradle.kts               # Build script
├── README.md                          # Documentation (CN)
└── README_EN.md                       # Documentation (EN)
```

## Quick Start

### Environment Requirements

- Android Studio Flamingo or higher
- JDK 17+

### Build & Run

1. Clone the project.
2. Open and build in Android Studio.
3. Prepare your JSON word list (supports `examples` field):
   ```json
   [
    {
      "word":"apple",
      "meaning":"n. 苹果",
      "examples":{
        "example1":{
          "sentence":"I have an apple.",
          "emeaning":"我拥有一个苹果。"
        }
      },
      "list":"list1"
    }
   ]
   ```
4. Click "Import JSON Word List" in the app to begin.

## Usage Instructions

- **Switch Modes**: Use the top navigation bar to jump between "Study", "Review", and "Sentence" modes seamlessly.
- **Interaction Details**:
    - **Study/Sentence Mode**: Click a word to show its meaning. In Sentence mode, click an English sentence to show/hide its translation.
    - **Review Mode**: Click an option to answer. The system automatically jumps to the next question upon a correct answer.
- **Global Search**: Use the search bar below the top navigation to search through all current lists.
- **Clear Marks**: Click "Clear Page Marks" to reset the mark status for the current list.

## License

This project is licensed under the MIT License.

## Contributing

Welcome to submit Issues and Pull Requests!

## Contact

- Project Address: https://github.com/admin6a/word-assistant
- Issue Feedback: https://github.com/admin6a/word-assistant/issues

---

**Enjoy the fun of learning words!** 📚✨