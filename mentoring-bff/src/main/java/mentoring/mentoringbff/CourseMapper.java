package mentoring.mentoringbff;

import courses.model.CourseDetailsView;
import courses.model.CourseView;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    List<Course> toResponse(List<CourseView> courses);

    CourseDetails toCourseDetails(CourseDetailsView course);
}
