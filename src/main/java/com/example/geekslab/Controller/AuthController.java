package com.example.geekslab.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
   @GetMapping("/home")
    public String Home () {
        return "this is home page " ;
    }

    @GetMapping("/admin")
    public String Admin () {
        return "this is Admin page " ;
    }

}
