package todo.todoproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import todo.todoproject.entity.Task;
import todo.todoproject.repository.TaskRepository;
import todo.todoproject.secureInput.SecureInput;

import java.util.*;

@RestController
public class TaskController {


    @Autowired
    private TaskRepository taskRepository;

    @CrossOrigin
    @GetMapping("/tasks")
    public List<Task> getAllTasks() {

        List<Task> allTasks = taskRepository.findAll();
        Collections.sort(allTasks);

        return allTasks;
    }

    @CrossOrigin
    @PostMapping("/tasks")
    Task newTask(@RequestBody Task newTask) {
        SecureInput.checkInput(newTask); //checking for html input and removing char '<'
        newTask.setDateCreated(new Date());
        return taskRepository.save(newTask);
    }

    @CrossOrigin
    @DeleteMapping("tasks/delete/{id}")
    public void deleteTask (@PathVariable(name="id") UUID id){
        taskRepository.deleteById(id);
    }


    @CrossOrigin
    @PutMapping("tasks/update/{id}")
    public Task updateTask (@PathVariable(name="id") UUID id, @RequestBody Task newTask){
        Task updatedTask = taskRepository.findById(id).get();
        updatedTask.setTask(newTask.getTask());
        updatedTask.setNotes(newTask.getNotes());
        updatedTask.setStatus(newTask.isStatus());

        return taskRepository.save(updatedTask);
        }

}
