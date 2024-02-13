
package sample;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;



public class LoadJson {

    private List<Object> prices = new ArrayList<>();
    private List<Object> date = new ArrayList<>();



    void readJson(File file) {

        try (FileReader reader = new FileReader((file))) {

            JSONParser jsonParser = new JSONParser();
            JSONArray jsonArray = (JSONArray) jsonParser.parse(reader);


            for (Object o : jsonArray) {
                if (o instanceof JSONObject) {

                    JSONObject jsonObject = (JSONObject) o;
                    prices.add(jsonObject.get("Price"));
                    date.add(jsonObject.get("Datetime"));

                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }



    public List<Object> getPrices() {
        return prices;
    }

    public List<Object> getDate() {
        return date;
    }


}

