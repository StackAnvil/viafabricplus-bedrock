pluginManagement {
    includeBuild("build-logic")

    repositories {
        gradlePluginPortal()
        maven("https://maven.fabricmc.net/")
    }
}

plugins {
    id("base.settings")
    id("base.fabric_settings")
}

dependencyResolutionManagement {
    repositories {
        maven("https://repo.viaversion.com")
        maven("https://maven.lenni0451.net/everything")
        maven("https://repo.opencollab.dev/maven-snapshots") {
            content {
                includeGroupByRegex("org\\.cloudburstmc\\..+")
                includeGroup("dev.opencollab")
            }
        }
        maven("https://jitpack.io") {
            content {
                includeGroup("com.github.oryxel1")
            }
        }
    }
}

rootProject.name = "viafabricplus-bedrock"
