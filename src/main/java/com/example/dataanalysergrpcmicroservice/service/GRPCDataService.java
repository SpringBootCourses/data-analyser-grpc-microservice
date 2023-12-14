package com.example.dataanalysergrpcmicroservice.service;

import com.example.dataanalysergrpcmicroservice.DataServerGrpc;
import com.example.dataanalysergrpcmicroservice.Empty;
import com.example.dataanalysergrpcmicroservice.GRPCData;
import com.example.dataanalysergrpcmicroservice.model.Data;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
public class GRPCDataService extends DataServerGrpc.DataServerImplBase {

    private final DataService dataService;

    @Override
    public void addData(GRPCData request, StreamObserver<Empty> responseObserver) {
        Data data = new Data(request);
        dataService.handle(data);
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

}
