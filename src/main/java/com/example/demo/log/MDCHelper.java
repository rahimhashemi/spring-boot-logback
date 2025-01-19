package com.example.demo.log;

import org.slf4j.MDC;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MDCHelper {

    /**
     * Populates the MDC with fields from the given object using reflection.
     *
     * @param obj The object containing the fields to log.
     */
    public static void populateMDC(Object obj) {
        if (obj == null) {
            return; // Skip if the object is null
        }

        // Get all public methods of the object
        Method[] methods = obj.getClass().getMethods();

        for (Method method : methods) {
            // Check if the method is a getter (starts with "get" and has no parameters)
            if (method.getName().startsWith("get") && method.getParameterCount() == 0) {
                try {
                    // Extract the field name from the getter method name
                    String fieldName = method.getName().substring(3).toLowerCase();

                    // Invoke the getter method to get the field value
                    Object value = method.invoke(obj);

                    // Add the field name and value to the MDC (if the value is not null)
                    if (value != null) {
                        MDC.put(fieldName, value.toString());
                    }
                } catch (Exception e) {
                    // Handle exceptions (e.g., IllegalAccessException, InvocationTargetException)
                    System.err.println("Error accessing field: " + method.getName());
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Clears all fields from the MDC.
     */
    public static void clearMDC() {
        MDC.clear();
    }
}