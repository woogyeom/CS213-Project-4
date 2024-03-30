package rucafe.ordermanager;

public class Sandwich extends MenuItem{
    private final String bread;
    private final SandwichProtein protein;
    private final boolean[] add_ons;
    // [cheese, lettuce, tomatoes, onions]
    private static final double CHEESE_ADD_ON_PRICE = 1.00;
    private static final double VEGI_ADD_ON_PRICE = 0.30;

    public Sandwich(String bread, SandwichProtein protein, boolean[] add_ons) {
        this.bread = bread;
        this.protein = protein;
        this.add_ons = add_ons;
    }

    public String getBread() {
        return bread;
    }

    public SandwichProtein getProtein() {
        return protein;
    }

    public boolean[] getAdd_ons() {
        return add_ons;
    }

    @Override
    public double price() {
        int cheese_count = 0;
        int vegi_count = 0;
        for (int i = 0; i < add_ons.length; i++) {
            if (add_ons[i]) {
                if (i == 0) {
                    cheese_count++;
                } else {
                    vegi_count++;
                }
            }
        }
        return protein.getPrice() + (cheese_count * CHEESE_ADD_ON_PRICE) + (vegi_count * VEGI_ADD_ON_PRICE);
    }

    @Override
    public String toString() {
        String returnString = "(SANDWICH) [Item Number: " + this.getItemNumber() + "] Bread: " + bread + " Protein: " + protein.toString() + " Add-ons:";
        String add = "";
        if (add_ons[0]) add += " Cheese,";
        if (add_ons[1]) add += " Lettuce,";
        if (add_ons[2]) add += " Tomatoes,";
        if (add_ons[3]) add += " Onions,";
        if (add.isEmpty()) add = " None,";
        returnString += add;

        returnString += " PRICE: $" + String.format("%.2f", this.price());

        return returnString;
    }

}
