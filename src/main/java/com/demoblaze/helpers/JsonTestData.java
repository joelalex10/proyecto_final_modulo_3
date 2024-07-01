package com.demoblaze.helpers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JsonTestData {

    private static final Logger log = LogManager.getLogger(JsonTestData.class);

    public static JsonTestData helper() {
        log.info("JsonTestData created");
        return new JsonTestData();
    }

    public <T> Object[] getTestDataFromJson(String filePath, Class<T> clazz) throws FileNotFoundException {
        log.info("filePath: " + filePath);
        JsonReader reader = new JsonReader(new FileReader(filePath));
        List<T> testDataList = new Gson().fromJson(reader, TypeToken.getParameterized(ArrayList.class, clazz).getType());
        log.info("getTestData: "+ testDataList.toString());
        return testDataList.toArray();
    }

}
