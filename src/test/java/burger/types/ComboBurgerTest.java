package burger.types;

import burger.ingredients.EBreadType;
import burger.ingredients.EMeatChoice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComboBurgerTest {

    @Test
    public void testAddingIngredients() {
        ComboBurger hamburger = new ComboBurger(EBreadType.CIABATTA, EMeatChoice.FISH_PATTY);

        hamburger.addTopping("CUCUMBER");
        Assertions.assertEquals(0, hamburger.getToppingNames().size());
        hamburger.addTopping("CHEESE");
        Assertions.assertEquals(0, hamburger.getToppingNames().size());
        hamburger.addTopping("MAYO");
        Assertions.assertEquals(0, hamburger.getToppingNames().size());
        Assertions.assertFalse(hamburger.addTopping("CUCUMBER"));
    }

    @Test
    public void testFinalPrice1() {
        ComboBurger hamburger = new ComboBurger(EBreadType.CIABATTA, EMeatChoice.KOBE_BEEF_PATTY);

        hamburger.addTopping("topping1");
        assertEquals(8, hamburger.getFinalPrice());
        hamburger.addTopping("topping2");
        assertEquals(8, hamburger.getFinalPrice());
        hamburger.addTopping("topping3");
        assertEquals(8, hamburger.getFinalPrice());
        hamburger.addTopping("topping4");
        assertEquals(8, hamburger.getFinalPrice());
        hamburger.addTopping("topping5");
        assertEquals(8, hamburger.getFinalPrice());
    }

    @Test
    public void testToppingPrice() {
        ComboBurger hamburger = new ComboBurger(EBreadType.WHOLEGRAIN, EMeatChoice.FISH_PATTY);
        assertEquals(0, hamburger.getToppingPrice());
        hamburger.addTopping("topping1");
        assertEquals(0, hamburger.getToppingPrice());
    }


}
