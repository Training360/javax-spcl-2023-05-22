package mentoring.employeeskills;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EmployeeSkillsService {

    private EmployeeSkillsDao employeeSkillsDao;

    public void save(EmployeeSkills employeeSkills) {
        employeeSkillsDao.save(employeeSkills);
    }

    public EmployeeSkills findByEmployeeId(long employeeId) {
        return employeeSkillsDao.findByEmployeeId(employeeId);
    }

    public void acquireSkills(AcquireSkillsCommand acquireSkillsCommand) {
        var employeeSkills = employeeSkillsDao.findByEmployeeId(acquireSkillsCommand.getEmployeeId());
        employeeSkills.acquireSkills(acquireSkillsCommand.getSkillLevels());
        employeeSkillsDao.update(employeeSkills);
    }
}
