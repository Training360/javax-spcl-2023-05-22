package mentoring.employee;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EmployeeService {

    private EmployeeDao employeeDao;

    public Employee admitEmployee(Employee employee) {
        employeeDao.save(employee);
        return employee;
    }

    public Employee findEmployeeById(long id) {
        return employeeDao.findById(id);
    }
}
