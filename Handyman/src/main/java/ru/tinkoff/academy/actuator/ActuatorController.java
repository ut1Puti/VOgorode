package ru.tinkoff.academy.actuator;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actuator")
@RequiredArgsConstructor
public class ActuatorController {
    @GetMapping("/info")
    public String info() {
        return null;
    }
}
