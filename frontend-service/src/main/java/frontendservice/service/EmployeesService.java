package frontendservice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeesService {

    private EmployeeClient employeeClient;

    public List<Employee> listEmployees() {
    }

    public List<Role> listRoles() {
    }

    public void createEmployee(CreateEmployeeCommand command) {
    }

}
