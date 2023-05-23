package frontendservice.service;

import employees.model.EmployeeDto;
import lombok.Data;

import java.util.List;

@Data
public class CourseDetailsResponse {

    private Long id;

    private String name;

    private String description;

    private String syllabus;

    private int limit;

    private List<EmployeeDto> enrolledEmployees;

    private List<EmployeeDto> completedEmployees;
}
