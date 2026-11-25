// Declara (sin aplicar) los plugins que usan los módulos y los convention plugins,
// para que todos compartan una sola versión de cada uno.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.jvm) apply false
}
