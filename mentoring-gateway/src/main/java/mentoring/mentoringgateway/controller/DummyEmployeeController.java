package mentoring.mentoringgateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class DummyEmployeeController {

    @GetMapping("/dummy/api/employees")
    public Flux<Employee> employees() {
        return Flux.just(new Employee(1, "Dummy Employee 1"));
    }
}
