import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.5"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.9.23"
	kotlin("plugin.spring") version "1.9.23"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	// lombok анотации
	compileOnly("org.projectlombok:lombok:1.18.32")
	annotationProcessor ("org.projectlombok:lombok:1.18.32")
	// https://mvnrepository.com/artifact/javax.validation/validation-api
	implementation("javax.validation:validation-api:2.0.1.Final")

//	Поделючение к БД
	implementation("org.postgresql:postgresql:42.7.3")
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.2.5")
	testImplementation("com.h2database:h2:2.2.224")
//  Работа со Spring
	implementation("org.springframework.boot:spring-boot-starter-web:3.2.5")
//  Работа с аутентификацией
	implementation("org.springframework.boot:spring-boot-starter-security:3.2.5")
	implementation("org.springframework.boot:spring-boot-starter-oauth2-authorization-server")
	implementation("jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api:3.0.0")
	implementation("org.springframework.security:spring-security-taglibs:6.2.4")

	implementation("org.springframework.boot:spring-boot-devtools:3.2.5")
	implementation("org.apache.tomcat.embed:tomcat-embed-jasper:11.0.0-M19")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
