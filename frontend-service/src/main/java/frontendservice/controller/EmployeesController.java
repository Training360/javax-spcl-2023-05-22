package frontendservice.controller;

import employees.model.CreateEmployeeRequest;
import frontendservice.service.EmployeesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
@Slf4j
public class EmployeesController {

    private EmployeesService employeesService;

    @GetMapping("/employees")
    public ModelAndView listEmployees() {
        Map<String, Object> model = new HashMap<>();
        model.put("employees", employeesService.listEmployees());
        return new ModelAndView("employees", model);
    }

    @GetMapping("/create-employee")
    public ModelAndView createEmployee(Principal principal) {
//        log.info("Logged in user: {}", principal.getName());
        var model = Map.of(
                "command", new CreateEmployeeRequest(),
                "roles", employeesService.listRoles()
        );
        return new ModelAndView("create-employee", model);
    }

    @PostMapping("/create-employee")
    public ModelAndView createEmployeePost(@ModelAttribute CreateEmployeeRequest request) {
        employeesService.createEmployee(request);
        return new ModelAndView("redirect:/employees");
    }

}