package mentoring.findcourse;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mentoring.course.Course;
import mentoring.course.CourseService;
import mentoring.employee.EmployeeService;
import mentoring.employeeskills.EmployeeSkillsService;
import mentoring.role.Role;
import mentoring.role.RoleService;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class FindCourseService {

    private EmployeeService employeeService;

    private RoleService roleService;

    private EmployeeSkillsService employeeSkillsService;

    private CourseService courseService;

    // Workflow:
    // Milyen szerepkörei vannak?
    // Szerepköreihez milyen képzettségek szükségesek?
    // Milyen képzettségei vannak?
    // Milyen képzettségek hiányoznak?
    // Milyen kurzus van, mely ad ilyen képzettséget?

    public List<Course> findCourses(long employeeId) {
        Set<Long> rolesIds = employeeService.findEmployeeById(employeeId).getRoles();
        List<Role> roles = roleService.findRolesById(rolesIds);
        SkillLevels requiredSkillLevels = SkillLevels.ofRoles(roles);

        var employeeSkills = employeeSkillsService.findByEmployeeId(employeeId);
        SkillLevels acquiredSkillLevels = SkillLevels.ofEmployeeSkills(employeeSkills);

        SkillLevels missingSkillLevels = acquiredSkillLevels.notPresent(requiredSkillLevels);

        return courseService.findCourseProvidesAny(missingSkillLevels.toList());
    }

}
