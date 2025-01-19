package com.example.demo;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTest {

    @Test
    void contextLoads() {
        // Print Logback's internal status
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(lc);

        // Log a message
        Logger logger = LoggerFactory.getLogger("APP_LOGGER2");
        logger.info("This is a log message from APP_LOGGER2.");
    }
}