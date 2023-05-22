package mentoring.findcourse;

import mentoring.completecourse.CompleteCourseService;
import mentoring.course.Course;
import mentoring.course.CourseService;
import mentoring.employee.Employee;
import mentoring.employee.EmployeeService;
import mentoring.admitemployee.AdmitEmployeeCommand;
import mentoring.admitemployee.EmployeeAdmitService;
import mentoring.employeeskills.EmployeeSkillsService;
import mentoring.enrollment.CompleteCourseCommand;
import mentoring.enrollment.EnrollCommand;
import mentoring.enrollment.EnrollmentService;
import mentoring.repository.*;
import mentoring.role.Role;
import mentoring.role.RoleService;
import mentoring.skill.Skill;
import mentoring.skill.SkillService;
import mentoring.skilllevel.SkillLevel;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.Persistence;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class FindCourseServiceTest {

    RoleService roleService;

    SkillService skillService;

    CourseService courseService;

    EmployeeAdmitService employeeAdmitService;

    FindCourseService findCourseService;

    EnrollmentService enrollmentService;

    CompleteCourseService completeCourseService;

    Course course;
    Employee employee;

    @BeforeEach
    void init() {
        // Creating beans
        var factory = Persistence.createEntityManagerFactory("pu");
        var handler = new PersistenceContextHandler(factory);

        var roleDao = new JpaRoleDao(handler);
        roleService = new RoleService(roleDao);

        var skillDao = new JpaSkillDao(handler);
        skillService = new SkillService(skillDao);

        var courseDao = new JpaCourseDao(handler);
        courseService = new CourseService(courseDao);

        var employeeDao = new JpaEmployeeDao(handler);
        var employeeService = new EmployeeService(employeeDao);
        var employeeSkillsDao = new JpaEmployeeSkillsDao(handler);
        var employeeSkillsService = new EmployeeSkillsService(employeeSkillsDao);
        employeeAdmitService = new EmployeeAdmitService(employeeService, employeeSkillsService);

        findCourseService = new FindCourseService(employeeService, roleService, employeeSkillsService, courseService);

        var enrollmentDao = new JpaEnrollmentDao(handler);
        enrollmentService = new EnrollmentService(enrollmentDao);

        completeCourseService = new CompleteCourseService(courseService, enrollmentService, employeeSkillsService);

        var skill = new Skill("Java");
        skillService.createSkill(skill);
        var skillId = skill.getId();

        var role = new Role("Java developer", List.of(new SkillLevel(skillId, 4)));
        roleService.createRole(role);
        var roleId = role.getId();

        course = new Course("Advanced Java", List.of(new SkillLevel(skillId, 4)));
        courseService.announceCourse(course);

        var announceEmployeeCommand = new AdmitEmployeeCommand("John Doe", Set.of(roleId), List.of(new SkillLevel(skillId, 3)));
        employee = employeeAdmitService.admitEmployee(announceEmployeeCommand);
    }

    @Test
    void findCourses() {
        var courses = findCourseService.findCourses(employee.getId());
        assertThat(courses).extracting(Course::getName).containsExactly("Advanced Java");
    }

    @Test
    void enroll() {
        enrollmentService.enroll(new EnrollCommand(course.getId(), employee.getId()));
    }

    @Test
    void completeCourse() {
        enrollmentService.enroll(new EnrollCommand(course.getId(), employee.getId()));
        completeCourseService.completeCourse(new CompleteCourseCommand(course.getId(), employee.getId()));
    }
}