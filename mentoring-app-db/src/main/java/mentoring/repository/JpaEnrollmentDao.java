package mentoring.repository;

import lombok.AllArgsConstructor;
import mentoring.enrollment.Enrollment;
import mentoring.enrollment.EnrollmentDao;

import javax.persistence.NoResultException;

@AllArgsConstructor
public class JpaEnrollmentDao implements EnrollmentDao {

    private PersistenceContextHandler handler;

    @Override
    public Enrollment findOrCreateByCourseId(long courseId) {
        try {
            return findByCourseId(courseId);
        } catch (NoResultException nre) {
            Enrollment enrollment = new Enrollment(courseId);
            enrollment.enroll(courseId);
            handler.doInTransaction(entityManager -> entityManager.persist(enrollment));
            return enrollment;
        }
    }

    @Override
    public void update(Enrollment enrollment) {
        handler.doInTransaction(entityManager -> entityManager.merge(enrollment));
    }

    @Override
    public Enrollment findByCourseId(long courseId) {
        return handler.query(entityManager -> entityManager.createNamedQuery("findEnrollmentByCourseId", Enrollment.class)
                .setParameter("courseId", courseId).getSingleResult());
    }

    @Override
    public void save(Enrollment enrollment) {
        handler.doInTransaction(entityManager -> entityManager.merge(enrollment));
    }
}
