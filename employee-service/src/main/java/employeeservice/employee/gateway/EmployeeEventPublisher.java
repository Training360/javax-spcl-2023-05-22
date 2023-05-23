package employeeservice.employee.gateway;

import employeeservice.employee.messages.EmployeeHasBeenDeleted;
import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeEventPublisher {

    private StreamBridge streamBridge;

    @EventListener
    public void employeeHasBeenDeleted(EmployeeHasBeenDeleted employeeHasBeenDeleted) {
        streamBridge.send("employee-events-topic", employeeHasBeenDeleted);
    }
}
