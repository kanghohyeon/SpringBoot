package com.sist.jwt_0224.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {

    @GetMapping("/")
    public String first() {
        return "JWT연습";
    }
}
