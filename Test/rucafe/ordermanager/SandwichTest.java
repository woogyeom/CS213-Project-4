package rucafe.ordermanager;

import org.junit.Test;

import static org.junit.Assert.*;

public class SandwichTest {

    @Test
    public void testPrice_BeefWithCheese() {
        Sandwich sandwich = new Sandwich("Wheat", SandwichProtein.BEEF, new boolean[]{true, false, false, false}, 1);
        assertEquals(11.99, sandwich.price(), 0.01);
    }

    @Test
    public void testPrice_FishWithAllAddOns() {
        // Adjusting the base price for Fish sandwiches to $9.99
        Sandwich sandwich = new Sandwich("Rye", SandwichProtein.FISH, new boolean[]{true, true, true, true}, 1);
        // The price needs to be adjusted based on the new base price
        assertEquals(11.89, sandwich.price(), 0.01);
    }

    @Test
    public void testPrice_ChickenWithVegetables() {
        // Adjusting the base price for Chicken sandwiches to $8.99
        Sandwich sandwich = new Sandwich("White", SandwichProtein.CHICKEN, new boolean[]{false, true, true, true}, 1);
        // The price needs to be adjusted based on the new base price
        assertEquals(9.89, sandwich.price(), 0.01);
    }

    @Test
    public void testPrice_BeefDoubleWithCheeseAndTomato() {
        Sandwich sandwich = new Sandwich("Sourdough", SandwichProtein.BEEF, new boolean[]{true, false, true, false}, 2);
        assertEquals(24.58, sandwich.price(), 0.01);
    }

    @Test
    public void testPrice_ChickenPlain() {
        // Adjusting the base price for Chicken sandwiches to $8.99
        Sandwich sandwich = new Sandwich("Whole Grain", SandwichProtein.CHICKEN, new boolean[]{false, false, false, false}, 1);
        assertEquals(8.99, sandwich.price(), 0.01);
    }
}