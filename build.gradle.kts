plugins {
    java
}

repositories {
    maven(url = "https://hub.spigotmc.org/nexus/content/repositories/snapshots/") {
        name = "spigot-repo"
    }
    maven(url = "https://oss.sonatype.org/content/repositories/snapshots") {
        name = "sonatype"
    }
    maven(url = "https://repo.citizensnpcs.co/") {
        name = "everything"
    }
    mavenCentral()
}

dependencies {
    implementation("org.spigotmc:spigot-api:1.8.8-R0.1-SNAPSHOT")
    implementation("net.citizensnpcs:citizens:2.0.30-SNAPSHOT")
}

group = "com.matthewcash.network"
version = "1.0.0"
description = "Matthew_Cash Server Hub"
java.sourceCompatibility = JavaVersion.VERSION_1_8
