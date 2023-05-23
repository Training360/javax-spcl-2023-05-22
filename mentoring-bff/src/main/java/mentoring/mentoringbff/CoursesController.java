package mentoring.mentoringbff;

import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class CoursesController {

    private CourseService courseService;

    @QueryMapping
    public List<Course> courses() {
        return courseService.courses();
    }

    @SchemaMapping
    public CourseDetails courseDetails(Course course) {
        return courseService.courseDetails(course.getId());
    }
}
