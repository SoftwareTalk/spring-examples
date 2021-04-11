package dev.softwaretalk.examples.controller;

import dev.softwaretalk.examples.dto.GreetingDto;
import dev.softwaretalk.examples.service.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
@RequiredArgsConstructor
public class GreetingController {

    private final GreetingService greetingService;

    @GetMapping("/hi")
    public String sayHi() {
        return "Hi!";
    }

    @PostMapping
    public String generateGreeting(@RequestBody GreetingDto greeting) {
        return greetingService.generateGreeting(greeting);
    }

}
