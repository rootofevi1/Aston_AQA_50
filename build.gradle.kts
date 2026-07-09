import org.gradle.internal.tools.api.impl.JavaApiMemberWriter.adapter

plugins {
    id("java")
    id("io.qameta.allure") version "2.11.2"
}

version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

allure {
    version.set("2.24.0")
    adapter.autoconfigure.set(true)
    adapter.aspectjWeaver.set(true)
}

dependencies {
    implementation("org.seleniumhq.selenium:selenium-java:4.27.0")
    implementation("io.github.bonigarcia:webdrivermanager:5.6.2")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testImplementation("org.slf4j:slf4j-simple:2.0.9")

    testImplementation("io.qameta.allure:allure-junit5:2.24.0")
    testImplementation("io.qameta.allure:allure-attachments:2.24.0")
}

tasks.test {
    useJUnitPlatform()
    systemProperty("webdriver.chrome.silentOutput", "true")
    systemProperty("selenium.silent", "true")
}