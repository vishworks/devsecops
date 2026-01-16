package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class HelloWorldController {
    
    @GetMapping("/")
    public String helloWorld() {
        return "<html><body style='font-family: Arial; text-align: center; padding: 50px;'>" +
               "<h1 style='color: #F36921;'>🎉 Hello Quester! 🌍</h1>" +
               "<p style='font-size: 20px;'>Welcome to the DevSecOps Demo Application</p>" +
               "<p style='color: #666;'>Deployed successfully via CI/CD Pipeline</p>" +
               "<p style='color: #999; font-size: 14px;'>Current time: " + 
               LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) +
               "</p></body></html>";
    }
    
    @GetMapping("/api/hello")
    public HelloResponse helloApi() {
        return new HelloResponse("Hello World", "SUCCESS", LocalDateTime.now().toString());
    }
    
    @GetMapping("/api/version")
    public VersionResponse version() {
        return new VersionResponse("1.0.0", "Hello World App", "production");
    }
}

// Response classes
class HelloResponse {
    private String message;
    private String status;
    private String timestamp;
    
    public HelloResponse(String message, String status, String timestamp) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
    }
    
    // Getters
    public String getMessage() { return message; }
    public String getStatus() { return status; }
    public String getTimestamp() { return timestamp; }
}

class VersionResponse {
    private String version;
    private String name;
    private String environment;
    
    public VersionResponse(String version, String name, String environment) {
        this.version = version;
        this.name = name;
        this.environment = environment;
    }
    
    // Getters
    public String getVersion() { return version; }
    public String getName() { return name; }
    public String getEnvironment() { return environment; }
}
