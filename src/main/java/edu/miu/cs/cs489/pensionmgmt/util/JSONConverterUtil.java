package edu.miu.cs.cs489.pensionmgmt.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.miu.cs.cs489.pensionmgmt.model.Employee;
import org.json.JSONArray;

import java.io.IOException;
import java.util.List;

public class JSONConverterUtil {
    public static String employeeListToJSON(List<Employee> employees) {
        // Convert the list of Employee objects to JSON string
        // Using the simple, light-weight JSON.org parser library
        JSONArray jsonArray = new JSONArray();
        employees.forEach(employee -> {
            jsonArray.put(employee.toJSON());
        });
        return jsonArray.toString(4); // Pretty print with an indent of 4 spaces
    }

    public static String employeeListToJSON2(List<Employee> employees) {
        // Convert the list of Employee objects to JSON string using your preferred library (e.g., Jackson, Gson)
        // For example, using Jackson:
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(employees);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String toJson(Object object) {
        // Convert the object to JSON string using your preferred library (e.g., Jackson, Gson)
        // For example, using Jackson:
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T fromJson(String jsonString, Class<T> clazz) {
        // Convert the JSON string back to the object using your preferred library (e.g., Jackson, Gson)
        // For example, using Jackson:
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonString, clazz);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
