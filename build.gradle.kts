import org.springframework.boot.gradle.dsl.SpringBootExtension

plugins {
    id("org.gradle.java") apply (true)
    id("org.springframework.boot") version ("2.5.2") apply (true)
    id("io.spring.dependency-management") version ("1.0.11.RELEASE") apply (true)
    id("com.diffplug.spotless") version ("5.14.0") apply (true)
}

group = "demo.hexagonalspring"
version = "0.0.0"
java.sourceCompatibility = JavaVersion.VERSION_11
java.targetCompatibility = JavaVersion.VERSION_11

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}
configurations.all {
    resolutionStrategy.cacheChangingModulesFor(0, "seconds")
}

repositories {
    mavenCentral()
}

dependencies {
    // Application
    annotationProcessor("org.mapstruct:mapstruct-processor:1.4.1.Final")
    annotationProcessor("org.projectlombok:lombok-mapstruct-binding:0.2.0")
    annotationProcessor("org.projectlombok:lombok")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    compileOnly("org.projectlombok:lombok")
    compileOnly("org.projectlombok:lombok-mapstruct-binding:0.2.0")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.mapstruct:mapstruct:1.4.1.Final")
    implementation("com.naharoo.commons:mapstruct-facade-spring-boot-starter:1.4.0")
    runtimeOnly("com.h2database:h2")
    runtimeOnly("org.flywaydb:flyway-core")

    // Testing
    testAnnotationProcessor("org.mapstruct:mapstruct-processor:1.4.1.Final")
    testAnnotationProcessor("org.projectlombok:lombok-mapstruct-binding:0.2.0")
    testAnnotationProcessor("org.projectlombok:lombok")
    testAnnotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    testCompileOnly("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jeasy:easy-random-core:4.2.0")
    testRuntimeOnly("org.flywaydb:flyway-core")
}

tasks.withType<JavaCompile> {
    options.isIncremental = false
    options.compilerArgs = options.compilerArgs + listOf(
            "-Amapstruct.defaultComponentModel=spring",
            "-Amapstruct.unmappedTargetPolicy=ERROR"
    )
}

spotless {
    java {
        googleJavaFormat("1.10.0")
    }
}

tasks.test {
    useJUnitPlatform()
}

configure<SpringBootExtension> {
    buildInfo()
}
