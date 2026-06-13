# 🍳 KitchenLexicon

A premium, native Android application built with modern engineering practices, featuring an interactive glossary of kitchen utensils, structural anatomy visualizers, and an offline training quiz game.

<img src="https://raw.githubusercontent.com/Syed-Asad-Abbas-Shah/Syed-Asad-Abbas-Shah/main/assets/antigravity.svg" width="60" align="right" alt="Antigravity Logo" />

> **🚀 Engineered with Antigravity 2.0**
> This project was successfully developed, structured, and compiled with the autonomous assistance of the **Google Antigravity 2.0 AI Engineering Suite**, leveraging Review-driven development for high-fidelity code generation and architecture planning.

---

## ⚡ Technical & Operating Dashboard

<table align="center" width="100%">
  <thead>
    <tr>
      <th align="center" width="50%">📱 Native Android Stack</th>
      <th align="center" width="50%">🐧 Development Environment</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td align="center" valign="top">
        <a href="https://kotlinlang.org" target="_blank">
          <img src="https://cdn.simpleicons.org/kotlin/7F52FF" width="45" height="45" alt="Kotlin" /><br/>
          <sub><b>Kotlin Multiplatform</b></sub>
        </a>
        <br/><br/>
        <a href="https://developer.android.com" target="_blank">
          <img src="https://cdn.simpleicons.org/android/3DDC84" width="45" height="45" alt="Android" /><br/>
          <sub><b>Native Android SDK</b></sub>
        </a>
        <br/><br/>
        <a href="https://gradle.org" target="_blank">
          <img src="https://cdn.simpleicons.org/gradle/02303A" width="45" height="45" alt="Gradle" /><br/>
          <sub><b>Gradle (Kotlin DSL)</b></sub>
        </a>
      </td>
      <td align="center" valign="top">
        <a href="https://cachyos.org" target="_blank">
          <img src="https://cdn.simpleicons.org/cachyos/1DC7B5" width="45" height="45" alt="CachyOS" /><br/>
          <sub><b>CachyOS Linux</b></sub>
        </a>
        <br/><br/>
        <a href="https://archlinux.org" target="_blank">
          <img src="https://cdn.simpleicons.org/archlinux/1793D1" width="45" height="45" alt="Arch Linux" /><br/>
          <sub><b>Arch Engine</b></sub>
        </a>
        <br/><br/>
        <a href="https://kde.org" target="_blank">
          <img src="https://cdn.simpleicons.org/kde/1D99F3" width="45" height="45" alt="KDE Plasma" /><br/>
          <sub><b>KDE Plasma 6.7</b></sub>
        </a>
      </td>
    </tr>
  </tbody>
</table>

---

## ✨ Features

*   **Material 3 Design:** A fully native, modern, responsive UI styled completely with Jetpack Compose (featuring Charcoal-Slate Dark and Warm-Cream Light themes).
*   **Native Text-To-Speech (TTS):** Integration with the Android native `android.speech.tts.TextToSpeech` engine for flawless vocalizations of utensil terms.
*   **Offline Sound Synthesis:** Uses the Android `ToneGenerator` API to synthesize winning chimes and game buzzer beeps dynamically—100% offline.
*   **Custom Canvas Vector Icons:** Crisp, high-fidelity UI shapes rendered programmatically using Jetpack Compose Canvas draw paths (Chef's Knife, Whisk, Skillet).
*   **Interactive Quiz Game:** State-managed multiple-choice game center with scoring streaks and real-time feedback loops.

---

## 🛠️ Tech Stack & Architecture

| Parameter | Specification |
|---|---|
| **Language** | Kotlin (100% Declarative) |
| **UI Framework** | Jetpack Compose |
| **Design System** | Material Design 3 |
| **Build System** | Gradle (Kotlin DSL) |
| **Minimum SDK** | API 26+ (Android 8.0 Oreo) |
| **Target SDK** | API 36 (Android 16) |

---

## 📦 Building and Installation

To compile and build the ready-to-install APK on an Arch-based Linux environment (like CachyOS):

### 1. Install Java Development Kit (JDK)
Ensure you have the OpenJDK 17 or higher installed:
```bash
sudo pacman -S jdk-openjdk
```

### 2. Configure Android SDK
Ensure your environment variables are pointing to the Android SDK directory:
```bash
export ANDROID_HOME=$HOME/Android/Sdk
export PATH=$PATH:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools
```

### 3. Compile the Application
Using the Gradle wrapper (`gradlew`), clean the project and build the debug APK:
```bash
./gradlew clean assembleDebug
```
The generated APK will be available under:
`app/build/outputs/apk/debug/app-debug.apk`

---

<p align="center">
  <sub>Generated with precision. Engineered with <b>Google Antigravity</b>.</sub>
</p>
