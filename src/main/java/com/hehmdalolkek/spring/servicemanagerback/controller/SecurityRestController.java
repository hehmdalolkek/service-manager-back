package com.hehmdalolkek.spring.servicemanagerback.controller;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api")
public class SecurityRestController {

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username,
            @RequestParam String password) {
        if (username.equals("admin") && password.equals("admin")) {
            return ResponseEntity.ok("Ok");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Ошибка аутентификации");
        }
    }

    @GetMapping("/logout")
    public void logout() {
    }

}
