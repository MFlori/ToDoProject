package todo.todoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import todo.todoproject.entity.Task;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
