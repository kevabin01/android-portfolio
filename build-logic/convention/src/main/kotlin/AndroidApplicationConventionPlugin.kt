import com.android.build.api.dsl.ApplicationExtension
import com.kevabin.buildlogic.PortfolioConfig
import com.kevabin.buildlogic.configureKotlinJvmTarget
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

/**
 * Configuración común de cada app del portafolio (módulos apps/<app>/app).
 * Cada app solo declara lo suyo: namespace, applicationId, versión y features.
 */
class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            // AGP 9 trae Kotlin integrado: no se aplica org.jetbrains.kotlin.android.
            pluginManager.apply("com.android.application")

            extensions.configure<ApplicationExtension> {
                compileSdk {
                    version = release(PortfolioConfig.COMPILE_SDK)
                }
                defaultConfig {
                    minSdk = PortfolioConfig.MIN_SDK
                    targetSdk = PortfolioConfig.TARGET_SDK
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }
                compileOptions {
                    sourceCompatibility = PortfolioConfig.JAVA_VERSION
                    targetCompatibility = PortfolioConfig.JAVA_VERSION
                }
            }
            configureKotlinJvmTarget()
        }
    }
}
