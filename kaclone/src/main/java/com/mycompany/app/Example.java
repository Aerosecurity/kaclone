package com.mycompany.app;
import org.springframework.web.bind.annotation.*;

@RestController
public class Example {
    
    @GetMapping("/")
    public String home() {
        return "Hello World!";
    }


}