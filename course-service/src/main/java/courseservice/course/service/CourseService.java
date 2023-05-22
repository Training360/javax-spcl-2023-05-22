package courseservice.course.service;

import courseservice.course.dto.CourseDetailsView;
import courseservice.course.dto.CourseView;
import courseservice.course.dto.CreateCourseCommand;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CourseService {

    private CourseRepository courseRepository;

    private CourseMapper courseMapper;

    public CourseView createCourse(CreateCourseCommand command) {
        return null;
    }

    public CourseDetailsView findCourseById(long id) {
        return null;
    }

    public List<CourseView> findAllCourses() {
        return null;
    }

}
