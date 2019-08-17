package no.rubato.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class rubatoController {
    public rubatoController() {
    }

    @RequestMapping(value = "/helloWorld")
    public String hello(){//This is running if i go to localhost:8080/booking
        return "Hello World from Rubato.no";
    }
}
