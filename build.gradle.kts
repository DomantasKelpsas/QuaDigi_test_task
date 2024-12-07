plugins {
    kotlin("jvm") version "1.8.0" // Update this to the latest compatible version
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.junit.jupiter:junit-jupiter:5.9.0") // Adjust version as necessary
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17)) // Or a compatible Java version like 11
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17" // Change this to a supported version like 1.8 or 11
    }
}

application {
    mainClass.set("MainKt") // Main class for execution
}

tasks.test {
    useJUnitPlatform()
}