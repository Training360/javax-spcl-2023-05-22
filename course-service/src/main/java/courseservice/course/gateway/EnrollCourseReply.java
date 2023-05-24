package courseservice.course.gateway;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollCourseReply {

    long courseId;

    long employeeId;


    public enum Success {SUCCESSFULL, UNSUCCESSFULL}

    private Success success;
}
