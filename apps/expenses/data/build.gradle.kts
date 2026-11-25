plugins {
    // Librería Android: aquí vivirán Room, las implementaciones de repositorio y los mappers.
    alias(libs.plugins.portfolio.android.library)
}

android {
    namespace = "com.kevabin.expenses.data"
}

dependencies {
    // data implementa las interfaces de repositorio que define domain.
    implementation(projects.apps.expenses.domain)

    testImplementation(libs.junit)
}
