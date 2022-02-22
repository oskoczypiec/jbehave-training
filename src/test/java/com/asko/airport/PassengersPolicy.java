package com.asko.airport;

import org.jbehave.core.annotations.*;
import static org.junit.jupiter.api.Assertions.*;

public class PassengersPolicy {
    private Flight economyFlight;
    private Passenger mike;

    @Given("there is an economy flight")
    public void givenASystemState() {
        economyFlight = new EconomyFlight("1");
    }

    @When("we have a usual passenger")
    public void whenIDoSomething() {
        mike = new Passenger("Mike", false);
    }

    @Then("you can add and remove him from an economy flight")
    public void thenSystemIsInADifferentState() {
        assertAll("Verify all conditions for a usual passenger and an economy flight",
                () -> assertEquals("1", economyFlight.getId()),
                () -> assertEquals(true, economyFlight.addPassenger(mike)),
                () -> assertEquals(1, economyFlight.getPassengersList().size()),
                () -> assertEquals("Mike", economyFlight.getPassengersList().get(0).getName()),
                () -> assertEquals(true, economyFlight.removePassenger(mike)),
                () -> assertEquals(0, economyFlight.getPassengersList().size())
        );
    }
}
