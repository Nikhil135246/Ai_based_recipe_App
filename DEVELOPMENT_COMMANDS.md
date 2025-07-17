# Android Development Commands - VS Code Workflow

## 🚀 Quick Command Sequence for Changes

When you make changes to your Kotlin Android app, follow this sequence:

### Method 1: VS Code Tasks (Recommended)
1. Make your code changes
2. Ctrl+Shift+P → "Tasks: Run Task" → "Build and Run Android App"
3. Wait for installation to complete
4. App automatically launches with changes

### Method 2: PowerShell Script (Fastest)
After making changes, run: .\android-dev.ps1

Or specific actions:
.\android-dev.ps1 build    # Build only
.\android-dev.ps1 install  # Build + Install
.\android-dev.ps1 run      # Build + Install + Launch
.\android-dev.ps1 launch   # Launch only (if already installed)

### Method 3: Manual Gradle Commands (Step by Step)

#### When to Use Manual Commands:
- When you want to see detailed build output
- When debugging build issues
- When you need to understand what each step does
- When the script fails and you need granular control

#### The Two-Step Manual Process:
Step 1: Build the app
.\gradlew assembleDebug

Step 2: Install on device/emulator  
.\gradlew installDebug

Step 3: Launch the app
adb shell am start -n com.example.niksracipes/.MainActivity

#### Why Two Commands Instead of One:
- assembleDebug: Compiles your Kotlin code, processes resources, creates the APK file
- installDebug: Takes the built APK and installs it on your connected device/emulator
- These are separate because you might want to build without installing, or install a previously built APK

## 🔧 When to Use Different Approaches

### Use .\android-dev.ps1 when:
- Making small code changes (UI updates, logic fixes)
- You want everything done automatically
- You're in rapid development mode
- You don't need to see detailed build logs

### Use Manual Gradle Commands when:
- First time building the project
- After major changes (dependencies, build config)
- When debugging build errors
- When you want to see step-by-step progress
- When the automated script is not working

### Use VS Code Tasks when:
- You prefer GUI over command line
- You want to stay within VS Code interface
- You're new to Android development

## 🔧 Troubleshooting Commands

### If Build Fails
Clean and rebuild:
.\gradlew clean
.\gradlew assembleDebug

### If Files Are Locked
Stop Gradle daemon:
.\gradlew --stop

Force remove build directory:
Remove-Item -Path "app\build" -Recurse -Force -ErrorAction SilentlyContinue

Rebuild:
.\gradlew assembleDebug

### Check Device Connection
List connected devices:
adb devices

If no devices, restart ADB:
adb kill-server
adb start-server

## 📱 Development Workflow Scenarios

### Scenario 1: Small UI Changes (Daily Development)
1. Edit TextView text, button colors, layout margins
2. Save files
3. Run: .\android-dev.ps1
4. Test immediately

### Scenario 2: Logic Changes (Code Updates)
1. Update Kotlin functions, add new features
2. Save files  
3. Run: .\android-dev.ps1
4. Test functionality

### Scenario 3: Major Changes (Dependencies, Resources)
1. Add new dependencies in build.gradle.kts
2. Add new images, update AndroidManifest.xml
3. Clean first: .\gradlew clean
4. Build: .\gradlew assembleDebug
5. Install: .\gradlew installDebug
6. Launch: adb shell am start -n com.example.niksracipes/.MainActivity

### Scenario 4: Build Errors or Issues
1. Try clean build first: .\gradlew clean
2. Build step by step: .\gradlew assembleDebug
3. Check error messages carefully
4. Fix issues in code
5. Install: .\gradlew installDebug

### Scenario 5: Fresh Start After Problems
1. Stop all processes: .\gradlew --stop
2. Clean everything: .\gradlew clean
3. Remove build folder: Remove-Item -Path "app\build" -Recurse -Force
4. Start fresh: .\gradlew assembleDebug
5. Install: .\gradlew installDebug

## ⚡ Hot Reload Alternatives

Since VS Code doesn't have built-in hot reload, use these for faster development:

### File Watcher (Future Setup)
In tasks.json - auto-build on save:
"runOptions": { "runOn": "fileSave" }

### Continuous Build
Watches for changes and auto-builds:
.\gradlew --continuous assembleDebug

## 📋 Quick Reference

| Action | Command | When to Use |
|--------|---------|-------------|
| **Build & Run** | .\android-dev.ps1 | Most common, daily development |
| **Build Only** | .\gradlew assembleDebug | Want to check compilation only |
| **Install** | .\gradlew installDebug | APK already built, just install |
| **Launch** | adb shell am start -n com.example.niksracipes/.MainActivity | App installed, just launch |
| **Clean** | .\gradlew clean | Before major rebuilds |
| **Logs** | adb logcat | Debugging runtime issues |
| **Devices** | adb devices | Check device connection |

## 🎯 Most Common Sequences

### For 90% of Development (Small Changes):
.\android-dev.ps1

### For Build Issues or Major Changes:
.\gradlew clean
.\gradlew assembleDebug  
.\gradlew installDebug

### For Quick Testing (App Already Built):
.\android-dev.ps1 launch

## 🔍 Understanding the Build Process

### What assembleDebug Does:
- Compiles Kotlin source code
- Processes XML layouts and resources
- Merges AndroidManifest.xml
- Creates APK file in app/build/outputs/apk/debug/

### What installDebug Does:
- Takes the built APK file
- Transfers it to connected device/emulator
- Installs the app (replaces previous version)
- App appears in device app drawer

### What Launch Command Does:
- Starts the MainActivity of your app
- Brings app to foreground
- Does not rebuild or reinstall
