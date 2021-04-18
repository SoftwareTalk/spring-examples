package dev.softwaretalk.example.jafu.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class GreetingDto {

    String greeting;
    String name;
}
