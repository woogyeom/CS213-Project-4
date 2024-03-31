package rucafe.ordermanager;

public abstract class MenuItem {
    public abstract double price();
    public abstract boolean equals(MenuItem menuItem);

    public abstract int getQuantity();
    public abstract void setQuantity(int quantity);

    private int itemNumber;

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public int getItemNumber() {
        return this.itemNumber;
    }

}
