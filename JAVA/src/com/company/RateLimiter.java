package com.company;
import java.util.HashMap;
import java.util.Objects;

public class RateLimiter {
    private HashMap<Integer, Long> customerTimestamps; // Stores last request timestamps for each customer
    private int requestsAllowed; // Number of requests allowed per time window (Y seconds)
    private long timeWindow; // Time window in milliseconds (Y seconds)

    public RateLimiter(int requestsAllowed, int timeWindowInSeconds) {
        this.customerTimestamps = new HashMap<>();
        this.requestsAllowed = requestsAllowed;
        this.timeWindow = timeWindowInSeconds * 1000; // Convert seconds to milliseconds
    }

    public synchronized boolean rateLimit(int customerId) {
        long currentTime = System.currentTimeMillis();

        // Check if customer exists in the hashmap
        if (customerTimestamps.containsKey(customerId)) {
            long lastRequestTime = customerTimestamps.get(customerId);
            long elapsedTime = currentTime - lastRequestTime;

            // If the elapsed time is less than the time window, check if requests exceeded
            if (elapsedTime < timeWindow) {
                if (countRequests(customerId, currentTime) > requestsAllowed) {
                    return false; // Requests exceeded, deny request
                }
            }
        }

        // Update or add the current request timestamp for the customer
        customerTimestamps.put(customerId, currentTime);
        return true; // Request allowed
    }

    // Counts the number of requests made by the customer within the time window
    private int countRequests(int customerId, long currentTime) {
        int count = 0;
        for (long timestamp : customerTimestamps.values()) {
            if (Objects.equals(customerId, customerTimestamps.get(timestamp))) {
                if (currentTime - timestamp < timeWindow) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter(5, 60); // 5 requests per 60 seconds

        // Simulate requests
        for (int i = 0; i < 100; i++) {
            int customerId = i % 3; // Simulate requests from 3 different customers
            Thread thread = new Thread( () -> {
                boolean isAllowed = rateLimiter.rateLimit(customerId);
                System.out.println("Request from customer " + customerId + " is allowed: " + isAllowed);
            }
        );
            thread.start();
        }
    }
}