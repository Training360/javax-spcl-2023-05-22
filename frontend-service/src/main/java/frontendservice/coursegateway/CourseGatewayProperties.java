package frontendservice.coursegateway;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "frontend-service")
public class CourseGatewayProperties {

    private String courseServiceUrl;
}
