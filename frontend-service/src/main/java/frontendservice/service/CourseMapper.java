package frontendservice.service;

import courses.model.CourseDetailsView;
import employees.model.EmployeeDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
@DecoratedWith(CourseMapperDecorator.class)
public interface CourseMapper {

    @Mapping(target = "enrolledEmployees", ignore = true)
    @Mapping(target = "completedEmployees", ignore = true)
    CourseDetailsResponse toResponse(CourseDetailsView course, List<EmployeeDto> employees);
}
