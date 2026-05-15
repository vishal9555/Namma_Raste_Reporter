# Namma Raste Reporter

## Overview

Namma Raste Reporter is an Android-based civic issue reporting application that allows users to report road-related problems such as potholes, damaged roads, waterlogging, and other public infrastructure issues directly from their mobile devices.

The application is designed to simplify communication between citizens and local authorities by enabling users to:

* Capture and upload issue images
* Submit road issue details
* Track reported complaints
* Maintain a digital record of civic complaints

This project aims to improve urban infrastructure reporting and encourage citizen participation in smart city initiatives.

---

## Features

### Report Road Issues

Users can:

* Capture issue photos using the device camera
* Upload road issue details
* Submit complaints digitally

### Track Reports

* View previously submitted reports
* Monitor complaint status
* Access issue history

### User-Friendly Interface

* Simple Android UI
* Splash screen support
* RecyclerView-based report listing
* Clean material-style layouts

### Firebase Integration

* Firebase services integration
* Google services configuration support
* Cloud-based backend connectivity

---

## Problem Statement

Road infrastructure problems such as potholes, damaged streets, and drainage issues often remain unresolved because citizens lack a simple and centralized reporting system.

Traditional complaint systems:

* Are time-consuming
* Lack transparency
* Do not provide proper tracking
* Require manual follow-up

Namma Raste Reporter solves this problem by providing a mobile-based platform where users can instantly report and track civic infrastructure issues.

---

## Technologies Used

### Programming Languages

* Kotlin
* XML

### Android Development

* Android Studio
* Android SDK
* RecyclerView
* Activities & Intents
* Material Design Components

### Backend & Services

* Firebase
* Google Services

### Build Tools

* Gradle
* Kotlin DSL (`build.gradle.kts`)

---

## Project Structure

```
NammaRasteReporter/
│
├── app/
│   ├── src/main/java/
│   │   ├── MainActivity.kt
│   │   ├── SplashActivity.kt
│   │   ├── TrackReportActivity.kt
│   │   ├── Report.kt
│   │   └── ReportAdapter.kt
│   │
│   ├── src/main/res/
│   │   ├── layout/
│   │   ├── drawable/
│   │   ├── values/
│   │   └── mipmap/
│   │
│   └── AndroidManifest.xml
│
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

---

## Installation & Setup

### Prerequisites

Before running the project, ensure you have:

* Android Studio installed
* JDK 17 or above
* Android SDK configured
* Git installed
* Firebase project setup

---

### Clone Repository

```bash
git clone https://github.com/vishal9555/Namma_Raste_Reporter.git
```

---

### Open in Android Studio

1. Open Android Studio
2. Select **Open Project**
3. Choose the cloned repository folder
4. Wait for Gradle sync

---

### Firebase Setup

1. Create a Firebase project
2. Download `google-services.json`
3. Place the file inside:

```text
app/google-services.json
```

---

### Run the Application

1. Connect Android device or start emulator
2. Click **Run ▶** in Android Studio
3. Application will build and launch

---

## Screens Included

* Splash Screen
* Main Reporting Screen
* Report Tracking Screen
* Report Card Layout

---

## Future Enhancements

Possible improvements for the project:

* GPS location integration
* Live complaint tracking
* Admin dashboard
* Push notifications
* AI-based road damage detection
* Complaint status updates
* User authentication system
* Map integration
* Multi-language support

---

## Learning Outcomes

This project demonstrates:

* Android application development
* Firebase integration
* RecyclerView implementation
* Kotlin programming
* UI/UX design principles
* Mobile-based civic tech solutions

---

## Use Cases

* Smart city applications
* Civic issue management
* Municipality reporting systems
* Public infrastructure monitoring
* Community-driven complaint systems

---

## Author

### Vishal Shukla

Computer Science Engineering Student

GitHub Profile:
[https://github.com/vishal9555](https://github.com/vishal9555)

---

## License

This project is developed for educational and learning purposes.

---

## Contribution

Contributions, suggestions, and improvements are welcome.

### Steps to Contribute

1. Fork the repository
2. Create a new branch
3. Commit changes
4. Push to your branch
5. Create a Pull Request

---

## Repository Link

[https://github.com/vishal9555/Namma_Raste_Reporter](https://github.com/vishal9555/Namma_Raste_Reporter)
