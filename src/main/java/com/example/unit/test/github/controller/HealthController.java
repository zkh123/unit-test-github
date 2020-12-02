package com.example.unit.test.github.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HealthController {

    @GetMapping(value = "hs")
    public Object healthCheck(){
        log.info("healthCheck is ok");
        return "ok";
    }

}
