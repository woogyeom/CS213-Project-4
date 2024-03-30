package rucafe.ordermanager;

public abstract class MenuItem {
    public abstract double price();
    private int orderNumber;

    public void setItemNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getItemNumber() {
        return this.orderNumber;
    }

}
