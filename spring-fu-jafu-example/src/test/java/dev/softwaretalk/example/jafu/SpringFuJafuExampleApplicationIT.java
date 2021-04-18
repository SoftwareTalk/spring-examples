package dev.softwaretalk.example.jafu;

import dev.softwaretalk.example.jafu.dto.GreetingDto;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

class SpringFuJafuExampleApplicationIT {

    private final RestTemplate restTemplate = new RestTemplate();
    private static ConfigurableApplicationContext context;

    @BeforeAll
    public static void beforeAll() {
        context = SpringFuJafuExampleApplication.app.run("test");
    }

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

    @AfterAll
    static void afterAll() {
        context.close();
    }

    private String getUrl() {
        return "http://localhost:8181/greeting";
    }
}
