import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    application
    kotlin("jvm") version "2.2.20"
    id("io.github.goooler.shadow") version "8.1.8"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test"))
    implementation("org.apache.commons:commons-rng-simple:1.6")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks {
    withType<ShadowJar> {
        archiveClassifier.set("")
        manifest {
            attributes["Main-Class"] = "com.altiran.coinflip.CoinFlipAppKt"
        }
    }

    named("assemble") {
        dependsOn("shadowJar")
    }
}

application {
    mainClass.set("com.altiran.coinflip.CoinFlipAppKt")
}
