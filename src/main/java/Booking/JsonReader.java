package Booking;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {
    public static JSONObject readJSON() {
        JSONParser jsonParser = new JSONParser();
    try {
        FileReader reader = new FileReader("src/test/resources/testData.json");
        Object jsonObj = jsonParser.parse(reader);
       return (JSONObject) jsonObj;

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (ParseException e) {
        e.printStackTrace();
    } catch (IOException e){
        e.printStackTrace();
    }

    return null;
    }
}












