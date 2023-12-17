package com.kia.springmonitoring.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {

    private Counter hit;

    public TestController(MeterRegistry m) {
        this.hit = Counter.builder("hitTestCount")
                .description("kiaTestHitEndpoint")
                .tag("kia" , "add hit")
                .register(m);
    }

    @GetMapping("testA")
    public String testA (){
        hit.increment();
        return "test A";
    }

}
