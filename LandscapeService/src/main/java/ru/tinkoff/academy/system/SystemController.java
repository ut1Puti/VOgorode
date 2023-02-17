package ru.tinkoff.academy.system;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.info.BuildProperties;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system")
@RequiredArgsConstructor
public class SystemController {
    private final BuildProperties buildProperties;

    /**
     * Check service liveness
     */
    @GetMapping("/liveness")
    public void liveness() {

    }

    /**
     * Check service readiness
     *
     * @return String with service name and readiness status
     */
    @GetMapping("/readiness")
    public String readiness() {
        return "\"" + buildProperties.getName() + "\": \"OK\"";
    }
}
