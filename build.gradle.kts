import org.checkerframework.gradle.plugin.CheckerFrameworkExtension

plugins {
	id("org.springframework.boot") version "2.7.0-SNAPSHOT"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("org.checkerframework") version "0.6.5"
	id("com.diffplug.spotless") version "6.1.0"
	java
}

group = "com.github.wezzen"
version = "0.0.1-SNAPSHOT"


java {
	sourceCompatibility = JavaVersion.VERSION_17
	targetCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
	maven("https://repo.spring.io/milestone")
	maven("https://repo.spring.io/snapshot")
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.test {
	useJUnitPlatform()
}

configure<CheckerFrameworkExtension> {
	checkers = listOf(
		"org.checkerframework.checker.nullness.NullnessChecker",
	)
}

spotless {
	java {
		googleJavaFormat()
	}
}