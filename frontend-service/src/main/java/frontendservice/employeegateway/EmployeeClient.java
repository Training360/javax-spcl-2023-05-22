package frontendservice.employeegateway;

import employees.model.CreateEmployeeRequest;
import employees.model.EmployeeDto;
import employees.model.RoleDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

public interface EmployeeClient {

    @GetExchange("/api/employees")
    List<EmployeeDto> listEmployees();

    @GetExchange("/api/roles")
    List<RoleDto> listRoles();

    @PostExchange("/api/employees")
    EmployeeDto createEmployees(@RequestBody CreateEmployeeRequest request);
}
