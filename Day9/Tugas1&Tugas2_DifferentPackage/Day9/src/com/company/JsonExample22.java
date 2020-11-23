package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonExample22{
    public static void main(String args[]){
        JSONObject obj1 = new JSONObject();
        obj1.put("name","Doel");
        obj1.put("age",new Integer(24));
        obj1.put("salary",new Double(600000));
        JSONObject obj2 = new JSONObject();
        obj2.put("name","Mandra");
        obj2.put("age",new Integer(32));
        obj2.put("salary",new Double(600000));
        JSONObject obj3 = new JSONObject();
        obj3.put("name","Atun");
        obj3.put("age",new Integer(20));
        obj3.put("salary",new Double(600000));


        JSONArray arr = new JSONArray();
        arr.add(obj1);
        arr.add(obj2);
        arr.add(obj3);

        JSONObject emp = new JSONObject();
        emp.put("Employee", arr);




        System.out.println(emp);
    }}

