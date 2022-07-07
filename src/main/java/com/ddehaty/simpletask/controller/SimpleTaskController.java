package com.ddehaty.simpletask.controller;

import com.ddehaty.simpletask.util.ImportJson;
import com.ddehaty.simpletask.util.MetricsResponse;
import com.ddehaty.simpletask.service.SimpleTaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SimpleTaskController {

    private final SimpleTaskService simpleTaskService;

    public SimpleTaskController(SimpleTaskService simpleTaskService) {
        this.simpleTaskService = simpleTaskService;
    }

    @PostMapping("/messages")
    public ResponseEntity<?> loadMessages(@RequestBody List<ImportJson> importJsons) {
        simpleTaskService.loadMessages(importJsons);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/metrics")
    public MetricsResponse getMetrics() {
        return simpleTaskService.getMetrics();
    }
}
