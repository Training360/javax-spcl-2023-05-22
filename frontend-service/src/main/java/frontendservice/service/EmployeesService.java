package frontendservice.service;

import employees.model.CreateEmployeeRequest;
import employees.model.EmployeeDto;
import employees.model.RoleDto;
import frontendservice.employeegateway.EmployeeClient;
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

    public List<EmployeeDto> listEmployees() {
        return employeeClient.listEmployees();
    }

    public List<RoleDto> listRoles() {
        return employeeClient.listRoles();
    }

    public void createEmployee(CreateEmployeeRequest request) {
        employeeClient.createEmployees(request);
    }

}
