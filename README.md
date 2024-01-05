# SpringBoot-Document-Automation
 This repository contains example projects for building springboot document automation.


# Introduce blog
- https://hoding-cloud.tistory.com/3

# Used dependency
- https://docs.spring.io/spring-restdocs/docs/current/reference/htmlsingle/#getting-started
- https://github.com/ePages-de/restdocs-api-spec﻿
```
    id 'com.epages.restdocs-api-spec' version '0.18.2'

    testImplementation 'org.springframework.restdocs:spring-restdocs-mockmvc'
    testImplementation 'com.epages:restdocs-api-spec-mockmvc:0.18.2'
    testImplementation 'com.epages:restdocs-api-spec-restassured:0.18.2'
    testImplementation 'org.springframework.restdocs:spring-restdocs-restassured'
```
- and redoc-cli

# What I learned
- How to use RestAssured and RestDocs together
- Efficient configuration when using RestAssuerd and RestDocs
- Gradle file separation, task creation, and task chaining
- When you have a customized response body format, you can create a binding class.
- You can run python files through Gradle task.

# Goals of the project
- You can create and update redoc-static.html with just one gradle task execution.

# problem solved
- https://github.com/ePages-de/restdocs-api-spec/issues/109#issuecomment-736012775
- The python code presented as a solution to the issue was merged into a gradle task.
