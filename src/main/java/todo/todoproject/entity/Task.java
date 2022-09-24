package todo.todoproject.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name="tasks")
public class Task implements Serializable {
    @Id
    @GeneratedValue(generator = "u")
    @GenericGenerator(name = "u", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="idtasks", columnDefinition = "BINARY(16)") private UUID id;
    @Column(name="task") private String task;
    @Column(name="notes") private String notes;
    @Column(name="status") private boolean status;



}
