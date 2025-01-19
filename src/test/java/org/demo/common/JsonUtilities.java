package org.demo.common;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class JsonUtilities {

    /**
     * Method to fetch value from json.
     * @param jsonFileName json file of scenario
     * @return HashMap of scenario variables
     * @throws Exception if the file is not found
     */
    public static HashMap<String, Object> fetchValuesFromJson(String jsonFileName) throws Exception {

        HashMap<String, Object> scenarioDataMap = new HashMap<>();
        String filePath = System.getProperty("user.dir") + "/src/test/resources/Data/" + jsonFileName;

        // Read the JSON file
        try {
            // Create an ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Parse the JSON file into a JsonNode
            JsonNode rootNode = objectMapper.readTree(new File(filePath));

            // Access the "scenarioData" object
            JsonNode scenarioData = rootNode.get("scenarioData");

            // Iterate over the fields and put them into the HashMap
            scenarioData.fields().forEachRemaining(entry -> {
                scenarioDataMap.put(entry.getKey(), entry.getValue().asText());
            });

        } catch (IOException e) {
            System.err.println("Error reading JSON file: " + e.getMessage());
            e.printStackTrace();
        }

        return scenarioDataMap;
    }

}
