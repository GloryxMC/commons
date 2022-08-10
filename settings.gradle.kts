pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://repo.papermc.io/repository/maven-public/")
        maven("https://repo.spongepowered.org/repository/maven-public/")
        mavenCentral()
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "org.spongepowered.mixin") useModule("org.spongepowered:mixingradle:${requested.version ?: "0.7.+"}")
        }
    }
}

rootProject.name = "commons"
include(":core")
include(":minecraft")
