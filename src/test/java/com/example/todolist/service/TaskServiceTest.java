package com.example.todolist.service;

import com.example.todolist.entity.Task;
import com.example.todolist.repository.TaskRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class TaskServiceTest {
    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllTask(){
        List<Task> taskList = new ArrayList<Task>();
        taskList.add(new Task(1,"Learn Scala",true));
        taskList.add(new Task(2,"Learn GO",true));
        when(taskRepository.findAll()).thenReturn(taskList);

        List<Task> result = taskService.getAllTask();
        assertEquals(2, result.size());
    }

    @Test
    public void getTaskById(){
        Task task = new Task(1,"Learn Scala",true);
        when(taskRepository.findOne(1L)).thenReturn(task);
        Task result = taskService.getTaskById(1);
        assertEquals(1, result.getId());
        assertEquals("Learn Scala", result.getDetail());
        assertEquals(true, result.isPending());
    }

    @Test
    public void saveTask(){
        Task task = new Task(3,"Learn Redis",true);
        when(taskRepository.save(task)).thenReturn(task);
        Task result = taskService.saveTask(task);
        assertEquals(3, result.getId());
        assertEquals("Learn Redis", result.getDetail());
        assertEquals(true, result.isPending());
    }

    @Test
    public void updatePending(){
        Task task = new Task(3,"Learn Redis",true);
        when(taskRepository.save(task)).thenReturn(task);
        Task result = taskService.updatePanding(task);
        assertEquals(3, result.getId());
        assertEquals("Learn Redis", result.getDetail());
        assertEquals(false, result.isPending());
    }

    @Test
    public void removeTask(){
        Task task = new Task(3,"Learning Redis",true);
        taskService.removeTask(task);
        verify(taskRepository, times(1)).delete(task);
    }


}
