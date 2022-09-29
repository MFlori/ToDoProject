package todo.todoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import todo.todoproject.entity.Task;
import todo.todoproject.entity.User;

import java.util.List;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
    List<Task> findTasksByUser(User user);
}
