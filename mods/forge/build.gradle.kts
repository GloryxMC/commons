plugins {
    kotlin("jvm")
    id("net.minecraftforge.gradle") version "5.1.+"
    //id("com.github.johnrengelman.shadow")
    `maven-publish`
}
repositories {
    maven("https://thedarkcolour.github.io/KotlinForForge/")
}
configurations {
    val shade by creating
}
dependencies {
    fun shade(dep: Any = "") = add("shade", dep)
    minecraft("net.minecraftforge:forge:1.16.5-36.2.34")
    api("thedarkcolour:kotlinforforge:1.16.0")
    implementation(project(":core"))
}

minecraft.apply {
    mappings("snapshot", "20210309-1.16.5")
}

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
            from(components["java"])
            artifactId = "forge-1.16"
            groupId = "${rootProject.group}.minecraft"
            version = "0.1.53-SNAPSHOT"

            fg.component(this)

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

tasks.jar.get().finalizedBy("reobfJar")