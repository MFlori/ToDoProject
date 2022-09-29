package todo.todoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import todo.todoproject.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
