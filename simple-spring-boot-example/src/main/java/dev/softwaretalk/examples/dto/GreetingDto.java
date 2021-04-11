package dev.softwaretalk.examples.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class GreetingDto {

    String greeting;
    String name;
}
