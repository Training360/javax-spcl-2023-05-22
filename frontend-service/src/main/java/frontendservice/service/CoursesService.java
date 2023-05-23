package frontendservice.service;

import courses.api.CourseControllerApi;
import courses.model.CourseDetailsView;
import courses.model.CourseView;
import employees.api.EmployeeControllerApi;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CoursesService {

    private CourseControllerApi courseClient;

    private EmployeeControllerApi employeeControllerApi;

    private CourseMapper courseMapper;

    public List<CourseView> findAllCourses() {
        return courseClient.findAllCourses().getBody();
    }

    public CourseDetailsResponse findCourseById(long id) {

        var courses =  courseClient.findCourseById(id).getBody();
        var employees = employeeControllerApi.employees().getBody();

        return courseMapper.toResponse(courses, employees);
    }
}
