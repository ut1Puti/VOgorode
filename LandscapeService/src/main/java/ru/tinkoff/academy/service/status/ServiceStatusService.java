package ru.tinkoff.academy.service.status;

import com.google.protobuf.Empty;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import ru.tinkoff.academy.proto.ReadinessResponse;
import ru.tinkoff.academy.proto.ServiceStatusGrpc;
import ru.tinkoff.academy.proto.VersionResponse;

import java.util.List;
import java.util.Map;

@Service
public class ServiceStatusService {
    @GrpcClient("HandymanService")
    private ServiceStatusGrpc.ServiceStatusBlockingStub handymanStatusServiceBlockingStub;

    @GrpcClient("RancherService")
    private ServiceStatusGrpc.ServiceStatusBlockingStub rancherStatusServiceBlockingStub;

    public Map<String, List<ServiceStatus>> getServicesStatuses() {
        return Map.of("HandymanService", List.of(getServiceStatus(handymanStatusServiceBlockingStub)),
                "RancherService", List.of(getServiceStatus(rancherStatusServiceBlockingStub)));
    }

    private ServiceStatus getServiceStatus(ServiceStatusGrpc.ServiceStatusBlockingStub statusServiceBlockingStub) {
        ReadinessResponse readinessResponse = statusServiceBlockingStub.getReadiness(Empty.newBuilder().build());
        VersionResponse versionResponse = statusServiceBlockingStub.getVersion(Empty.newBuilder().build());
        return ServiceStatus.builder()
                .host(statusServiceBlockingStub.getChannel().authority())
                .status(readinessResponse.getStatus())
                .artifact(versionResponse.getArtifact())
                .name(versionResponse.getName())
                .group(versionResponse.getGroup())
                .version(versionResponse.getVersion())
                .build();
    }
}
