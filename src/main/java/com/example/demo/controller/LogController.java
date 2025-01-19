package com.example.demo.controller;

import com.example.demo.service.LogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class LogController {

    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/check")
    public ResponseEntity<Object> check() {
        return ResponseEntity.ok("its up");
    }

    @PostMapping("/log")
    public ResponseEntity<Object> log() {
		logService.insertLogToFile();
        return ResponseEntity.ok("inserted log");
    }

}