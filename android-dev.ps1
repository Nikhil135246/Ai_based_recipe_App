# Android App Development Helper Script
# This script helps you build, install, and run your Android app from VS Code

param(
    [Parameter(Position=0)]
    [ValidateSet("build", "install", "run", "clean", "launch", "logs", "apk")]
    [string]$Action = "run"
)

Write-Host "=== Nik's Recipes App - Development Helper ===" -ForegroundColor Green

switch ($Action) {
    "build" {
        Write-Host "Building the app..." -ForegroundColor Yellow
        .\gradlew assembleDebug
    }
    "install" {
        Write-Host "Installing the app..." -ForegroundColor Yellow
        .\gradlew installDebug
    }
    "run" {
        Write-Host "Building and installing the app..." -ForegroundColor Yellow
        .\gradlew installDebug
        if ($LASTEXITCODE -eq 0) {
            Write-Host "Launching the app..." -ForegroundColor Yellow
            adb shell am start -n com.example.niksracipes/.MainActivity
        }
    }
    "clean" {
        Write-Host "Cleaning the project..." -ForegroundColor Yellow
        .\gradlew clean
    }
    "launch" {
        Write-Host "Launching the app..." -ForegroundColor Yellow
        adb shell am start -n com.example.niksracipes/.MainActivity
    }
    "logs" {
        Write-Host "Showing app logs (press Ctrl+C to stop)..." -ForegroundColor Yellow
        adb logcat | Select-String "niksracipes"
    }
    "apk" {
        Write-Host "Building APK for sharing..." -ForegroundColor Yellow
        .\gradlew assembleDebug
        if ($LASTEXITCODE -eq 0) {
            $apkSource = "app\build\outputs\apk\debug\app-debug.apk"
            $apkDestination = "Nik's-Recipes-App.apk"
            
            if (Test-Path $apkSource) {
                Copy-Item $apkSource $apkDestination -Force
                Write-Host "✅ APK ready for sharing!" -ForegroundColor Green
                Write-Host "📱 APK Location: $(Get-Location)\$apkDestination" -ForegroundColor Cyan
                Write-Host "📁 Opening folder..." -ForegroundColor Yellow
                explorer.exe .
            } else {
                Write-Host "❌ APK not found. Build may have failed." -ForegroundColor Red
            }
        }
    }
}

Write-Host "Done!" -ForegroundColor Green
