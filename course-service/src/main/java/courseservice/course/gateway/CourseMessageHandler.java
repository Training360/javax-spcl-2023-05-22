package courseservice.course.gateway;

import courseservice.course.dto.EnrollCommand;
import courseservice.course.service.CourseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@AllArgsConstructor
@Configuration
@Slf4j
public class CourseMessageHandler {

    private CourseService courseService;

    @Bean
    public Function<EnrollCourseRequest, EnrollCourseReply> handleEnrollCourseRequest() {
        return request -> {
            log.info("Message has come: {}", request);
            var command = new EnrollCommand(request.getCourseId(), request.getEmployeeId());
            var result = courseService.enroll(command);
            var reply = new EnrollCourseReply(command.getCourseId(), command.getEmployeeId(), EnrollCourseReply.Success.valueOf(result.getSuccess().name()));
            return reply;
        };
    }
}
