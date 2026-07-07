plugins {
    id("java")
}

version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.seleniumhq.selenium:selenium-java:4.27.0")
    implementation("io.github.bonigarcia:webdrivermanager:5.6.2")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testImplementation("org.slf4j:slf4j-simple:2.0.9")
}

tasks.test {
    useJUnitPlatform()
    systemProperty("webdriver.chrome.silentOutput", "true")
    systemProperty("selenium.silent", "true")
}