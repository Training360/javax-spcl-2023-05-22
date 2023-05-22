package mentoring.course;

import lombok.AllArgsConstructor;
import mentoring.enrollment.CompleteCourseCommand;
import mentoring.skilllevel.SkillLevel;

import java.util.List;

@AllArgsConstructor
public class CourseService {

    private CourseDao courseDao;

    public void announceCourse(Course course) {
        courseDao.save(course);
    }

    public List<Course> findCourseProvidesAny(List<SkillLevel> skillLevels) {
        return courseDao.findProvidesAny(skillLevels);
    }

    public Course findCourseById(long courseId) {
        return courseDao.findById(courseId);
    }

}
