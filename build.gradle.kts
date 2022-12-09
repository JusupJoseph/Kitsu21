// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id ("com.android.application") version "7.3.1" apply false
    id ("com.android.library") version "7.3.1" apply false
    kotlin("android") version "1.7.20" apply false

    // Hilt
    id("com.google.dagger.hilt.android") version "2.44" apply false

    // Navigation Safe Args
    id("androidx.navigation.safeargs") version "2.5.3" apply false
}