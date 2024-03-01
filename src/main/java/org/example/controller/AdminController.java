package org.example.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

    @GetMapping("/")
    public String helloAdmineController(){
        return "Admin level access";
    }


}
