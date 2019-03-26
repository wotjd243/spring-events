package io.github.wotjd243.springevents;

import io.github.wotjd243.springevents.user.application.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringEventsApplication {
    private final static Logger logger = LoggerFactory.getLogger(SpringEventsApplication.class);

    public static void main(String[] args) {
        final ApplicationContext context = SpringApplication.run(SpringEventsApplication.class, args);
        final UserService userService = context.getBean(UserService.class);
        userService.join(1L, "Jason");
        logger.info("User list: {}", userService.lookup());
    }
}
