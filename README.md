# JavaTodolistAPI
[![Build Status](https://travis-ci.org/iTonzDev/JavaTodolist.svg?branch=master)](https://travis-ci.org/iTonzDev/JavaTodolist)

### Build & Run
1. ./gradlew clean test
2. ./gradlew bootRun
3. Go to url: localhost:8080

### API DOCS
Get All Task:

              Request → GET
              URL → '/'  or '/tasks'
Get Task by Id:

              Request → GET
              URL → '/tasks/{id}'
Create New Task:

              Request → POST
              URL → '/tasks'
              Header → Content-Type : application/json
              Body → 
              {
                "detail" : "Go to London",
                "pending" : "true"
              }
Update Task:

              Request → PATCH
              URL → '/tasks'
              Header → Content-Type : application/json
              Body → 
              { 
                "id" : 1 , 
                "detail" : "Go to Chiang Mai", 
                "pending" : "true" 
              }
Update Status Task:

              Request → PUT
              URL → '/tasks/{id}'
Delete Task:

              Request → DELETE
              URL → '/tasks/{id}'
