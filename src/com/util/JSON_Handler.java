package com.util;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


//This JSON handler will handle all the json paths.
public class JSON_Handler {
    static JSONParser parser = new JSONParser();
    static final String JSON_PATH = "src/com/Assets/json/";


    public static JSONObject getJSON(String filename, String fileType) {
        JSONObject jsonObject = null;
        String path = getJsonPath(filename, fileType);

        try {
            if(Files.exists(Path.of(path))){
            FileReader file = new FileReader(path);
            Object obj = parser.parse(file);
            jsonObject = (JSONObject) obj; //Casting the Json file
            file.close();
            }

        } catch (IOException e) {
            System.err.print("Error. File not found");
        } catch (ParseException e) {
            System.out.println("Position: " + e.getPosition());
            e.printStackTrace();
        }
        return jsonObject;
    }


    public static String getJsonPath(String fileName, String fileLocation){
        String path = null;

        switch (fileLocation.toLowerCase()){
            case "json":
                path =  JSON_PATH + fileName;
                break;
            default:
                System.out.println("Invalid file type!");
        }
        return path;
    }

    public static void main(String[] args) {
        //Test your json paths here
        System.out.println(getJSON("PlayerCommands.JSON", "json"));

    }
}
