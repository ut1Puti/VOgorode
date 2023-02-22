package ru.tinkoff.academy.service.status;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/services/status")
@RequiredArgsConstructor
public class ServiceStatusController {
    private final ServiceStatusService serviceStatusService;

    @GetMapping("")
    public Map<String, List<ServiceStatus>> getServicesStatus() {
        return serviceStatusService.getServicesStatuses();
    }
}
