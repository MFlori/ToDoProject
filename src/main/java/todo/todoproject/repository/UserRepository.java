package todo.todoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import todo.todoproject.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
