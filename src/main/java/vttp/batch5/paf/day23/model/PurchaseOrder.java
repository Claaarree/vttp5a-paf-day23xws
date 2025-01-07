package vttp.batch5.paf.day23.model;

import java.util.Date;
import java.util.List;

public class PurchaseOrder {
    private String name;
    private String address;
    private Date deliveryDate;
    private List<LineItems> lineItems;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Date getDeliveryDate() {
        return deliveryDate;
    }
    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    public List<LineItems> getLineItems() {
        return lineItems;
    }
    public void setLineItems(List<LineItems> lineItems) {
        this.lineItems = lineItems;
    }

    
}