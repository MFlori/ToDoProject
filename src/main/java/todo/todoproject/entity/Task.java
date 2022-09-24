package todo.todoproject.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name="tasks")
public class Task {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name="idtasks") private long id;
    @Column(name="task") private String task;
    @Column(name="notes") private String notes;
    @Column(name="status") private boolean status;



}