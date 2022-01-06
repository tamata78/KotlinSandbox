import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.5.10"
}

group = "me.jpd20537"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {
	testImplementation(kotlin("test"))
	testImplementation(kotlin("org.slf4j"))
}

tasks.test {
	useJUnit()
}

tasks.withType<KotlinCompile>() {
	kotlinOptions.jvmTarget = "1.8"
}