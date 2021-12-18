package burger.types;

import java.util.List;

public interface IHamburger {

    /**
     * Adds a topping to the burger if it does not exceed the maximum allowed topping size
     */
    boolean addTopping(String toppingName);

    /**
     * Returns price of all toppings
     */
    int getToppingPrice();

    /**
     * Calculates the final price of the burger, counting base price + toppings + extras
     */
    int getFinalPrice();

    /**
     * Returns the base price of the hamburger
     */
    int getBasePrice();

    /**
     * Returns a list of all added toppings to the burger
     */
    List<String> getToppingNames();
}
