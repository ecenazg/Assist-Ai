package com.assistai.backend;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SendBussNumberWithoutImage {

    @RequestMapping(path = "/sendBussNumber", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> sendBussNumber() throws IOException {
        Logger logger = LoggerFactory.getLogger(SendBussNumberWithoutImage.class);
        String image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTw8lmldap-c8JkSt7d4r0Y6V8oJY7sb0cEfg&usqp=CAU";

        String response = SimpleHttpRequest.sendPostRequest(image);

        // Use Jackson ObjectMapper to map JSON to Java objects
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> jsonResponseFromRequest = objectMapper.readValue(response, Map.class);

        // Extract information from the parsed response
        double time = (double) jsonResponseFromRequest.get("time");
        Map<String, Object> imageInfo = (Map<String, Object>) jsonResponseFromRequest.get("image");
        Iterable<Map<String, Object>> predictions = (Iterable<Map<String, Object>>) jsonResponseFromRequest.get("predictions");

        // Create an organized response map
        Map<String, Object> organizedResponse = new HashMap<>();
        organizedResponse.put("time", time);
        organizedResponse.put("image", imageInfo);
        organizedResponse.put("predictions", predictions);

        // Log information
        logger.info("Sending request with image: {}", image);
        logger.info("Received response: {}", response);

        return organizedResponse;

    }
}
