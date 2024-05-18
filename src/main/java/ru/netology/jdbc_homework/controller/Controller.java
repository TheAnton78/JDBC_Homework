package ru.netology.jdbc_homework.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.jdbc_homework.repository.Repository;

import java.util.List;

@RestController
public class Controller {
    private final Repository repository;

    public Controller(Repository repository) {
        this.repository = repository;
    }

    @GetMapping("/products/fetch-product")
    public List<String> getProductName(@RequestParam("name") String name){
        return repository.getProductName(name);
    }

    @GetMapping("/test")
    public String test(@RequestParam("name") String name){
        return name;
    }
}
