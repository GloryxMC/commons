import org.jetbrains.kotlin.utils.addToStdlib.cast

plugins {
    id("java")
    kotlin("jvm")
    `maven-publish`
}

group = "net.gloryx"
version = rootProject.version

java.toolchain.languageVersion.set(JavaLanguageVersion.of(8))

dependencies {
    compileOnly(kotlin("stdlib"))
    api("net.kyori:adventure-api:4.11.0")
    api("net.kyori:adventure-extra-kotlin:4.11.0")
    api("de.themoep:minedown-adventure:1.7.1-SNAPSHOT")
    implementation("net.kyori:adventure-text-serializer-gson:4.11.0")
    api("net.gloryx:oknamer:0.1.01")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("com.mojang:brigadier:1.0.17")
}
val javadoc: Javadoc by tasks

val javadocJar by tasks.creating(Jar::class) {
    from(javadoc)
    archiveClassifier.set("javadoc")
}

val sourcesJar by tasks.creating(Jar::class) {
    from(sourceSets["main"].allSource.include("**/*.kt"))
    archiveClassifier.set("sources")
}

publishing {
    repositories {
        maven("https://dev.gloryx.net/main") {
            credentials(PasswordCredentials::class) {
                username = System.getenv("GLORYX_USERNAME")
                password = System.getenv("GLORYX_PASSWORD")
            }
        }
    }
    publications {
        create("maven", MavenPublication::class) {
            artifactId = "cat"
            from(components["java"])
            artifact(javadocJar)
            artifact(sourcesJar)
        }
    }
}
