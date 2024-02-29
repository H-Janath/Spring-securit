package org.example.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

    @PostMapping("/")
    public String helloAdmineController(){
        return "Admin level access";
    }


}
