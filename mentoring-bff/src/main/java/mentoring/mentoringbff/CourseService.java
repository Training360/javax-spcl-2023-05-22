package mentoring.mentoringbff;

import courses.api.CourseControllerApi;
import employees.api.EmployeeControllerApi;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {

    private CourseControllerApi courseControllerApi;

    private EmployeeControllerApi employeeControllerApi;

    private CourseMapper courseMapper;


    public List<Course> courses() {
        var courses = courseControllerApi.findAllCourses().getBody();
        return courseMapper.toResponse(courses);
    }

    public CourseDetails courseDetails(Long id) {
        var course = courseControllerApi.findCourseById(id).getBody();
        return courseMapper.toCourseDetails(course);
    }
}
