package frontendservice.service;

import employees.api.EmployeeControllerApi;
import employees.api.RoleControllerApi;
import employees.model.CreateEmployeeRequest;
import employees.model.EmployeeDto;
import employees.model.RoleDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeesService {

    private EmployeeControllerApi employeeControllerApi;

    private RoleControllerApi roleControllerApi;

    public List<EmployeeDto> listEmployees() {
        return employeeControllerApi.employees().getBody();
    }

    public List<RoleDto> listRoles() {
        return roleControllerApi.findAll().getBody();
    }

    public void createEmployee(CreateEmployeeRequest request) {
        employeeControllerApi.createEmployee(request);
    }

}
