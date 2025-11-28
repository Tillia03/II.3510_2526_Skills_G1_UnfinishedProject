##  Exercise – TODO for Students

This project is an *Unfinished Project (UP)*.  
Your job is to complete the Gradle configuration and the custom task.

### 1. Product Flavors (free / paid)

In `app/build.gradle.kts`:

- Complete the **`free`** flavor:
    - Add a `versionNameSuffix` so that the version looks like `1.0-free`.
- Complete the **`paid`** flavor:
    - Add a `versionNameSuffix` (for example `1.0-paid`).
    - (Optional) Make the paid version feel more “production-ready”
      (e.g. different settings in `buildTypes`).

### 2. Implement `generateApkReport` task

In `app/build.gradle.kts`, inside the `generateApkReport` task:

- Scan `build/outputs/apk/` and find all `.apk` files.
- For each APK, collect:
    - its **name**
    - its **size** in bytes
    - its **last modified date/time**
- Write one line per APK into `app/apk_report.txt`.
- Print a message in the console when the report is created.

You can test your work with:

```bash
./gradlew assembleFreeMinSdk21Debug
./gradlew generateApkReport
S
