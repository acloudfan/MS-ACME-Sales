package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpTest {

    public static void main(String[] args) throws  Exception {

        // Dummy API that returns JSON
        String GET_URL = "https://jsonplaceholder.typicode.com/todos/1";

        // 1. Create a URL object
        URL obj = new URL(GET_URL);

        // 2. Create a connection to the API endpoint
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // 3. Set the HTTP Verb
        con.setRequestMethod("GET");

        // 4. READ THE Data from the server - returned as strings/lines of data
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // print result
        System.out.println(response.toString());


    }
}
