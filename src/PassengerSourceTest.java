import java.util.List;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PassengerSourceTest.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class PassengerSourceTest
{
    private PassengerSource source;
    
    /**
     * Default constructor for test class PassengerSourceTest
     */
    public PassengerSourceTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        TaxiCompany company = new TaxiCompany();
        source = new PassengerSource(company);
        Location taxiLocation = new Location(0, 0);
        Taxi taxi = new Taxi(company, taxiLocation);
        List<Vehicle> vehicles = company.getVehicles();
        vehicles.add(taxi);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        source = null;
    }

    /**
     * Test for successful pickup of a passenger.
     */
    @Test
    public void testPickup()
    {
        assertEquals(true, source.requestPickup());
    }

    /**Test to check a passenger's request was created**/
    @Test
    public void testCreationOfPassenger(){
        Location pickup = new Location(6, 5);
        Location dropoff = new Location(12, 15);
        Passenger passenger = new Passenger(pickup, dropoff);
        assertEquals(pickup, passenger.getPickupLocation());
        assertEquals(dropoff, passenger.getDestination());
    }
}
