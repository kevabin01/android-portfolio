plugins {
    // SDKs, Java 17 y test runner vienen del convention plugin (build-logic).
    alias(libs.plugins.portfolio.android.application)
}

android {
    namespace = "com.kevabin.expenses"

    defaultConfig {
        applicationId = "com.kevabin.expenses"
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        release {
            optimization {
                enable = true
                packageScope = setOf("androidx.**", "kotlin.**", "kotlinx.**")
            }
        }
    }
}

dependencies {
    implementation(projects.apps.expenses.domain)
    implementation(projects.apps.expenses.data)

    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}
