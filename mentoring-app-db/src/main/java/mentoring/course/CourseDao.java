package mentoring.course;

import mentoring.skilllevel.SkillLevel;

import java.util.List;

public interface CourseDao {
    void save(Course course);

    List<Course> findProvidesAny(List<SkillLevel> skillLevels);

    Course findById(long courseId);
}
