package dev.softwaretalk.example.jafu.controller;

import dev.softwaretalk.example.jafu.dto.GreetingDto;
import dev.softwaretalk.example.jafu.service.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import javax.servlet.ServletException;
import java.io.IOException;

@RequiredArgsConstructor
public class GreetingController {

    private final GreetingService greetingService;

    public ServerResponse sayHi(ServerRequest request) {
        return ServerResponse.ok().body("Hi!");
    }

    public ServerResponse generateGreeting(ServerRequest request) throws ServletException, IOException {
        GreetingDto greeting = request.body(GreetingDto.class);
        return ServerResponse.ok().body(greetingService.generateGreeting(greeting));
    }

}
