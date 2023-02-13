package ru.tinkoff.academy.system;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system")
@RequiredArgsConstructor
public class SystemController {
    @GetMapping("/liveness")
    public HttpStatus liveness() {
        return HttpStatus.OK;
    }

    @GetMapping("/readiness")
    public String readiness() {
        return null;
    }
}
