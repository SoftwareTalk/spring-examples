package dev.softwaretalk.examples.service;

import dev.softwaretalk.examples.dto.GreetingDto;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String generateGreeting(GreetingDto greeting) {
        return greeting.getGreeting() + ", " + greeting.getName() + "!";
    }
}
