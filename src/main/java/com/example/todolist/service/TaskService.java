package com.example.todolist.service;

import com.example.todolist.entity.Task;
import com.example.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    public Task getTaskById(long id) {
        return taskRepository.findOne(id);
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updatePanding(Task task) {
        task.setPending(!task.isPending());
        return taskRepository.save(task);
    }

    public void removeTask(Task task) {
        taskRepository.delete(task);
    }
}
