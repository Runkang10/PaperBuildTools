plugins {
    `kotlin-dsl`
    kotlin("plugin.serialization") version "2.0.21"
}

group = "io.github.runkang10"
version = "0.1.0"

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation("com.charleskorn.kaml:kaml:latest.integration")
}

kotlin {
    jvmToolchain(21)
}

gradlePlugin {
    plugins {
        website.set("https://github.com/Runkang10/PaperBuildTools")
        vcsUrl.set("https://github.com/Runkang10/PaperBuildTools")

        create("paperbuildtools") {
            id = "io.github.runkang10.paperbuildtools"
            implementationClass = "PaperBuildTools"
            displayName = rootProject.name
            description = "A Gradle plugin for Minecraft Plugin (Paper) Development."
            tags.set(listOf("paper-development", "paper"))
        }
    }
}
