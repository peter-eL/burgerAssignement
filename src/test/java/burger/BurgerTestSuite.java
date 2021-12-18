package burger;

import burger.types.ComboBurgerTest;
import burger.types.HamburgerTest;
import burger.types.HealthyBurgerTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Hamburgers test")
@SelectClasses({HamburgerTest.class, HealthyBurgerTest.class, ComboBurgerTest.class})
public class BurgerTestSuite {

}
