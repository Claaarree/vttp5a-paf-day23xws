package vttp.batch5.paf.day23.repository;

public class Queries {
    public static String SQL_ADD_PO = """
            insert into po(po_id, name, address, delivery_date)
                values(?, ?, ?, ?);
            """;

    public static String SQL_ADD_LINEITEM = """
            insert into line_item(name, quantity, unit_price, po_id)
                values(?, ?, ?, ?);
            """;
}
