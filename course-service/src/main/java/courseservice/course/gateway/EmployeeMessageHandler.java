package courseservice.course.gateway;

import courseservice.course.messages.EmployeeHasBeenDeleted;
import courseservice.course.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@Slf4j
public class EmployeeMessageHandler {

    @Bean
    public Consumer<EmployeeHasBeenDeleted> employeeEventHandler(CourseService courseService) {
        return event -> {
            log.info("Message has come: {}", event);
            courseService.removeEmployee(event.getEmployeeId());
        };
    }
}
