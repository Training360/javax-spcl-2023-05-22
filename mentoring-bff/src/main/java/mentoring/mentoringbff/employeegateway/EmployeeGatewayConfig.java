package mentoring.mentoringbff.employeegateway;

import employees.api.EmployeeControllerApi;
import employees.api.RoleControllerApi;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
@EnableConfigurationProperties(EmployeeGatewayProperties.class)
public class EmployeeGatewayConfig {

    @Bean
    public EmployeeControllerApi employeeClient(WebClient.Builder builder, EmployeeGatewayProperties properties) {
        var client = builder.baseUrl(properties.getEmployeeServiceUrl()).build();
        var factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
        return factory.createClient(EmployeeControllerApi.class);
    }

    @Bean
    public RoleControllerApi roleClient(WebClient.Builder builder, EmployeeGatewayProperties properties) {
        var client = builder.baseUrl(properties.getEmployeeServiceUrl()).build();
        var factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
        return factory.createClient(RoleControllerApi.class);
    }
}
