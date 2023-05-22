package mentoring.admitemployee;

import lombok.AllArgsConstructor;
import mentoring.employee.Employee;
import mentoring.employee.EmployeeService;
import mentoring.employeeskills.EmployeeSkills;
import mentoring.employeeskills.EmployeeSkillsService;

@AllArgsConstructor
public class EmployeeAdmitService {

    private EmployeeService employeeService;

    private EmployeeSkillsService employeeSkillsService;

    public Employee admitEmployee(AdmitEmployeeCommand command) {
        Employee employee = new Employee(command.getName(), command.getRoles());
        employeeService.admitEmployee(employee);

        EmployeeSkills employeeSkills = new EmployeeSkills(employee.getId(), command.getSkillLevels());
        employeeSkillsService.save(employeeSkills);
        return employee;
    }
}
