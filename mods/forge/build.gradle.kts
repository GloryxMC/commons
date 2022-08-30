import net.minecraftforge.gradle.patcher.PatcherExtension
import net.minecraftforge.gradle.patcher.tasks.ReobfuscateJar

plugins {
    kotlin("jvm")
    id("net.minecraftforge.gradle") version "5.1.+"
    id("org.spongepowered.mixin") version "0.7.+"
    `maven-publish`
}

dependencies {
    minecraft("net.minecraftforge:forge:1.16.5-36.2.34")
    implementation(project(":core"))
}

minecraft.apply {
    mappings("snapshot", "20210309-1.16.5")
}
val reobfJar =
    tasks.withType<ReobfuscateJar>().first()

val javadoc: Javadoc by tasks
val javadocJar by tasks.creating(Jar::class) {
    from(javadoc)
    archiveClassifier.set("javadoc")
}

val sourcesJar by tasks.creating(Jar::class) {
    from(sourceSets["main"].allSource.srcDirs + kotlin.sourceSets["main"].kotlin.srcDirs)
    archiveClassifier.set("sources")
}

publishing {
    publications {
        create("mavenForge", MavenPublication::class) {
            artifactId = "forge-1.16"
            groupId = "${rootProject.group}.minecraft"
            version = rootProject.version.toString()

            artifact(reobfJar)

            artifact(javadocJar)
            artifact(sourcesJar)
        }
    }
    repositories {
        repositories {
            maven("https://dev.gloryx.net/main") {
                credentials(PasswordCredentials::class) {
                    username = System.getenv("GLORYX_USERNAME")
                    password = System.getenv("GLORYX_PASSWORD")
                }
            }
        }
    }
}