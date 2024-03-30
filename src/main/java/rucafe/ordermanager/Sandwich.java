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
}
