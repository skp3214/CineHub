
# 🎬 CineHub Movie List App - MVVM Architecture🔍

CineHubMovieListApp is a Jetpack Compose-based Android application that allows users to explore a wide variety of movies, categorized by genres such as Fantasy, Thriller, Horror, Drama, Romance, Crime, Comedy, Animation, Action, Adventure, and Biography. The app provides detailed information about each movie, including its plot, runtime, genres, cast, release date, and director.
## Project Demo 💻 

https://github.com/user-attachments/assets/66ca6f0d-1201-4458-812f-41b97f8474b9

## Features

- **Movie Listings**: Browse a vast collection of movies categorized by genres. Each category is displayed in a horizontal scroll view for easy navigation.
- **Movie Details**: Click on any movie to view detailed information, including plot, runtime, genres, cast, release date, and director.
- **Responsive UI**: The app utilizes Jetpack Compose for a modern, responsive UI, ensuring a seamless experience across different screen sizes.
- **Image Loading**: Movie posters are efficiently loaded using Coil, a Kotlin-first image loading library.
- **Date Formatting**: Handles complex date formatting, converting raw JSON date objects into human-readable formats.

## Screenshots
![image](https://github.com/user-attachments/assets/6ab914b0-efe9-45ce-b015-91fe85796e55)

![image](https://github.com/user-attachments/assets/655ba35a-a373-4d11-b500-a6e988f14622)

![image](https://github.com/user-attachments/assets/bca866cd-7d9d-4875-be90-d765247db573)

![image](https://github.com/user-attachments/assets/7540f4cf-25fc-41d7-9f13-f36b192a25f6)


## Tech Stack

- **Kotlin**: The primary programming language for Android development.
- **Jetpack Compose**: Modern Android UI toolkit for building native UIs.
- **Coil**: A fast and lightweight image loading library for Android.
- **Material Design 3**: Utilized for styling and theming the UI.
- **Gson**: A Java library used for converting JSON into Java objects.

## Project Structure

```bash
├── app
│   ├── src
│   │   ├── main
│   │   │   ├── java/com/skp3214/cinehubmovielistapp
│   │   │   │   ├── MainActivity.kt
│   │   │   │   ├── Movie.kt
│   │   │   │   ├── MovieListScreen.kt
│   │   │   │   ├── MovieDetailScreen.kt
│   │   │   │   ├── DateUtils.kt
│   │   │   │   ├── Utils.kt
│   │   ├── res
│   │   │   ├── layout
│   │   │   ├── values
│   │   │   ├── raw
│   │   │   │   ├── movie.json
│   └── build.gradle
├── README.md
```

## Installation

To run this project locally, follow these steps:

1. **Clone the repository**:

   ```bash
   git clone https://github.com/yourusername/CineHub.git
   ```

2. **Open the project** in Android Studio.

3. **Sync the project with Gradle** to download all dependencies.

4. **Run the app** on an emulator or physical device.

## Dependencies

Make sure you have the following dependencies in your `build.gradle`:

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
    implementation (libs.coil.compose)

}
```

## How to Use

1. **Browse Movies**: Start the app and scroll through the different genres to browse movies.
2. **View Details**: Click on any movie to view more detailed information about it.
3. **Navigation**: The app uses simple navigation to move between the movie list and detail screens.

## Future Enhancements

- **Search Functionality**: Add a search bar to allow users to find movies by title.
- **Favorites**: Implement a feature to let users mark movies as favorites and access them quickly.
- 
## Contributing

If you'd like to contribute to this project, feel free to fork the repository and submit a pull request. You can also open an issue if you find any bugs or have any suggestions for improvements.

## Contact

For any inquiries or suggestions, please reach out to **Sachin Prajapati** at **skprajapati3214@gmail.com**.

---
