# SampleTranslization


Library Implementation

#Currently on Android 

#Sample Integration Code Usage

fun translateStrings(inputString: String) { lifecycleScope.launch {

        HuggingFaceTranslator(HttpClient()).translateToArabic(inputString).let {
            response-> "Response : $response".also { binding.translatedText.text = it }
        }
    }
}
Gradle Imports

implementation("io.github.shiraz990:shared-android:1.1.0")

or

libs.version.toml [versions] sharedAndroid = "1.1.0" [libraries] shared-android = { module = "io.github.shiraz990:shared-android", version.ref = "sharedAndroid" } build.gradle.kts implementation(libs.shared.android)

Library Repo https://github.com/shiraz990/Translization
