plugins {
    kotlin("jvm")
    id("com.google.devtools.ksp") version "1.9.21-1.0.16"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":automator:core"))
    ksp(project(":automator:processor"))
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}