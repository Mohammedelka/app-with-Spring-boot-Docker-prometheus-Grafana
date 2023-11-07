package jp.ahaoretama.springbootprometheusgrafanasample.controller;

import io.prometheus.client.Gauge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemoryMetrics {
    private static final Gauge memoryUsage = Gauge.build()
            .name("memory_usage_bytes")
            .help("Current memory usage in bytes.")
            .register();

    @GetMapping("/memory")
    public static void updateMemoryUsage() {
        memoryUsage.set(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
    }
    public String sayHello() {
        return "my memory";
    }
}