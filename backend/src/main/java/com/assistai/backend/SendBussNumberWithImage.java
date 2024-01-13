package com.assistai.backend;

import com.assistai.backend.core.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SendBussNumberWithImage {

    @RequestMapping(path = "/sendBussNumberImage", method = RequestMethod.POST)
    @ResponseBody

    public Map<String, Object> sendBussNumber(String image) throws IOException {
        Logger logger = LoggerFactory.getLogger(SendBussNumberWithImage.class);

        String response = SimpleHttpRequest.sendPostRequest(image);

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> jsonResponseFromRequest = objectMapper.readValue(response, Map.class);

        // Extract information from the parsed response
        double time = (double) jsonResponseFromRequest.get("time");
        Map<String, Object> imageInfo = (Map<String, Object>) jsonResponseFromRequest.get("image");
        Iterable<Map<String, Object>> predictions = (Iterable<Map<String, Object>>) jsonResponseFromRequest.get("predictions");

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
