package rucafe.ordermanager;

public enum DonutType {
    YEAST(1.79, "yeast donuts", new String[]{"Yeast 1", "Yeast 2", "Yeast 3", "Yeast 4", "Yeast 5", "Yeast 6"}),
    CAKE(1.89, "cake donuts", new String[]{"Cake 1", "Cake 2", "Cake 3"}),
    HOLE(0.39, "donut holes", new String[]{"Hole 1", "Hole 2", "Hole 3"});

    private final double price;
    private final String displayName;
    private final String[] flavors;

    DonutType(double price, String displayName, String[] flavors) {
        this.price = price;
        this.displayName = displayName;
        this.flavors = flavors;
    }

    public double getPrice() {
        return price;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String[] getFlavors() {
        return flavors;
    }

    public static DonutType fromDisplayName(String displayName) {
        for (DonutType type : DonutType.values()) {
            if (type.getDisplayName().equals(displayName)) {
                return type;
            }
        }
        return null;
    }

}
