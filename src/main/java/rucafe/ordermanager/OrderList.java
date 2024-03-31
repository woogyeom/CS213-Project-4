package rucafe.ordermanager;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class OrderList {
    private static OrderList instance;
    private final List<Order> orders;
    private Order curOrder;
    private int nextOrderNumber = 1;

    public OrderList() {
        curOrder = new Order();
        orders = new ArrayList<Order>();
    }

    public static OrderList getInstance() {
        if (instance == null) {
            instance = new OrderList();
        }
        return instance;
    }

    public Order getCurOrder() {
        return curOrder;
    }

    public int submitOrder(Order order) {
        order.setOrderNumber(nextOrderNumber++);
        orders.add(order);
        curOrder = new Order();
        return nextOrderNumber-1; // just returning the order's number because why not. If we don't ever need it we can change it to a void method.
    }

    public void removeOrder(int orderNumber) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNumber() == orderNumber) {
                orders.remove(i);
                return;
            }
        }
    }

    public String getOrder(int orderNumber) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNumber() == orderNumber) {
                return orders.get(i).toString();
            }
        }
        return "Order Number Does Not Exist";
    }

    public void saveOrdersToFile() {
        try (PrintWriter pw = new PrintWriter(new File("orders.txt"))) {
            for (Order order : orders) {
                pw.println(order.toString());
                pw.println("-----");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Failed to save orders to the file: " + e.getMessage());
        }
    }

}
