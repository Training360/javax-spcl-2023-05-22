package mentoring.repository;

import lombok.AllArgsConstructor;
import mentoring.course.Course;
import mentoring.course.CourseDao;
import mentoring.repository.PersistenceContextHandler;
import mentoring.skilllevel.SkillLevel;

import java.util.List;

@AllArgsConstructor
public class JpaCourseDao implements CourseDao {

    private PersistenceContextHandler handler;

    @Override
    public void save(Course course) {
        handler.doInTransaction(entityManager -> entityManager.persist(course));
    }

    @Override
    public List<Course> findProvidesAny(List<SkillLevel> skillLevels) {
        // TODO: Ezeket nem éri meg kiszervezni, mert lekérdezéssel kéne megoldani
        var courses = handler.query(entityManager -> entityManager.createNamedQuery("findAll", Course.class).getResultList());
        return courses.stream().filter(course -> containsAny(course, skillLevels)).toList();
    }

    private boolean containsAny(Course course, List<SkillLevel> skillLevels) {
        return course.getProvidedSkills().stream().anyMatch(skillLevel -> equalOrGreater(skillLevel, skillLevels));
    }

    private boolean equalOrGreater(SkillLevel skillLevel, List<SkillLevel> skillLevels) {
        return skillLevels.stream().anyMatch(toCheck -> toCheck.getSkillId() == skillLevel.getSkillId() && toCheck.getLevel() <= skillLevel.getLevel());
    }

    @Override
    public Course findById(long courseId) {
        return handler.query(entityManager -> entityManager.createNamedQuery("findCourseById", Course.class).setParameter("courseId", courseId).getSingleResult());
    }
}
