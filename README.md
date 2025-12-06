# 🎬 **CineHub Movie List App — MVVM Architecture** 🔍

**CineHub Movie List App** is a Jetpack Compose-based Android application that lets users browse a wide variety of movies. Movies are organized by genres such as **Fantasy, Thriller, Horror, Drama, Romance, Crime, Comedy, Animation, Action, Adventure, and Biography**.
Users can view rich details about each movie, including **plot, runtime, genres, cast, release date, and director**.

---
## 📸 Screenshots

<img width="2245" height="1587" alt="cinehub" src="https://github.com/user-attachments/assets/a3319b53-3624-426b-a53c-e4f29f67421f" />

---
## 🚀 Project Demo

▶️ Watch the demo:

https://github.com/user-attachments/assets/a08c0671-f4b9-432d-9a1e-dde07a209feb

---

## ✨ Features

* **Movie Library**
  Browse movies by categories, displayed in horizontal scrollable lists.

* **Detailed Movie View**
  Tap any movie to view:

  * Plot
  * Runtime
  * Genre list
  * Cast & Crew
  * Release date
  * Director

* **Modern UI with Compose**
  Responsive, smooth, and adaptive layout across screen sizes.

* **Fast Poster Loading**
  Images are efficiently loaded using **Coil**.

* **Smart Date Formatting**
  Raw JSON dates are converted into clean, readable formats.

---

## 🛠️ Tech Stack

* **Kotlin**
* **Jetpack Compose**
* **Material Design 3**
* **Coil (Image Loading)**
* **Gson (JSON Parsing)**

---

## 📁 Project Structure

```
├── app
│   ├── src/main/java/com/skp3214/cinehubmovielistapp
│   │   ├── models
│   │   │   └── Movies.kt
│   │   ├── navigation
│   │   │   └── MovieAppNavHost.kt
│   │   ├── repository
│   │   │   └── MovieRepository.kt
│   │   ├── utils
│   │   │   ├── DateUtils.kt
│   │   │   └── Utils.kt
│   │   ├── view
│   │   │   ├── MovieDetailScreen.kt
│   │   │   ├── MovieSearchComponent.kt
│   │   │   ├── SearchResultScreen.kt
│   │   │   └── MovieListScreen.kt
│   │   ├── viewmodel
│   │   │   └── MovieViewModel.kt
│   │   └── MainActivity.kt
│   ├── res/raw
│   │   └── movie.json
│   └── build.gradle
├── README.md
```

---

## 🔧 Installation

1. **Clone the repository**

```bash
git clone https://github.com/skp3214/CineHub.git
```

2. **Open in Android Studio**

3. **Sync Gradle**

4. **Run on Emulator or Device**

---

## 📦 Dependencies

Make sure your `build.gradle` includes:

```gradle
dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.runtime.ktx)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.protolite.well.known.types)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation(libs.gson)
    implementation(libs.coil.compose)
}
```

---

## 🧭 How to Use

✔️ Launch the app and browse movies by genre
✔️ Tap any movie for full details
✔️ Navigate easily between screens with Compose Navigation

---

## 🔮 Future Enhancements

* **Favorites List**
  Allow users to save movies they love.

* **Extended Search** ✔️ *(Search is now implemented)*
  Search by title and view matching results.

---

## 🤝 Contributing

Contributions are welcome!
Feel free to **fork**, make changes, and open a **pull request**.
You can also report issues or suggest improvements.

---

## 📬 Contact

👤 **Sachin Prajapati**
📧 **[skprajapati3214@gmail.com](mailto:skprajapati3214@gmail.com)**
