package burger.types;

import burger.ingredients.EBreadType;
import burger.ingredients.EMeatChoice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HealthyBurgerTest {

    @Test
    public void testAddingIngredients() {
        HealthyBurger hamburger = new HealthyBurger(EBreadType.WHITE, EMeatChoice.VEGAN_PATTY);
        hamburger.addTopping("CUCUMBER");
        Assertions.assertEquals(1, hamburger.getToppingNames().size());
        hamburger.addTopping("CHEESE");
        Assertions.assertEquals(2, hamburger.getToppingNames().size());
        hamburger.addTopping("MAYO");
        Assertions.assertEquals(3, hamburger.getToppingNames().size());
        hamburger.addTopping("KETCHUP");
        Assertions.assertEquals(4, hamburger.getToppingNames().size());
        Assertions.assertTrue(hamburger.addTopping("MUSTARD"));
        Assertions.assertEquals(5, hamburger.getToppingNames().size());
        hamburger.addTopping("BACON");
        Assertions.assertEquals(6, hamburger.getToppingNames().size());
        Assertions.assertFalse(hamburger.addTopping("SALAD"));
        Assertions.assertEquals(6, hamburger.getToppingNames().size());
    }

    @Test
    public void testAddingTooManyIngredients() {
        HealthyBurger hamburger = new HealthyBurger(EBreadType.WHOLEGRAIN, EMeatChoice.KOBE_BEEF_PATTY);
        for (int i = 1; i < 50; i++) {
            hamburger.addTopping("ingredient" +i);
        }

        List<String> expectedToppings = new ArrayList<>();
        expectedToppings.add("ingredient1");
        expectedToppings.add("ingredient2");
        expectedToppings.add("ingredient3");
        expectedToppings.add("ingredient4");
        expectedToppings.add("ingredient5");
        expectedToppings.add("ingredient6");
        assertEquals(expectedToppings, hamburger.getToppingNames());
    }


    @Test
    public void testFinalPrice() {
        HealthyBurger hamburger = new HealthyBurger(EBreadType.CIABATTA, EMeatChoice.KOBE_BEEF_PATTY);

        hamburger.addTopping("topping1");
        assertEquals(7, hamburger.getFinalPrice());
        hamburger.addTopping("topping2");
        assertEquals(9, hamburger.getFinalPrice());
        hamburger.addTopping("topping3");
        assertEquals(11, hamburger.getFinalPrice());
        hamburger.addTopping("topping4");
        assertEquals(13, hamburger.getFinalPrice());
        hamburger.addTopping("topping5");
        assertEquals(15, hamburger.getFinalPrice());
        hamburger.addTopping("topping6");
        assertEquals(17, hamburger.getFinalPrice());
        hamburger.addTopping("topping7");
        assertEquals(17, hamburger.getFinalPrice());
    }


}
