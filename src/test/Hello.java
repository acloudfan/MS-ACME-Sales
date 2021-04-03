package test;

import org.json.JSONObject;

public class Hello {


    public static void main(String[] args){

        // Create a JSON String
        String json = " {'name': 'john',  'age' : 32} ";

        // Create a JSON Object from JSON String
        JSONObject   jsonObject = new JSONObject(json);

        JSONObject  newJSONObject = new JSONObject( "{ 'address' : '123 main street'  }"  );

        jsonObject.put("balance",   Integer.valueOf(23));

        JSONObject  savedJson = jsonObject;

        System.out.println(jsonObject.toString(4));

//        {'name': 'john',  'age' : 32,  'balance' : 332 } ";

        jsonObject = new JSONObject();
        String[]  names = {"apple", "grapes", "orange"};
        jsonObject.append("friends", names);
        jsonObject.put("count", Integer.valueOf(names.length));

        jsonObject.put("details", savedJson);

        System.out.println(jsonObject.toString(4));

        ////////////

        String name = jsonObject.getJSONObject("details").getString("name");
        int    age  = jsonObject.getJSONObject("details").getInt("age");

        System.out.println(name + "    "+age);

    }
}
