package com.company;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
public class JsonDecodeExample1 {
    public static void main(String[] args) {
        String s="{\"name\":\"sonoo\",\"salary\":600000.0,\"age\":27}";
        Object obj=JSONValue.parse(s);
        JSONObject jsonObject = (JSONObject) obj;

        String name = (String) jsonObject.get("name");
        double salary = (Double) jsonObject.get("salary");
        long age = (Long) jsonObject.get("age");
        System.out.println("String JSON : " + s);
        System.out.println("JSONObject  : " + jsonObject);
        System.out.println(name+" "+salary+" "+age);
    }
}
