pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://repo.papermc.io/repository/maven-public/")
        maven("https://repo.spongepowered.org/repository/maven-public/")
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        mavenCentral()
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "org.spongepowered.mixin") useModule("org.spongepowered:mixingradle:${requested.version}")
        }
    }
    plugins {
        id("org.jetbrains.compose").version(extra["compose.version"] as String) apply false
    }
}

rootProject.name = "commons"
include(":core")
include(":minecraft")
include(":mods:forge")
//findProject(":mods:forge")?.name = "forge"
include("ui")
