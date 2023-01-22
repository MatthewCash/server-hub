plugins {
    java
}

repositories {
    maven { url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/") }
    maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots") }
    maven { url = uri("https://maven.citizensnpcs.co/repo") }
    maven { url = uri("https://repo.alessiodp.com/releases/") }
    mavenCentral()
}

dependencies {
    implementation("org.spigotmc:spigot-api:1.8.8-R0.1-SNAPSHOT")
    implementation("net.citizensnpcs:citizens-main:2.0.30-SNAPSHOT")
}

group = "com.matthewcash.network"
version = "1.0.0"
description = "Matthew_Cash Server Hub"
java.sourceCompatibility = JavaVersion.VERSION_1_8
