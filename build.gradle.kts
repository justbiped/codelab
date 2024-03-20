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
    testImplementation(project(":automator:core"))
    kspTest(project(":automator:processor"))

    implementation("junit:junit:4.4")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}