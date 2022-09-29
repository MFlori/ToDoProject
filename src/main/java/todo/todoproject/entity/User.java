package todo.todoproject.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(generator = "u")
    @GenericGenerator(name = "u", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="id", columnDefinition = "BINARY(16)") private UUID id;
    @Column(name="firstName") private String firstName;
    @Column(name="lastName") private String lastName;
    @Column(name="email") private String email;
    @Column(name="password")private String password;

    @OneToMany(mappedBy="user", cascade = CascadeType.PERSIST)
    private List<Task> todos = new ArrayList<>();

}
