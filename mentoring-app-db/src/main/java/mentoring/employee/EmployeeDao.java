package mentoring.employee;

import java.util.List;

public interface EmployeeDao {
    void save(Employee employee);

    Employee findById(long id);
}