plugins {
    `kotlin-dsl`
}

group = "com.kevabin.buildlogic"

dependencies {
    // compileOnly: los plugins de Android y Kotlin solo se necesitan para compilar
    // estos convention plugins; en tiempo de ejecución los aporta el proyecto principal.
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = libs.plugins.portfolio.android.application.get().pluginId
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = libs.plugins.portfolio.android.library.get().pluginId
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("jvmLibrary") {
            id = libs.plugins.portfolio.jvm.library.get().pluginId
            implementationClass = "JvmLibraryConventionPlugin"
        }
    }
}
