import jdk.jfr.BooleanFlag;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class ShuttleTest {

    public Shuttle shuttle;
    public Passenger passenger;

    @Before
    public void setUpShuttle(){
        TaxiCompany taxiCompany =  new TaxiCompany();
        Location location = new Location(0, 0);
        Location pickup = new Location(5, 5);
        Location dropoff = new Location(10, 10);

        passenger = new Passenger(pickup, dropoff);
        shuttle = new Shuttle(taxiCompany,location);
    }

    @Test
    void testPickupOfPassenger() {
        setUpShuttle();
        shuttle.pickup(passenger);
        assertTrue(shuttle.isFree());
    }

    @Test
    public void offloadingPassenger(){
        setUpShuttle();
        shuttle.offloadPassenger();
        assertTrue(shuttle.isFree());
    }

    @Test
    public void testDeliveringSinglePassenger(){
        setUpShuttle();
        Location pickupPoint = passenger.getPickupLocation();
        Location dropoffPoint = passenger.getDestination();

        int expectedSteps = shuttle.getLocation().distance(pickupPoint) + pickupPoint.distance(dropoffPoint);

        shuttle.pickup(passenger);

        int steps = 0;
        while(shuttle.isFree() && steps < expectedSteps) {
            shuttle.act();
            steps++;
        }
        assertEquals(steps, expectedSteps);
        assertTrue(shuttle.isFree());
    }
}