package frontendservice.service;

import courses.api.CourseControllerApi;
import courses.model.CourseDetailsView;
import courses.model.CourseView;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CoursesService {

    private CourseControllerApi courseClient;

    public List<CourseView> findAllCourses() {
        return courseClient.findAllCourses().getBody();
    }

    public CourseDetailsView findCourseById(long id) {
        return  courseClient.findCourseById(id).getBody();
    }
}
