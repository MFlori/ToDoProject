package todo.todoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import todo.todoproject.entity.Task;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
}
