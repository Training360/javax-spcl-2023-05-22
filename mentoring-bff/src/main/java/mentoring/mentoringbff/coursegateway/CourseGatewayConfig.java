package mentoring.mentoringbff.coursegateway;

import courses.api.CourseControllerApi;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
@EnableConfigurationProperties(CourseGatewayProperties.class)
public class CourseGatewayConfig {

    @Bean
    public CourseControllerApi courseClient(WebClient.Builder builder, CourseGatewayProperties properties) {
        var client = builder.baseUrl(properties.getCourseServiceUrl()).build();
        var factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
        return factory.createClient(CourseControllerApi.class);
    }

}
