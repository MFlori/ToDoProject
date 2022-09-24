package todo.todoproject.entity;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id") private long id;
    @Column(name="firstName") private String firstName;
    @Column(name="lastName") private String lastName;
    @Column(name="email") private String email;
    @Column(name="password")private String password;
}
