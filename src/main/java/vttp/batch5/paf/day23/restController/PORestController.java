package vttp.batch5.paf.day23.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vttp.batch5.paf.day23.service.POService;

@RestController
@RequestMapping("/api")
public class PORestController {

    @Autowired
    POService poService;
    
    @PutMapping(path = "/purchaseorder", consumes = "application/json")
    public ResponseEntity<String> handleCheckout(@RequestBody String json){
        Boolean addedPO = poService.addPurchase(json);

        if(!addedPO){
            return ResponseEntity.badRequest().body("{}");
        }else return ResponseEntity.ok("{}");

    }
    
    // System.out.println(json);
    // {"name":"adele","address":"Windsor Road","deliveryDate":"2025-01-07","lineItems":[{"name":"Bread","quantity":1,"unitPrice":1.8}]}
}
