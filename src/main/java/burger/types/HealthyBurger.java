package burger.types;

import burger.ingredients.EBreadType;
import burger.ingredients.EMeatChoice;

public class HealthyBurger extends Hamburger {

    private static final int MAX_TOPPING_SIZE = 6;

    public HealthyBurger(EBreadType breadType, EMeatChoice meatChoice) {
        super(breadType, meatChoice);
    }

    @Override
    protected int getMaxToppingSize() {
        return MAX_TOPPING_SIZE;
    }
}
