package mentoring.mentoringbff.coursegateway;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "bff-service")
public class CourseGatewayProperties {

    private String courseServiceUrl;
}
