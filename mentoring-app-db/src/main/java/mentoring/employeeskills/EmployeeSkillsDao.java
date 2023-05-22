package mentoring.employeeskills;

public interface EmployeeSkillsDao {

    void save(EmployeeSkills employeeSkills);

    EmployeeSkills findByEmployeeId(long employeeId);

    void update(EmployeeSkills employeeSkills);
}
