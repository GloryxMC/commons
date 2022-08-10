import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.plugin.KotlinTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("java")
    kotlin("multiplatform")
    `maven-publish`
}

group = "net.gloryx.commons.minecraft"
version = rootProject.version

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(project(":core"))
}
val adv: KotlinSourceSet.() -> Unit = {
    dependencies {
        implementation(project(":core"))
    }
}
val rep: RepositoryHandler.() -> Unit = { maven("https://repo.papermc.io/repository/maven-public/") }
java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))
val minecraftVersionAttribute = Attribute.of("minecraftVersion", String::class.java)
kotlin {
    jvm("paper19") {
        attributes.attribute(minecraftVersionAttribute, "1.19.1")
    }
    jvm("paper16") {
        attributes.attribute(minecraftVersionAttribute, "1.16.5")
    }

    val list = listOf(
        jvm("paper19"),
        jvm("paper16")
    ).map(KotlinTarget::getName).map { "${it}kotlinMultiplatform" }
    sourceSets {
        val commonMain by getting(adv)
        val paper19Main by getting {
            repositories(rep)
            dependencies {
                implementation(project(":core"))
                implementation("io.papermc.paper:paper-api:1.19.1-R0.1-SNAPSHOT")
            }
        }
        val paper16Main by getting {
            repositories(rep)
            dependencies {
                implementation(project(":core"))
                compileOnly("com.destroystokyo.paper:paper-api:1.16.5-R0.1-20211218.082619-371")
            }
        }
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
            all {
                if (this !is MavenPublication) return@all
                artifactId = if (artifactId == "minecraft")
                    "common"
                else
                    artifactId.removePrefix("minecraft-").replace("16", "-1.16").replace("19", "-1.19")
            }
        }
    }
}

repositories {
    mavenCentral()
}