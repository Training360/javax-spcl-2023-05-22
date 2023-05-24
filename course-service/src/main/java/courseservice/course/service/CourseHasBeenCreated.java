package courseservice.course.service;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseHasBeenCreated {

    private Long id;

    private String name;

    @Lob
    private String description;

    @Lob
    private String syllabus;
}
