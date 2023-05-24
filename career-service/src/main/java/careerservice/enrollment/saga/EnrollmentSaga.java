package careerservice.enrollment.saga;

import careerservice.enrollment.model.EnrollCommand;
import careerservice.enrollment.service.EnrollmentService;
import careerservice.enrollment.view.EnrollmentView;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Saga
@AllArgsConstructor
public class EnrollmentSaga {

    private EnrollmentService enrollmentService;
    public EnrollmentView enroll(EnrollCommand command) {
        var view = enrollmentService.enroll(command);
        return view;
    }
}
