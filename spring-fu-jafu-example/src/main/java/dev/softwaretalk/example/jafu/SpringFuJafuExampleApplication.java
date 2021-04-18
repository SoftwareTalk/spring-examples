package dev.softwaretalk.example.jafu;

import dev.softwaretalk.example.jafu.controller.GreetingController;
import dev.softwaretalk.example.jafu.service.GreetingService;
import org.springframework.fu.jafu.JafuApplication;

import static org.springframework.fu.jafu.Jafu.webApplication;
import static org.springframework.fu.jafu.webmvc.WebMvcServerDsl.webMvc;

public class SpringFuJafuExampleApplication {

    public static JafuApplication app = webApplication(a -> a.beans(b -> b
            .bean(GreetingController.class)
            .bean(GreetingService.class))
            .enable(webMvc(s -> s
                    .port(s.profiles().contains("test") ? 8181 : 8081)
                    .router(router -> {
                        GreetingController controller = s.ref(GreetingController.class);
                        router
                                .GET("/greeting/hi", controller::sayHi)
                                .POST("/greeting", controller::generateGreeting);
                    }).converters(c -> c
                            .string()
                            .jackson()))));

    public static void main(String[] args) {
        app.run(args);
    }

}
