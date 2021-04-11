package dev.softwaretalk.examples.integration;

import dev.softwaretalk.examples.dto.GreetingDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingControllerIT {

    @LocalServerPort
    private int port;

    @Autowired
    protected TestRestTemplate restTemplate;

    @Test
    public void returnsHiForSimpleGet() {
        ResponseEntity<String> response = restTemplate.getForEntity(getUrl() + "/hi", String.class);
        assertThat(response.getStatusCode())
                .isEqualTo(HttpStatus.OK);

        assertThat(response.getBody())
                .isEqualTo("Hi!");
    }

    @Test
    public void greetingWillBeGeneratedFromBackend() {
        ResponseEntity<String> response = restTemplate.postForEntity(
                getUrl(),
                GreetingDto.builder()
                        .greeting("What's up")
                        .name("SoftwareTalk")
                        .build(),
                String.class);

        assertThat(response.getStatusCode())
                .isEqualTo(HttpStatus.OK);

        assertThat(response.getBody())
                .isEqualTo("What's up, SoftwareTalk!");
    }

    private String getUrl() {
        return "http://localhost:" + port + "/greeting";
    }

}
