package careerservice.enrollment.gateway;

import careerservice.enrollment.model.EnrollCommand;
import careerservice.enrollment.saga.EnrollmentSaga;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
@AllArgsConstructor
@Configuration
@Slf4j
public class CourseGateway {

    private StreamBridge streamBridge;

    private EnrollmentSaga enrollmentSaga;

    @EventListener
    public void enrollToCourse(EnrollCommand command) {
        var request = new EnrollCourseRequest(command.getCourseId(), command.getEmployeeId());
        log.info("Send message: {}", request);
        streamBridge.send("course-request-topic", request);
    }

    @Bean
    public Consumer<EnrollCourseReply> handleEnrollCourseReply() {
        return reply -> {
            log.info("Message has come: {}", reply);
            enrollmentSaga.registered(reply);
        };
    }
}
