package courseservice.course.service;

import courseservice.course.dto.CourseDetailsView;
import courseservice.course.dto.CourseView;
import courseservice.course.dto.CreateCourseCommand;
import courseservice.course.dto.EnrollCommand;
import courseservice.course.model.Course;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CourseService {

    private CourseRepository courseRepository;

    private CourseMapper courseMapper;

    public CourseView createCourse(CreateCourseCommand command) {
        var course =  Course.announceCourse(command);
        courseRepository.save(course);
        return courseMapper.toView(course);
    }

    public CourseDetailsView findCourseById(long id) {
        var course = courseRepository.findById(id).orElseThrow();
        return courseMapper.toDetailsView(course);
    }

    public List<CourseView> findAllCourses() {
        return courseRepository.findAllView();
    }

    @Transactional
    public boolean enroll(EnrollCommand command) {
        var course = courseRepository.findById(command.getCourseId()).orElseThrow();
        return course.enroll(command);
    }

}
