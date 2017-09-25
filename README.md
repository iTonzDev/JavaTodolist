# JavaTodolist
[![Build Status](https://travis-ci.org/iTonzDev/JavaTodolist.svg?branch=master)](https://travis-ci.org/iTonzDev/JavaTodolist)

### Setup Project
1. ./gradlew clean
2. ./gradlew test
3. ./gradlew bootRun
4. Go to url: localhost:8080

### API DOCS
Get all Task List:

              Request → GET
              URL → '/'  or '/tasks'
Get one by Id:

              Request → GET
              URL → '/tasks/{id}'
Create new Task:

              Request → POST
              URL → '/tasks'
              Header → Content-Type : application/json
              Body → {"detail" : "task test", "pending" : "false" }
Update Task:

              Request → PATCH
              URL → '/tasks/'
              Header → Content-Type : application/json
              Body → { id : 1 , "detail" : "update task test", "pending" : "false" }
Update Status Pending:

              Request → PUT
              URL → '/tasks/{id}'
Delete Task:

              Request → DELETE
              URL → '/tasks/{id}'
