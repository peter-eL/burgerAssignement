package burger.types;

import burger.ingredients.EBreadType;
import burger.ingredients.EMeatChoice;

public class ComboBurger extends Hamburger {

    private static final int MAX_TOPPING_SIZE = 0;
    private static final int CHIPS_DRINKS_PRICE = 3;

    public ComboBurger(EBreadType breadType, EMeatChoice meatChoice) {
        super(breadType, meatChoice);
    }

    @Override
    protected int getMaxToppingSize() {
        return MAX_TOPPING_SIZE;
    }

    @Override
    public int getExtraCosts() {
        return CHIPS_DRINKS_PRICE;
    }
}
