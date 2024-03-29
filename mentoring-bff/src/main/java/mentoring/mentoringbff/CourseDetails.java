package mentoring.mentoringbff;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDetails {

    private Long id;

    private String name;

    private String description;

    private String syllabus;

    private int limit;

    List<Long> enrolledEmployees;

    List<Long> completedEmployees;

}
