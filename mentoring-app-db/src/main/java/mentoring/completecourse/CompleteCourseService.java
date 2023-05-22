package mentoring.completecourse;

import lombok.AllArgsConstructor;
import mentoring.admitemployee.EmployeeAdmitService;
import mentoring.employeeskills.AcquireSkillsCommand;
import mentoring.employeeskills.EmployeeSkillsService;
import mentoring.enrollment.CompleteCourseCommand;
import mentoring.course.CourseService;
import mentoring.enrollment.EnrollmentService;

@AllArgsConstructor
public class CompleteCourseService {

    private CourseService courseService;

    private EnrollmentService enrollmentService;

    private EmployeeSkillsService employeeSkillsService;

    public void completeCourse(CompleteCourseCommand command) {
        enrollmentService.completeCourse(command);
        var course = courseService.findCourseById(command.getCourseId());
        var acquireSkillsCommand = new AcquireSkillsCommand(command.getEmployeeId(), course.getProvidedSkills());
        employeeSkillsService.acquireSkills(acquireSkillsCommand);
    }
}
