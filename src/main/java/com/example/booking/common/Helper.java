package com.example.booking.common;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Helper {

    public static String getResourceDir() {
        return System.getProperty("user.dir") + "/src/main/resources/";
    }

    public static String getCurrentTime() {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-HH-mm-ss");
        return dateFormat.format(date);
    }

    public static String imgTagBuilder(String base64) {
        return String.format("<img src=\"data:image/png;base64, %s\" width=\"500\" height=\"768\"/>",
                base64);
    }

    public static String getDeviceId() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader(getResourceDir() + "config.json");
        JSONObject jsonObj = (JSONObject) jsonParser.parse(fileReader);
        return (String) jsonObj.get("deviceId");
    }
}