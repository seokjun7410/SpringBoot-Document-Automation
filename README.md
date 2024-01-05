# SpringBoot-Document-Automation
 This repository contains example projects for building springboot document automation.


# Introduce blog
- https://hoding-cloud.tistory.com/3

# Use dependency
```
    testImplementation 'org.springframework.restdocs:spring-restdocs-mockmvc'
    testImplementation 'com.epages:restdocs-api-spec-mockmvc:0.18.2'
    testImplementation 'com.epages:restdocs-api-spec-restassured:0.18.2'
    testImplementation 'org.springframework.restdocs:spring-restdocs-restassured'
```
- and redoc-cli

# What can you learn
- How to use RestAssured and RestDocs together
- Efficient configuration when using RestAssuerd and RestDocs
- Gradle file separation, task creation, and task chaining
- When you have a customized response body format, you can create a binding class.
- You can run python files through Gradle task.

# Goals of the project
- You can create and update redoc-static.html with just one gradle task execution.
