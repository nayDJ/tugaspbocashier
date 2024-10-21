import java.util.ArrayList;
import java.util.Scanner;


class Item {
    private int itemPrice;
    private String itemName;
    private String itemCode;
    private int itemQty;

    public Item(String code, String name, int price, int qty) {
        this.itemCode = code;
        this.itemName = name;
        this.itemPrice = price;
        this.itemQty = qty;
    }

    public int getSubTotal() {
        return itemPrice * itemQty;
    }

    public int getPrice() {
        return itemPrice;
    }

    public String getCode() {
        return itemCode;
    }

    public String getName() {
        return itemName;
    }

    public int getQty() {
        return itemQty;
    }
}
