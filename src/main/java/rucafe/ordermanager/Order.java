package rucafe.ordermanager;

public class Order {
    private static final int INITIAL_CAPACITY = 4;
    private static final int NOT_FOUND = -1;
    private static final int GROWTH = 4;

    private MenuItem[] items;
    private int orderNumber;
    private int size;

    public Order(int orderNumber) {
        this.items = new MenuItem[INITIAL_CAPACITY];
        this.orderNumber = orderNumber;
        this.size = 0;
    }

    public void addItem(MenuItem item) {
        if (size == items.length) {
            grow();
        }
        items[size] = item;
        size++;
    }

    private void grow() {
        MenuItem[] newItems = new MenuItem[items.length + GROWTH];
        for (int i = 0; i < items.length; i++) {
            newItems[i] = items[i];
        }
        items = newItems;
    }

    public boolean removeItem(int itemNumber) { // For this method, I'm assuming that we will display an order's items with item numbers that are just itemIndex+1, so we can use that number to easily identify which item to delete
        if (itemNumber-1 > size || itemNumber-1 < 0) {
            return false;
        }

        for (int i = itemNumber-1; i < size-1; i++) {
            items[i] = items[i+1];
        }
        size--;
        items[size] = null;
        return true;
    }

    public double getOrderPrice() {
        double total = 0;
        for (int i = 0; i < size; i++) {
            total += items[i].price();
        }
        return total;
    }
}
