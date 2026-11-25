package com.kevabin.buildlogic

import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

/** Valores compartidos por todos los módulos del portafolio. */
internal object PortfolioConfig {
    const val COMPILE_SDK = 37
    const val TARGET_SDK = 37
    const val MIN_SDK = 26
    val JAVA_VERSION = JavaVersion.VERSION_17
    val KOTLIN_JVM_TARGET = JvmTarget.JVM_17
}

/** El bytecode de Kotlin debe coincidir con el de Java (17) en todos los módulos. */
internal fun Project.configureKotlinJvmTarget() {
    tasks.withType<KotlinJvmCompile>().configureEach {
        compilerOptions.jvmTarget.set(PortfolioConfig.KOTLIN_JVM_TARGET)
    }
}
