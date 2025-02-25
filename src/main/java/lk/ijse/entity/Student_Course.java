package lk.ijse.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
@Entity
public class Student_Course {
    @Id
    private String student_course_id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private Date registration_date;

    @OneToMany(mappedBy = "student_course",cascade = CascadeType.ALL)
    private List<Payment> payments;
}
