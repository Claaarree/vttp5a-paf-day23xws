package vttp.batch5.paf.day23.repository;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PORepository {
    @Autowired
    JdbcTemplate template;

    public Boolean addPurchase(String id, String name, String address, Date deliveryDate) {
        Boolean addedPO = false;
        try {
            template.update(Queries.SQL_ADD_PO, id, name, address, deliveryDate);
            addedPO = true;
        } catch (DataAccessException e) {
            System.out.println("Error adding PO to db!");
            System.exit(1);
        }

        return addedPO;
    }

    public Boolean addItem(String itemName, Integer quantity, Double unitPrice, String id) {
        Boolean addedItem = false;
        try {
            template.update(Queries.SQL_ADD_LINEITEM, itemName, quantity, unitPrice, id);
            addedItem = true;
        } catch (DataAccessException e) {
            System.out.println("Error adding line item to db!");
            System.exit(1);
        }

        return addedItem;
    }
    
}
