plugins {
    // Kotlin puro (JVM): aquí no existe el SDK de Android.
    alias(libs.plugins.portfolio.jvm.library)
}

dependencies {
    // domain no depende de ningún otro módulo: todas las flechas apuntan hacia aquí.
    testImplementation(libs.junit)
}
