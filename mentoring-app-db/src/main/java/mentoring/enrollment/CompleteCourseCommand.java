package mentoring.enrollment;

import lombok.Value;

@Value
public class CompleteCourseCommand {

    private long employeeId;

    private long courseId;

}
