package todo.todoproject.secureInput;

import todo.todoproject.entity.Task;

import java.util.List;

public class SecureInput {

    public static Task checkInput(Task newTask){
        newTask.setTask(newTask.getTask().replace("<","(").replace(">",")"));
        newTask.setNotes(newTask.getNotes().replace("<","(").replace(">",")"));
        return newTask;
    }
}
