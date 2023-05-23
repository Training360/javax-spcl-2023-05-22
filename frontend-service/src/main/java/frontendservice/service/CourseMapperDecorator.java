package frontendservice.service;

import courses.model.CourseDetailsView;
import employees.model.EmployeeDto;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public class CourseMapperDecorator implements CourseMapper {

    @Autowired
    @Qualifier("delegate")
    private CourseMapper deleagate;

    @Override
    public CourseDetailsResponse toResponse(CourseDetailsView course, List<EmployeeDto> employees) {
        var response = deleagate.toResponse(course, employees);

        var map = employees.stream().collect(Collectors.toMap(EmployeeDto::getId, Function.identity()));
        response.setEnrolledEmployees(course.getEnrolledEmployees().stream().map(map::get).toList());
        response.setCompletedEmployees(course.getCompletedEmployees().stream().map(map::get).toList());
        return  response;
    }
}
