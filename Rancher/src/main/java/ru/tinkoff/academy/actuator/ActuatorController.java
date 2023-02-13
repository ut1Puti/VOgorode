package ru.tinkoff.academy.actuator;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actuator")
@RequiredArgsConstructor
public class ActuatorController {
    private final BuildProperties buildProperties;

    @GetMapping("/info")
    public BuildProperties info() {
        return buildProperties;
    }
}
