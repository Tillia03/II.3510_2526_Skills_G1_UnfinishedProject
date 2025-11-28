plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.lenadeoliveira.gradleup"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.lenadeoliveira.gradleup"
        minSdk = 21
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    flavorDimensions += listOf("paidMode", "minSdk")

    productFlavors {
        create("free") {
            dimension = "paidMode"
            applicationIdSuffix = ".free"
            // TODO: to be completed by students (versionNameSuffix, etc.)
        }
        create("paid") {
            dimension = "paidMode"
            applicationIdSuffix = ".paid"
            // TODO: to be completed by students
        }

        create("minSdk21") {
            dimension = "minSdk"
            minSdk = 21
        }
        create("minSdk30") {
            dimension = "minSdk"
            minSdk = 30
        }
    }



    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}

tasks.register("generateApkReport") {
    group = "automation"
    description = "Create a report listing the generated APK files."

    doLast {
        // TODO (for students):
        // Goal:
        //   Implement this task so that it generates a summary file
        //   listing all APKs produced by the project.
        //
        // Requirements:
        //   1) Look for all APK files under:
        //        build/outputs/apk/
        //      (you can start from:  val apkDir = file("$buildDir/outputs/apk"))
        //
        //   2) For each APK file, retrieve:
        //        - file name        (file.name)
        //        - file size (bytes) (file.length())
        //        - last modified date
        //          (tip: file.lastModified() + java.time.Instant / LocalDateTime)
        //
        //   3) Create or overwrite the file:
        //        app/apk_report.txt
        //      and write ONE line per APK, for example:
        //        app-free-minSdk21-debug.apk | 1 234 567 bytes | 2025-11-30T12:34:56Z
        //
        //   4) At the end, print a message in the console, e.g.:
        //        "APK report generated at: <absolute path>"
        //
        // Constraints:
        //   - Do NOT change the task name ("generateApkReport") or its group.
        //   - You are free to use Kotlin standard library (walkTopDown, use, etc.).
        //
        // Hint (optional):
        //   - apkDir.walkTopDown().filter { it.extension == "apk" } can help you
        //     iterate over all APKs.
    }
}
