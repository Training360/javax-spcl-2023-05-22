package employeegateway;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "bff-service")
public class EmployeeGatewayProperties {

    private String employeeServiceUrl;
}
