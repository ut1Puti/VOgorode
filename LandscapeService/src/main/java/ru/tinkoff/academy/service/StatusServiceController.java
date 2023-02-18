package ru.tinkoff.academy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/services")
@RequiredArgsConstructor
public class StatusServiceController {
    private final StatusServiceService statusServiceService;

    @GetMapping("")
    public Map<String, ServiceStatus> getServicesStatus() {
        return statusServiceService.getServicesStatuses();
    }
}
