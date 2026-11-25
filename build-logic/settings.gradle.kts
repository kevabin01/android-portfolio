// build-logic es un "included build": un proyecto Gradle independiente cuyo
// único producto son los convention plugins que usan los módulos del portafolio.

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
    // Reutiliza el mismo version catalog que el proyecto principal.
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}

rootProject.name = "build-logic"
include(":convention")
