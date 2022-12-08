plugins {
    kotlin("jvm")
    id("net.minecraftforge.gradle") version "5.1.+"
    id("org.jetbrains.compose") version "+"
    //id("com.github.johnrengelman.shadow")
    //id("org.spongepowered.mixin") version "0.+"
    `maven-publish`
}

repositories {
    google()
    maven("https://maven.google.com/")
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    maven("https://repo.essential.gg/repository/maven-public")
    maven("https://thedarkcolour.github.io/KotlinForForge/")
}
configurations {
    val shade by creating
}
dependencies {
    fun shade(dep: Any = "") = add("shade", dep)
    compileOnly(kotlin("stdlib"))
    minecraft("net.minecraftforge:forge:1.16.5-36.2.34")
    api("thedarkcolour:kotlinforforge:1.16.0")
    //annotationProcessor("org.spongepowered:mixin:0.+:processor")
    api(project(":core"))
    compileOnly("org.jetbrains.kotlinx:kotlinx-cli:0.3.5")
    compileOnly("gg.essential:universalcraft-1.16.2-forge:234+pull-36")

    implementation("net.kyori:adventure-text-serializer-gson:4.12.0")
    /// Jetpack Compose -> Cat UI
    compileOnly(compose.desktop.common)
}

minecraft.apply {
    mappings("snapshot", "20210309-1.16.5")
}
tasks.jar { finalizedBy("reobfJar") }

val sourcesJar by tasks.creating(Jar::class) {
    from(sourceSets["main"].allSource.srcDirs + kotlin.sourceSets["main"].kotlin.srcDirs)
    archiveClassifier.set("sources")
}
publishing {
    publications {
        create("mavenForge", MavenPublication::class) {
            artifactId = "forge-1.16"
            groupId = "${rootProject.group}.minecraft"
            version = "0.1.53-SNAPSHOT"

            artifact(tasks.jar)

            fg.component(this)

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