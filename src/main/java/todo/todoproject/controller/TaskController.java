package todo.todoproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import todo.todoproject.entity.Task;
import todo.todoproject.repository.TaskRepository;

import java.util.List;

@RestController
public class TaskController {


    @Autowired
    private TaskRepository taskRepository;

    @CrossOrigin
    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @CrossOrigin
    @PostMapping("/tasks")
    Task newTask(@RequestBody Task newTask) {
        System.out.println("new task saved");
        return taskRepository.save(newTask);
    }
}
