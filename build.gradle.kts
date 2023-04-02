plugins {
	java
	id("org.springframework.boot") version "3.0.4"
	id("io.spring.dependency-management") version "1.1.0"
}

group = "com.Prestamos"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-validation")

	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("org.postgresql:postgresql")

	implementation("me.paulschwarz:spring-dotenv:2.3.0")

//Lombok
	compileOnly ("org.projectlombok:lombok:1.18.26")
	annotationProcessor ("org.projectlombok:lombok:1.18.26")

	testCompileOnly ("org.projectlombok:lombok:1.18.26")
	testAnnotationProcessor ("org.projectlombok:lombok:1.18.26")






//	JWT
	implementation("io.jsonwebtoken:jjwt-api:0.11.5")
	implementation("io.jsonwebtoken:jjwt-impl:0.11.5")
	implementation("io.jsonwebtoken:jjwt-jackson:0.11.5")


//	Test
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
}



tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.jar {enabled = false}