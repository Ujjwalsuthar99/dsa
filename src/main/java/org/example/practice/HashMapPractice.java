package org.example.practice;

import java.util.HashMap;
import java.util.Map;

public class HashMapPractice {


    public static void main(String[] args) {


        Map<String, Object> mainResponse = new HashMap<>() {{
            put("status", null);
            put("receipt_generated", false);
            put("sr_id", null);
        }};


        mainResponse.replace("status", "success");
        mainResponse.replace("receipt_generated", true);

        System.out.println("mainResponise: " + mainResponse);
    }
}
