import com.android.build.api.dsl.LibraryExtension
import com.kevabin.buildlogic.PortfolioConfig
import com.kevabin.buildlogic.configureKotlinJvmTarget
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

/**
 * Configuración común de los módulos de librería Android
 * (por ejemplo apps/<app>/data y, más adelante, los módulos de core).
 */
class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.library")

            extensions.configure<LibraryExtension> {
                compileSdk {
                    version = release(PortfolioConfig.COMPILE_SDK)
                }
                defaultConfig {
                    minSdk = PortfolioConfig.MIN_SDK
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
