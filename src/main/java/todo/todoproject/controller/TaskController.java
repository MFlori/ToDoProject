package todo.todoproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import todo.todoproject.entity.Task;
import todo.todoproject.repository.TaskRepository;
import todo.todoproject.secureInput.SecureInput;

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
        SecureInput.checkInput(newTask); //checking for html input and removing char '<'
        return taskRepository.save(newTask);
    }

    @CrossOrigin
    @DeleteMapping("/tasks/{id}")
    public void deleteTask (@PathVariable(name="id") Long id){
        taskRepository.deleteById(id);
    }
}
