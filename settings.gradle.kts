pluginManagement {
    // Los convention plugins (portfolio.*) se compilan desde build-logic.
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

// Permite escribir projects.apps.expenses.domain en lugar de project(":apps:expenses:domain").
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "android-portfolio"

// App Gastos (com.kevabin.expenses)
include(":apps:expenses:app")
include(":apps:expenses:domain")
include(":apps:expenses:data")
