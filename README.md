# 🍳 AI-Based Recipe App

A modern Android application that combines AI-powered recommendations with an extensive recipe database. Discover, search, and learn to cook your favorite recipes with personalized AI assistance.

## ✨ Features

### 🤖 AI-Powered Chatbot
- **Gemini Integration**: Get recipe suggestions and cooking tips from an AI assistant
- **Real-time Assistance**: Ask questions about ingredients, cooking techniques, and dietary modifications
- **Personalized Recommendations**: Receive tailored recipe suggestions based on your preferences

### 🔍 Smart Recipe Search
- **Full-Text Search**: Quickly find recipes by name or ingredients
- **Search Suggestions**: Browse popular recipes with search history
- **Recipe Details**: View complete instructions, ingredients, and cooking time

### 📂 Category Browsing
- **Organized Categories**: Browse recipes by type (Salads, Main Courses, Drinks, Desserts, etc.)
- **Quick Navigation**: Easy category filtering for faster discovery
- **Popular Recipes**: View trending and most-loved recipes

### 💾 Recipe Management
- **Browse All Recipes**: Explore a comprehensive recipe database
- **Detailed Instructions**: Step-by-step cooking guides
- **Ingredient Lists**: Complete ingredient information with quantities
- **Cooking Duration**: Time estimates for each recipe
- **Category Labels**: Quick identification of recipe types

### 📱 User-Friendly Interface
- **Intuitive Navigation**: Easy-to-use bottom navigation and search
- **Clean Design**: Modern, minimal UI for seamless browsing
- **Fast Performance**: Optimized for smooth user experience

## 📸 App Screenshots

| Home Screen | AI Assistant | Search Screen | Categories |
|---|---|---|---|
| Browse categories and popular recipes | Get AI-powered cooking tips | Find recipes quickly | Explore by food type |

## 🛠️ Technology Stack

- **Language**: Kotlin
- **Platform**: Android
- **UI Framework**: Android XML Layouts
- **API Integration**: 
  - **Gemini AI API**: For intelligent recipe recommendations and cooking advice
  - **Clipdrop API**: For image processing capabilities
- **Database**: Room Database (SQLite)
- **Networking**: Retrofit HTTP Client
- **Architecture**: Activity-based with Adapters pattern

## 📋 Project Structure

```
├── app/
│   ├── src/main/
│   │   ├── java/com/example/niksracipes/
│   │   │   ├── MainActivity.kt           # Entry point
│   │   │   ├── HomeActivity.kt           # Home screen with categories
│   │   │   ├── SearchActivity.kt         # Recipe search screen
│   │   │   ├── CategoryActivity.kt       # Browse by category
│   │   │   ├── RecipeActivity.kt         # Recipe details
│   │   │   ├── GeminiActivity.kt         # AI chatbot screen
│   │   │   ├── Recipe.kt                 # Data model
│   │   │   ├── AppDatabase.kt            # Room database setup
│   │   │   ├── Dao.kt                    # Database queries
│   │   │   ├── RetrofitInstance.kt       # API client setup
│   │   │   └── Adapters.kt               # RecyclerView adapters
│   │   └── res/
│   │       ├── layout/                   # XML layout files
│   │       ├── drawable/                 # Images and drawables
│   │       └── values/                   # Strings and colors
│   └── build.gradle.kts                  # Dependencies
└── README.md
```

## 🚀 Getting Started

### Prerequisites
- Android Studio (latest version recommended)
- Android SDK API level 24 or higher
- Gemini API key (get from [Google AI Studio](https://aistudio.google.com/app/apikey))

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/Nikhil135246/Ai_based_recipe_App.git
   cd Ai_based_recipe_App
   ```

2. **Open in Android Studio**
   - Open Android Studio
   - Select "Open an existing Android Studio project"
   - Navigate to the cloned repository

3. **Add API Keys**
   - Obtain your Gemini API key
   - Add it to your project configuration or AndroidManifest.xml

4. **Build and Run**
   ```bash
   ./gradlew assembleDebug
   ./gradlew installDebug
   ```

### Development Commands

**Quick Build & Run** (Recommended)
```powershell
.\android-dev.ps1
```

**Manual Build Process**
```bash
./gradlew clean                    # Clean build files
./gradlew assembleDebug            # Build APK
./gradlew installDebug             # Install on device/emulator
```

## 🎯 How to Use

1. **Home Screen**: Browse recipe categories and popular recipes
2. **Search**: Use the search bar to find recipes by name
3. **AI Assistant**: Ask the AI chatbot for recipe suggestions and cooking tips
4. **Recipe Details**: Tap any recipe to view ingredients and step-by-step instructions
5. **Categories**: Filter recipes by category (Salads, Mains, Drinks, etc.)

## 🔌 API Integration

### Gemini AI
- Powers the intelligent chatbot feature
- Provides recipe recommendations based on user queries
- Offers cooking tips and ingredient substitutions

### Clipdrop API
- Handles image processing for enhanced recipe information

## 📱 Supported Devices

- **Minimum SDK**: API 24 (Android 7.0)
- **Target SDK**: Latest Android version
- **Screen Sizes**: Phones and Tablets

## 📦 Dependencies

Key libraries used in the project:
- **Retrofit**: REST API client
- **Room**: Local database
- **Gemini API**: AI integration
- **Android Jetpack**: UI and lifecycle management

## 🎨 Design Highlights

- Modern Material Design principles
- Green accent color scheme for food-related branding
- Intuitive bottom navigation for easy access
- Optimized layouts for various screen sizes

## 🤝 Contributing

Contributions are welcome! Feel free to:
- Report issues
- Suggest new features
- Submit pull requests

## 📄 License

This project is open source and available under the MIT License.

## 👤 Author

**Nikhil** - [GitHub Profile](https://github.com/Nikhil135246)

## 📞 Support

For issues, questions, or suggestions, please open an issue on the GitHub repository.

---

**Enjoy exploring recipes and happy cooking! 🍽️**
