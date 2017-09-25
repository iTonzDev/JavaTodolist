package com.example.todolist.controller;

import com.example.todolist.entity.Response;
import com.example.todolist.entity.Task;
import com.example.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping({"/tasks","/"})
    public ResponseEntity<List<Task>> getAllTask(){
        return new ResponseEntity<List<Task>>(taskService.getAllTask(), HttpStatus.OK);
    }

    @GetMapping(value = "/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") long id) throws Exception {
        Task task = taskService.getTaskById(id);
        if (task == null){
            throw new Exception("Task not found");
        }
        return new ResponseEntity<Task>(task, HttpStatus.OK);
    }

    @PostMapping(value = "/tasks")
    public ResponseEntity<Task> saveTask(@RequestBody Task task) throws Exception {
        return new ResponseEntity<Task>(taskService.saveTask(task), HttpStatus.OK);
    }

    @PatchMapping(value = "/tasks")
    public ResponseEntity<Task>  updateTask(@RequestBody Task task) throws Exception {
        Task taskId = taskService.getTaskById(task.getId());
        if (taskId == null){
            throw new Exception("Task not found");
        }
        return new ResponseEntity<Task>(taskService.saveTask(task), HttpStatus.OK);
    }

    @PutMapping(value = "/tasks/{id}")
    public ResponseEntity<Task>  updateTaskPending(@PathVariable("id") long id) throws Exception {
        Task task = taskService.getTaskById(id);
        if (task == null){
            throw new Exception("Task not found");
        }
        return new ResponseEntity<Task>(taskService.updatePanding(task), HttpStatus.OK);
    }

    @DeleteMapping(value = "/tasks/{id}")
    public ResponseEntity<Response> removeTaskById(@PathVariable("id") long id) throws Exception {
        Task task = taskService.getTaskById(id);
        if (task == null){
            throw new Exception("Task not found");
        }
        taskService.removeTask(task);
        return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "Task has been deleted"), HttpStatus.OK);
    }

}
