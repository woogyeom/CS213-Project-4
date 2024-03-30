package rucafe.ordermanager;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<MenuItem> items;
    private int orderNumber;

    public Order(int orderNumber) {
        this.items = new ArrayList<MenuItem>();
        this.orderNumber = orderNumber;
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void removeItem(MenuItem item) {
        // We don't need to return boolean to show how it went
        // cause it is guaranteed that the item is in the order
        items.remove(item);
    }

    public double getSubTotal() {
        double subtotal = 0;
        for (MenuItem item : items) {
            subtotal += item.price();
        }
        return subtotal;
    }

    public double getSalesTax() {
        return getSubTotal() * 0.0625;
    }

    public double getTotalAmount() {
        return getSubTotal() + getSalesTax();
    }
}
