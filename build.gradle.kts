import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10" apply false
    kotlin("multiplatform") version "1.7.10" apply false
    `java-library`
    id("com.github.johnrengelman.shadow") version "7.1.2" apply false
}

group = "net.gloryx"
version = "0.2.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://dev.gloryx.net/main")
    maven("https://libraries.minecraft.net/")
}

subprojects {
    repositories {
        mavenCentral()
        maven("https://dev.gloryx.net/main")
        maven("https://libraries.minecraft.net/")
    }
}

dependencies {

}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}