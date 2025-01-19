package com.example.demo.service;

import com.example.demo.log.LoggingContext;
import com.example.demo.log.MDCHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;

@Service
public class LogService {

    private static final Logger logger = LoggerFactory.getLogger("APP_LOGGER2");

    public void insertLogToFile() {

        // Create a LoggingContext object and populate it with data
        LoggingContext context = new LoggingContext();
        context.setIntCustomerId("13292");
        context.setStep("login");
        context.setSystemType("web");

        // Populate the MDC with the context
        MDCHelper.populateMDC(context);

        // Debug: Print the MDC contents
        System.out.println("MDC Contents: " + MDC.getCopyOfContextMap());

        // Log a message
        logger.info("User logged in successfully.");

        // Clear the MDC
        MDCHelper.clearMDC();
    }
}
