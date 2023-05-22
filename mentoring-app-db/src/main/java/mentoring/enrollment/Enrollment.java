package mentoring.enrollment;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NamedQuery(name = "findEnrollmentByCourseId", query = "select e from Enrollment e left join fetch e.employees where e.courseId = :courseId")
@Table(name = "enrollments")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long courseId;

    public Enrollment(long courseId) {
        this.courseId = courseId;
    }

    @ElementCollection
    @CollectionTable(name = "enrollment_employees")
    private Set<Long> employees = new HashSet<>();

    public void enroll(long employeeId) {
        employees.add(employeeId);
    }

    public void complete(long employeeId) {
        employees.remove(employeeId);
    }
}
