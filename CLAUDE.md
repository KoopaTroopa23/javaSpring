# javaSpring: learning project context

The owner is learning Java and Spring Boot to start a Java software engineer job. They follow Udemy courses and build the course code in this repo. Help them while they work through the courses.

## Working style
- Keep answers short. No long essays.
- Windows 11 + VS Code. Terminal commands run in PowerShell: `./gradlew build`, `./gradlew test`, `./gradlew bootRun`.
- Course material is often written for Maven. Translate it to this Gradle build (`pom.xml` dependency -> a line in `build.gradle`).
- Add a Mockito/JUnit test for each service or controller they write (see `CalculatorTest`).
- `JAVA_CHEAT_SHEET.txt` is their interview/day-one cheat sheet; point back to it when it fits.

## Setup
- Gradle (Groovy DSL), Java 21 toolchain, Spring Boot 4.1.1, package `com.example.javaspring`.
- Dependencies: Spring Web MVC, Spring Data JPA (Hibernate), Validation, H2 (in-memory) + H2 console, Lombok, DevTools, test starters.
- Port 8080 is often taken on their PC; they may run on `server.port=8081`.

## Courses (take in this order)
1. **in28Minutes: Java Programming for Complete Beginners.** Stop when it reaches the Spring sections. Covers cheat sheet sections 1-5. Put examples in `CheatSheetDemo.java` or new classes here.
2. **Chad Darby: Spring Boot 4, Spring 7 & Hibernate for Beginners.** Main course. Matches this project's Boot 4 setup. Covers cheat sheet section 6 and JPA. Build the course app (a Task API) inside this repo. Check the course curriculum against `build.gradle` and add missing dependencies as they come up (for example a MySQL driver, Thymeleaf, Spring Security).
3. **in28Minutes: Master Microservices with Spring Boot and Spring Cloud.** Last. Needs several separate small services (plus Spring Cloud and usually Docker), so create those as separate projects or modules, not inside this single app. Only start it after course 2, and after checking whether the new team uses microservices.

Docker is a possible follow-up after course 2 (an earlier session worked on Docker for `springboot-gradle-timb`).

## Known setup issues (delete a line once fixed)
- `src/test/java/com/example/javaspring/Task.java` is a JPA entity in the test folder. Entities belong in `src/main/java/...`.
- `settings.gradle` has `rootProject.name = 'javaSpring.api'`; the intended name is `javaSpring` (a dot in a Gradle project name can cause problems).

## Verifying builds in the cloud sandbox
Maven Central can return HTTP 429 there. Resolve dependencies through Google's Maven Central mirror with a throwaway Gradle init script kept outside the repo; do not commit it.
