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
        api("net.kyori:adventure-api:4.11.0")
        api("net.kyori:adventure-extra-kotlin:4.11.0")
        api("de.themoep:minedown-adventure:1.7.1-SNAPSHOT")
        implementation("net.kyori:adventure-text-serializer-gson:4.11.0")
    }
}
val rep: RepositoryHandler.() -> Unit = { maven("https://repo.papermc.io/repository/maven-public/") }
java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))
val minecraftVersionAttribute = Attribute.of("minecraftVersion", String::class.java)
val loaderAttribute = Attribute.of("minecraftLoader", String::class.java)
kotlin {
    jvm("paper19") {
        attributes.attribute(minecraftVersionAttribute, "1.19.1")
        attributes.attribute(loaderAttribute, "paper")
    }
    jvm("paper16") {
        attributes.attribute(minecraftVersionAttribute, "1.16.5")
        attributes.attribute(loaderAttribute, "paper")
    }

    jvm("sponge8") {
        attributes.attribute(minecraftVersionAttribute, "1.16.5")
        attributes.attribute(loaderAttribute, "sponge")
    }

    val list = listOf(
        jvm("paper19"),
        jvm("paper16"),
        jvm("sponge8")
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
        val sponge8Main by getting {
            repositories {
                maven("https://repo.spongepowered.org/repository/maven-public/")
            }
            dependencies {
                implementation(project(":core"))
                api("net.kyori:adventure-api:4.11.0")
                api("net.kyori:adventure-extra-kotlin:4.11.0")
                api("de.themoep:minedown-adventure:1.7.1-SNAPSHOT")
                implementation("net.kyori:adventure-text-serializer-gson:4.11.0")
                implementation("org.spongepowered:spongeapi:8.0.0")
                //api("com.github.shynixn.mccoroutine:mccoroutine-sponge-api:2.4.0") broken for api8
                //api("com.github.shynixn.mccoroutine:mccoroutine-sponge-core:2.4.0")
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
                    artifactId.removePrefix("minecraft-").replace(
                        "16" to "1.16",
                        "19" to "1.19"
                    ) // net.gloryx.commons.minecraft:common -> commonMain; sponge8 -> sponge-8
            }
        }
    }
}

repositories {
    mavenCentral()
}

fun String.replace(vararg map: Pair<String, String>) = map.fold(this) { acc, (a, b) -> acc.replace(a, b) }