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
    @GrpcClient("StatusService")
    private final StatusServiceGrpc.StatusServiceBlockingStub statusServiceStub;

    public Map<String, ServiceStatus> getServicesStatuses() {
        return Map.of("hello", getServiceStatus());
    }

    public ServiceStatus getServiceStatus() {
        ReadinessResponse readinessResponse = statusServiceStub.getReadiness(Empty.newBuilder().build());
        VersionResponse versionResponse = statusServiceStub.getVersion(Empty.newBuilder().build());
        return ServiceStatus.builder()
                .status(readinessResponse.getStatus())
                .artifact(versionResponse.getArtifact())
                .name(versionResponse.getName())
                .group(versionResponse.getGroup())
                .version(versionResponse.getVersion())
                .build();
    }
}
