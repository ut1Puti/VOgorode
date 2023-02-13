package ru.tinkoff.academy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.metrics.export.prometheus.EnablePrometheusMetrics;

@SpringBootApplication
@EnablePrometheusMetrics
public class HandymanSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(HandymanSpringApplication.class, args);
    }
}
