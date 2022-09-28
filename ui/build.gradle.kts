import org.jetbrains.kotlin.utils.addToStdlib.safeAs

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose") version "+"
    `maven-publish`
    java
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))

group = "net.gloryx.cat"
version = "0.1.52-SNAPSHOT"

repositories {
    mavenCentral()
    google()
    maven("https://maven.google.com/")
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}
private val compose = org.jetbrains.compose.ComposePlugin.Dependencies
val common = listOf(compose.runtime, compose.ui, compose.foundation, compose.material, compose.uiTooling)
val desktop = listOf(
    compose.desktop.currentOs,
    "org.jetbrains.compose.foundation:foundation-desktop:1.1.0",
    "org.jetbrains.compose.ui:ui-geometry-desktop:1.1.0",
    "org.jetbrains.compose.ui:ui-graphics-desktop:1.1.0"
)

val cat = project(":core")
kotlin {
    jvm {
        compilations.all {

            kotlinOptions.jvmTarget = "17"
        }
        withJava()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":core"))
                common.forEach(this::implementation)
            }
        }
        val jvmMain by getting {
            dependencies {
                desktop.forEach(this::implementation)
                implementation("com.typesafe:config:+")
            }
        }
    }

    publishing {
        publications {
            configureEach {
                safeAs<MavenPublication>()?.apply {
                    println(groupId)
                    println(this.artifactId)
                }
            }
        }
        repositories {
            mavenLocal()
        }
    }
}

