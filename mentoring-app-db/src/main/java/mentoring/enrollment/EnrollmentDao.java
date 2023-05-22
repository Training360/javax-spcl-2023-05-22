package mentoring.enrollment;

public interface EnrollmentDao {
    Enrollment findOrCreateByCourseId(long employeeId);

    Enrollment findByCourseId(long courseId);

    void update(Enrollment enrollment);

    void save(Enrollment enrollment);
}
