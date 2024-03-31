package rucafe.ordermanager;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<MenuItem> items;
    private int orderNumber;
    private int nextItemNumber = 1;

    public Order() {
        this.items = new ArrayList<MenuItem>();
    }

    public void addItem(MenuItem item) {
        item.setItemNumber(nextItemNumber++);
        items.add(item);
    }

    public void removeItem(int itemNumber) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getItemNumber() == itemNumber) {
                items.remove(i);
                return;
            }
        }
    }

    public void removeItem(MenuItem menuItem) {
        MenuItem itemToRemove = null;
        for (MenuItem item : items) {
            if (item.equals(menuItem)) {
                itemToRemove = item;
            }
        }
        if (itemToRemove != null) items.remove(itemToRemove);
    }

    public List<MenuItem> getItems() {
        return items;
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

    public int getOrderNumber() {
        return this.orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public boolean contains(MenuItem menuItem) {
        for (MenuItem item : items) {
            if (item.equals(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public MenuItem find(MenuItem menuItem) {
        for (MenuItem item : items) {
            if (item.equals(menuItem)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String returnString = "Order Number: " + this.orderNumber + "\n";
        for (int i = 0; i < items.size(); i++) {
            returnString += items.get(i).toString() + "\n";
        }
        returnString += "\nSub Total: $" + String.format("%.2f", this.getSubTotal());
        returnString += "\nSales Tax: $" + String.format("%.2f", this.getSalesTax());
        returnString += "\nTotal Amount: $" + String.format("%.2f", this.getTotalAmount());
        return returnString;
    }
}
