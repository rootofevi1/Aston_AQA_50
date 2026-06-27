plugins {
    id("java")
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // TestNG
    testImplementation("org.testng:testng:7.10.2")

    // SLF4J для логирования TestNG
    testImplementation("org.slf4j:slf4j-simple:2.0.9")
}

tasks.test {
    useTestNG()
    testLogging {
        events("passed", "skipped", "failed")
        showExceptions = true
        showCauses = true
        showStackTraces = true
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}