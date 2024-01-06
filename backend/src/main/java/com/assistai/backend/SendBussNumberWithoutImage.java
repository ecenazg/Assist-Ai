package com.assistai.backend;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class SendBussNumberWithoutImage {

    @RequestMapping(path = "/sendBussNumber", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject sendBussNumber() throws IOException {
        String image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTw8lmldap-c8JkSt7d4r0Y6V8oJY7sb0cEfg&usqp=CAU";

        String response = SimpleHttpRequest.sendPostRequest(image);

        JSONObject jsonResponse = new JSONObject(response);

        double time = jsonResponse.getDouble("time");
        JSONArray predictionsArray = jsonResponse.getJSONArray("predictions");

        JSONArray resultArray = new JSONArray();

        for (int i = 0; i < predictionsArray.length(); i++) {
            JSONObject prediction = predictionsArray.getJSONObject(i);

            double x = prediction.getDouble("x");
            double y = prediction.getDouble("y");
            double width = prediction.getDouble("width");
            double height = prediction.getDouble("height");
            double confidence = prediction.getDouble("confidence");
            String classLabel = prediction.getString("class");
            int classId = prediction.getInt("class_id");

            JSONObject resultObj = new JSONObject();
            resultObj.put("x", x);
            resultObj.put("y", y);
            resultObj.put("width", width);
            resultObj.put("height", height);
            resultObj.put("confidence", confidence);
            resultObj.put("classLabel", classLabel);
            resultObj.put("classId", classId);


            resultArray.put(resultObj);
            System.out.println("Result Array: " + resultArray);

        }

        JSONObject result = new JSONObject();
        result.put("resultArray", resultArray);

        return result;//return
    }
}
