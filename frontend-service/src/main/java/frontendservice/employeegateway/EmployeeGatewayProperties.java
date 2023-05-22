package frontendservice.employeegateway;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "frontend-service")
public class EmployeeGatewayProperties {

    private String employeeServiceUrl;
}
