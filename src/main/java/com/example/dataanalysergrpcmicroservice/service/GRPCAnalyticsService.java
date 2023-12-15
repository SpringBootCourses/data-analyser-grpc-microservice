package com.example.dataanalysergrpcmicroservice.service;

import com.example.dataanalysergrpcmicroservice.model.Data;
import com.example.grpccommon.AnalyticsServerGrpc;
import com.example.grpccommon.GRPCAnalyticsRequest;
import com.example.grpccommon.GRPCData;
import com.example.grpccommon.MeasurementType;
import com.google.protobuf.Timestamp;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

import java.time.ZoneOffset;
import java.util.List;

@GrpcService
@RequiredArgsConstructor
public class GRPCAnalyticsService extends AnalyticsServerGrpc.AnalyticsServerImplBase {

    private final DataService dataService;

    @Override
    public void askForData(GRPCAnalyticsRequest request, StreamObserver<GRPCData> responseObserver) {
        List<Data> data = dataService.getWithBatch(request.getBatchSize());
        for (Data d : data) {
            GRPCData dataRequest = GRPCData.newBuilder()
                    .setSensorId(d.getSensorId())
                    .setTimestamp(
                            Timestamp.newBuilder()
                                    .setSeconds(
                                            d.getTimestamp()
                                                    .toEpochSecond(ZoneOffset.UTC)
                                    )
                                    .build())
                    .setMeasurementType(
                            MeasurementType.valueOf(d.getMeasurementType().name())
                    )
                    .setMeasurement(d.getMeasurement())
                    .build();
            responseObserver.onNext(dataRequest);
        }
        System.out.println("Batch was sent.");
        responseObserver.onCompleted();
    }

}
