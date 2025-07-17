# Nik's Recipes App - VS Code Development Guide

This guide explains how to develop, build, and run your Android app using VS Code.

## Prerequisites

✅ **You already have these installed:**
- Java 17 (OpenJDK)
- Android SDK with ADB
- Gradle (via wrapper)
- VS Code with Android extensions

## Quick Start

### Method 1: Using VS Code Tasks (Recommended)

1. **Open Command Palette** (`Ctrl+Shift+P`)
2. Type "Tasks: Run Task" and select it
3. Choose from available tasks:
   - **Build and Run Android App** - Builds and installs the app
   - **Build Android App** - Only builds the APK
   - **Install Android App** - Installs the built APK
   - **Launch App on Device** - Starts the app on emulator
   - **Clean Project** - Cleans build artifacts
   - **View App Logs** - Shows app logs in real-time

### Method 2: Using PowerShell Script

Run the development helper script with different actions:

```powershell
# Build, install, and launch the app (default)
.\android-dev.ps1

# Or specify an action
.\android-dev.ps1 build     # Build only
.\android-dev.ps1 install   # Install only
.\android-dev.ps1 launch    # Launch only
.\android-dev.ps1 clean     # Clean project
.\android-dev.ps1 logs      # View logs
```

### Method 3: Using Terminal Commands

```powershell
# Build the app
.\gradlew assembleDebug

# Install the app on emulator/device
.\gradlew installDebug

# Launch the app
adb shell am start -n com.example.niksracipes/.MainActivity

# View app logs
adb logcat | Select-String "niksracipes"
```

## Project Structure

- `app/` - Main application code
- `app/src/main/java/` - Kotlin source files
- `app/src/main/res/` - Resources (layouts, images, etc.)
- `app/build.gradle.kts` - App-level build configuration
- `build.gradle.kts` - Project-level build configuration

## Debugging

1. Set breakpoints in your Kotlin code
2. Use the debug configuration "Launch Android App"
3. Press `F5` to start debugging

## Emulator Management

Check connected devices:
```powershell
adb devices
```

## Troubleshooting

**App not launching?**
- Make sure emulator is running: `adb devices`
- Verify app is installed: `adb shell pm list packages | findstr niksracipes`

**Build errors?**
- Clean and rebuild: Run "Clean Project" task, then "Build Android App"
- Check Java version: `java -version` (should be 17)

**Dependencies issues?**
- Update dependencies in `app/build.gradle.kts`
- Sync project: Run "Build Android App" task

## Current App Features

Based on your dependencies, your app includes:
- Retrofit for API calls
- Room database for local storage
- Material Design components
- Glide for image loading
- Google Generative AI integration
- GIF support

Enjoy coding! 🚀
