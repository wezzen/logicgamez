import org.checkerframework.gradle.plugin.CheckerFrameworkExtension

plugins {
	id("org.springframework.boot") version "2.6.2"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("org.checkerframework") version "0.6.7"
	id("com.diffplug.spotless") version "6.2.0"
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
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity5")
	implementation("com.google.guava:guava:31.0.1-jre")

	developmentOnly("org.springframework.boot:spring-boot-devtools")

	runtimeOnly("org.postgresql:postgresql:42.3.1")
	compileOnly("org.webjars:bootstrap:5.1.3")
	compileOnly("org.webjars:jquery:3.6.0")
	implementation("org.webjars:webjars-locator:0.42")

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