package vttp.batch5.paf.day23.service;

import java.io.StringReader;
import java.sql.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import vttp.batch5.paf.day23.repository.PORepository;

@Service
public class POService {

    @Autowired
    PORepository poRepo;

    public Boolean addPurchase(String json) {
       JsonReader jReader = Json.createReader(new StringReader(json));
       JsonObject jObject = jReader.readObject();
       String id = UUID.randomUUID().toString();
       String name = jObject.getString("name");
       String address = jObject.getString("address");
       Date deliveryDate = Date.valueOf(jObject.getString("deliveryDate"));
       Boolean addedPO = poRepo.addPurchase(id, name, address, deliveryDate);
       
       JsonArray lineItems = jObject.getJsonArray("lineItems");
       for (int i = 0; i < lineItems.size(); i++) {
        JsonObject item = lineItems.getJsonObject(i);
        String itemName = item.getString("name");
        Integer quantity = item.getInt("quantity");
        Double unitPrice = item.getJsonNumber("unitPrice").doubleValue();
        Boolean addedItem = poRepo.addItem(itemName, quantity, unitPrice, id);

        if(!addedItem){
            addedPO = false;
        }
       }

       return addedPO;
    }
    
}
