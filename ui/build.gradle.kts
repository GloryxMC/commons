import org.jetbrains.kotlin.utils.addToStdlib.safeAs

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    `maven-publish`
    `java-library`
    java
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))

group = "net.gloryx.cat"
version = rootProject.version

repositories {
    mavenCentral()
    google()
    maven("https://maven.google.com/")
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}
private val composeVersion = extra["compose.version"] as String
private val compose = org.jetbrains.compose.ComposePlugin.Dependencies
val common = listOf(compose.runtime, compose.ui, compose.foundation, compose.material, compose.uiTooling, compose.preview)
val desktop = listOf(
    compose.desktop.currentOs,
    "org.jetbrains.compose.foundation:foundation-desktop:$composeVersion",
    "org.jetbrains.compose.ui:ui-geometry-desktop:$composeVersion",
    "org.jetbrains.compose.ui:ui-graphics-desktop:$composeVersion"
)

val cat = project(":core")
kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
        withJava()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":core"))
                common.forEach(this::api)
            }
        }
        val jvmMain by getting {
            dependencies {
                desktop.forEach(this::api)
                api("com.typesafe:config:+")
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
            maven("https://dev.gloryx.net/snap") {
                credentials(PasswordCredentials::class) {
                    username = System.getenv("GLORYX_USERNAME")
                    password = System.getenv("GLORYX_PASSWORD")
                }
            }
        }
    }
}

