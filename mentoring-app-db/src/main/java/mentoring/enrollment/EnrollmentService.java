package mentoring.enrollment;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EnrollmentService {

    private EnrollmentDao enrollmentDao;

    public Enrollment enroll(EnrollCommand enrollCommand) {
        var enrollment = enrollmentDao.findOrCreateByCourseId(enrollCommand.getCourseId());
        enrollment.enroll(enrollCommand.getEmployeeId());
        enrollmentDao.update(enrollment);
        return enrollment;
    }

    public void completeCourse(CompleteCourseCommand command) {
        var enrollment = enrollmentDao.findByCourseId(command.getCourseId());
        enrollment.complete(command.getEmployeeId());
        enrollmentDao.save(enrollment);
    }
}
