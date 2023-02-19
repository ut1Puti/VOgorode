package ru.tinkoff.academy.service;

import com.google.protobuf.Empty;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import ru.tinkoff.academy.proto.ReadinessResponse;
import ru.tinkoff.academy.proto.StatusServiceGrpc;
import ru.tinkoff.academy.proto.VersionResponse;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class StatusServiceService {
    @GrpcClient("HandymanService")
    private StatusServiceGrpc.StatusServiceBlockingStub handymanStatusServiceBlockingStub;

    @GrpcClient("RancherService")
    private StatusServiceGrpc.StatusServiceBlockingStub rancherStatusServiceBlockingStub;

    public Map<String, StatusService> getServicesStatuses() {
        return Map.of("HandymanService", getServiceStatus(handymanStatusServiceBlockingStub),
                "RancherService", getServiceStatus(rancherStatusServiceBlockingStub));
    }

    public StatusService getServiceStatus(StatusServiceGrpc.StatusServiceBlockingStub statusServiceBlockingStub) {
        ReadinessResponse readinessResponse = statusServiceBlockingStub.getReadiness(Empty.newBuilder().build());
        VersionResponse versionResponse = statusServiceBlockingStub.getVersion(Empty.newBuilder().build());
        return StatusService.builder()
                .status(readinessResponse.getStatus())
                .artifact(versionResponse.getArtifact())
                .name(versionResponse.getName())
                .group(versionResponse.getGroup())
                .version(versionResponse.getVersion())
                .build();
    }
}
