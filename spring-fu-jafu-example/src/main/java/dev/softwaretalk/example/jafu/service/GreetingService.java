package dev.softwaretalk.example.jafu.service;

import dev.softwaretalk.example.jafu.dto.GreetingDto;

public class GreetingService {

    public String generateGreeting(GreetingDto greeting) {
        return greeting.getGreeting() + ", " + greeting.getName() + "!";
    }
}
