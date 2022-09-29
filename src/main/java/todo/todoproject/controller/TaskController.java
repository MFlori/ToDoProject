package todo.todoproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import todo.todoproject.entity.Task;
import todo.todoproject.entity.User;
import todo.todoproject.repository.TaskRepository;
import todo.todoproject.repository.UserRepository;
import todo.todoproject.secureInput.SecureInput;

import java.util.*;

@RestController
public class TaskController {


    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepo;

    @CrossOrigin
    @GetMapping("/tasks/{userID}")
    public List<Task> getAllTasks(@PathVariable(name="userID") UUID userID) {


        User user = userRepo.findById(userID).orElse(new User());
        List<Task> allTasks = taskRepository.findTasksByUser(user);
        Collections.sort(allTasks);

        return allTasks;
    }

    @CrossOrigin
    @PostMapping("/tasks/{userID}")
    Task newTask(@RequestBody Task newTask,@PathVariable(name="userID") UUID userID) {

        User x = userRepo.findById(userID).orElse(new User());

        SecureInput.checkInput(newTask); //checking for html input and removing char '<'

        newTask.setDateCreated(new Date());
        newTask.setUser(x);
        return taskRepository.save(newTask);
    }

    @CrossOrigin(origins = "http://localhost:5500")
    @DeleteMapping("tasks/delete/{id}")
    public void deleteTask (@PathVariable(name="id") UUID id){
        taskRepository.deleteById(id);
    }



    @CrossOrigin
    @PutMapping("tasks/update/{id}")
    public Task updateTask (@PathVariable(name="id") UUID id, @RequestBody Task newTask){

        if(taskRepository.findById(id).isPresent()){
            Task updatedTask = taskRepository.findById(id).get();
            updatedTask.setTask(newTask.getTask());
            updatedTask.setNotes(newTask.getNotes());
            updatedTask.setStatus(newTask.isStatus());
            return taskRepository.save(updatedTask);
        }
        return null;
        }

}
