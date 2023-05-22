package courseservice.course.model;

import courseservice.course.dto.CreateCourseCommand;
import courseservice.course.dto.EnrollCommand;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Lob
    private String description;

    @Lob
    private String syllabus;

    @Column(name = "attendee_limit")
    private int limit;

    @ElementCollection
    List<Long> enrolledEmployees;

    @ElementCollection
    List<Long> completedEmployees;

    public static Course announceCourse(CreateCourseCommand command) {
        var course = new Course();
        course.setName(command.getName());
        course.setDescription(command.getDescription());
        course.setSyllabus(course.getSyllabus());
        course.setLimit(course.getLimit());
        return course;
    }

    public boolean enroll(EnrollCommand command) {
        if (alreadyEnrolled(command)) {
            return true;
        }
        if (isFull()) {
            return false;
        }
        else {
            enrolledEmployees.add(command.getEmployeeId());
            return true;
        }
    }

    private boolean alreadyEnrolled(EnrollCommand command) {
        return enrolledEmployees.contains(command.getEmployeeId());
    }

    private boolean isFull() {
        return enrolledEmployees.size() >= limit;
    }
}
