package mentoring.ratingservice.grpcgateway;


import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.UUID;

@GrpcService
public class RatingServiceGateway extends RatingServiceGrpc.RatingServiceImplBase {

    @Override
    public void createRating(RateRequest request, StreamObserver<RateResponse> responseObserver) {
        var response = RateResponse.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setCourseId(request.getCourseId())
                .setEmployeeId(request.getEmployeeId())
                .setStars(request.getStars()).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
