package todo.todoproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import todo.todoproject.entity.Task;
import todo.todoproject.repository.TaskRepository;
import todo.todoproject.secureInput.SecureInput;

import java.util.List;
import java.util.UUID;

@RestController
public class TaskController {


    @Autowired
    private TaskRepository taskRepository;

    @CrossOrigin
    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        for(Task task : taskRepository.findAll()){
            System.out.println(task);
        }

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
    public void deleteTask (@PathVariable(name="id") UUID id){
        taskRepository.deleteById(id);
    }
}
