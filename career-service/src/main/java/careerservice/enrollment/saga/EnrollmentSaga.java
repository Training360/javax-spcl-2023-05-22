package careerservice.enrollment.saga;

import careerservice.enrollment.gateway.EnrollCourseReply;
import careerservice.enrollment.model.EnrollCommand;
import careerservice.enrollment.service.EnrollmentService;
import careerservice.enrollment.view.EnrollmentView;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Saga
@AllArgsConstructor
public class EnrollmentSaga {

    private EnrollmentService enrollmentService;

    private ApplicationEventPublisher applicationEventPublisher;
    public EnrollmentView enroll(EnrollCommand command) {
        var view = enrollmentService.enroll(command);
        applicationEventPublisher.publishEvent(command);
        return view;
    }

    public void registered(EnrollCourseReply reply) {
        if (reply.getSuccess() == EnrollCourseReply.Success.SUCCESSFULL) {
            enrollmentService.complete(reply.getCourseId(), reply.getEmployeeId());
        }
        else {
            enrollmentService.cancel(reply.getCourseId(), reply.getEmployeeId());
        }
    }
}
