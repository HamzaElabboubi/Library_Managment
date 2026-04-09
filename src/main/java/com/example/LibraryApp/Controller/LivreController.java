package com.example.LibraryApp.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivreController {

    @GetMapping("livre/{id}")
    public String getlivre(@PathVariable)
}
