package burger.types;

import burger.ingredients.EBreadType;
import burger.ingredients.EMeatChoice;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HamburgerTest {

    @Test
    public void testAddingIngredients() {
        Hamburger hamburger = new Hamburger(EBreadType.BRIOCHE, EMeatChoice.BLACK_ANGUS_PATTY);
        hamburger.addTopping("CUCUMBER");
        assertEquals(1, hamburger.getToppingNames().size());
        hamburger.addTopping("CHEESE");
        assertEquals(2, hamburger.getToppingNames().size());
        hamburger.addTopping("MAYO");
        assertEquals(3, hamburger.getToppingNames().size());
        hamburger.addTopping("KETCHUP");
        assertEquals(4, hamburger.getToppingNames().size());
        assertFalse(hamburger.addTopping("MUSTARD"));
        assertEquals(4, hamburger.getToppingNames().size());
    }

    @Test
    public void testAddingTooManyIngredients() {
        Hamburger hamburger = new Hamburger(EBreadType.WHOLEGRAIN, EMeatChoice.KOBE_BEEF_PATTY);
        for (int i = 1; i < 50; i++) {
            hamburger.addTopping("ingredient" +i);
        }

        List<String> expectedToppings = new ArrayList<>();
        expectedToppings.add("ingredient1");
        expectedToppings.add("ingredient2");
        expectedToppings.add("ingredient3");
        expectedToppings.add("ingredient4");
        assertEquals(expectedToppings, hamburger.getToppingNames());
    }

    @Test
    public void testFinalPrice() {
        Hamburger hamburger = new Hamburger(EBreadType.CIABATTA, EMeatChoice.KOBE_BEEF_PATTY);

        hamburger.addTopping("topping1");
        assertEquals(7, hamburger.getFinalPrice());
        hamburger.addTopping("topping2");
        assertEquals(9, hamburger.getFinalPrice());
        hamburger.addTopping("topping3");
        assertEquals(11, hamburger.getFinalPrice());
        hamburger.addTopping("topping4");
        assertEquals(13, hamburger.getFinalPrice());
        hamburger.addTopping("topping5");
        assertEquals(13, hamburger.getFinalPrice());
    }

    // base price has to be the same, no matter what
    @Test
    public void testBasePrice1() {
        for (EBreadType breadType : EBreadType.values()) {
            for (EMeatChoice meatChoice : EMeatChoice.values()) {
                Hamburger hamburger = new Hamburger(breadType, meatChoice);
                assertEquals(5, hamburger.getBasePrice());
            }
        }
    }

    @Test
    public void testBasePrice2() {
        Hamburger hamburger = new Hamburger(EBreadType.WHOLEGRAIN, EMeatChoice.VEGAN_PATTY);
        assertEquals(5, hamburger.getBasePrice());
        hamburger.addTopping("topping1");
        assertEquals(5, hamburger.getBasePrice());
    }

    // topping price has to be the same, no matter what
    @Test
    public void testToppingPrice1() {
        Hamburger hamburger = new Hamburger(EBreadType.BRIOCHE, EMeatChoice.KOBE_BEEF_PATTY);
        hamburger.addTopping("top1");
        assertEquals(2, hamburger.getToppingPrice());
        hamburger.addTopping("top2");
        assertEquals(4, hamburger.getToppingPrice());
        hamburger.addTopping("top3");
        assertEquals(6, hamburger.getToppingPrice());
        hamburger.addTopping("top4");
        assertEquals(8, hamburger.getToppingPrice());
    }

    @Test
    public void testRemoveTopping() {
        Hamburger hamburger = new Hamburger(EBreadType.BRIOCHE, EMeatChoice.KOBE_BEEF_PATTY);
        assertFalse(hamburger.removeTopping("top1"));
        hamburger.addTopping("ketchup");
        hamburger.addTopping("mayo");

        List<String> expectedToppings = new ArrayList<>();
        expectedToppings.add("ketchup");
        expectedToppings.add("mayo");
        assertEquals(expectedToppings, hamburger.getToppingNames());
        assertFalse(hamburger.removeTopping("cheese"));
        assertEquals(expectedToppings, hamburger.getToppingNames());
        assertTrue(hamburger.removeTopping("ketchup"));

        List<String> expectedToppings2 = new ArrayList<>();
        expectedToppings2.add("mayo");
        assertEquals(expectedToppings2, hamburger.getToppingNames());
    }

    @Test
    public void testRemoveToppingPrice() {
        Hamburger hamburger = new Hamburger(EBreadType.BRIOCHE, EMeatChoice.KOBE_BEEF_PATTY);
        hamburger.addTopping("topping1");
        hamburger.addTopping("topping2");
        hamburger.addTopping("topping3");
        assertEquals(6, hamburger.getToppingPrice());
        hamburger.removeTopping("topping1");
        assertEquals(4, hamburger.getToppingPrice());
        hamburger.removeTopping("topping2");
        assertEquals(2, hamburger.getToppingPrice());
        hamburger.removeTopping("topping2");
        assertEquals(2, hamburger.getToppingPrice());
        hamburger.removeTopping("topping3");
        assertEquals(0, hamburger.getToppingPrice());
    }

}
