import com.kevabin.buildlogic.PortfolioConfig
import com.kevabin.buildlogic.configureKotlinJvmTarget
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.kotlin.dsl.configure

/**
 * Módulos de Kotlin puro (JVM), como apps/<app>/domain.
 * No aplica ningún plugin de Android, así que el SDK de Android
 * no está disponible: importar android.* ahí no compila.
 */
class JvmLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("org.jetbrains.kotlin.jvm")

            extensions.configure<JavaPluginExtension> {
                sourceCompatibility = PortfolioConfig.JAVA_VERSION
                targetCompatibility = PortfolioConfig.JAVA_VERSION
            }
            configureKotlinJvmTarget()
        }
    }
}
