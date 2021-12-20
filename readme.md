## **Hamburger selling process management**

The solution is made in java 11, using maven for dependency management. The only dependencies added to the project are the ones to run the Junit tests.

The project does not contain a Main class, it provides an API for burger management on the backend.

The unit tests can be run by running the _BurgerTestSuite_ that runs all the available tests.

### Pluses of solution
Solution that was quick to build.

Easy to extend, future new burgers need to only extend the Hamburger class.

### Possible improvements
Hardcoded values (mostly prices) in the burger classes. They could be replaced with a price configuration.

Configuration of toppings, as currently they are set as a String value, so there is no restriction what can be added like a topping. Also duplicates are allowed (as having double cheese does make sense).

Update tests that if prices are updated there is no need in manual change
