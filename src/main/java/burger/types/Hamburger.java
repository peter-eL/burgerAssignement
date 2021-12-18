package burger.types;

import burger.ingredients.EBreadType;
import burger.ingredients.EMeatChoice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hamburger implements IHamburger {

    private final EBreadType breadType;
    private final EMeatChoice meatChoice;
    private final List<String> toppings = new ArrayList<>();

    private static final int MAX_TOPPING_SIZE = 4;
    private static final int BASE_PRICE = 5;
    private static final int TOPPING_PRICE = 2;
    private static final int EXTRA_COSTS = 0;

    public Hamburger(EBreadType breadType, EMeatChoice meatChoice) {
        // could throw a invalid parameter exception for null parameters
        this.breadType = breadType;
        this.meatChoice = meatChoice;
    }

    @Override
    public boolean addTopping(String toppingName) {
        // could do a check if it is a valid topping, if we had a full list of supported toppings
        if (toppings.size() < getMaxToppingSize()) {
            return toppings.add(toppingName);
        }
        return false;
    }

    public boolean removeTopping(String toppingName) {
        return toppings.remove(toppingName);
    }

    @Override
    public int getBasePrice() {
        return BASE_PRICE;
    }

    @Override
    public int getToppingPrice() {
        return TOPPING_PRICE * toppings.size();
    }

    @Override
    public int getFinalPrice() {
        return getBasePrice() + getToppingPrice() + getExtraCosts();
    }

    protected int getExtraCosts() {
        return EXTRA_COSTS;
    }

    @Override
    public List<String> getToppingNames() {
        return Collections.unmodifiableList(toppings);
    }

    public EBreadType getBreadType() {
        return breadType;
    }

    public EMeatChoice getMeatChoice() {
        return meatChoice;
    }

    protected int getMaxToppingSize() {
        return MAX_TOPPING_SIZE;
    }

    @Override
    public String toString() {
        return "Hamburger{" +
                "breadType=" + breadType +
                ", meatChoice=" + meatChoice +
                ", toppings=" + toppings +
                ", basePrice=" + BASE_PRICE +
                ", toppingPrice=" + TOPPING_PRICE +
                '}';
    }
}
