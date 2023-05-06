import org.junit.Test;
import static org.junit.Assert.*;

public class LocationTest
{

    //Tests constructor by creating new location and using the getX and getY methods to return correct values
    @Test
    public void testConst() {
        Location locat = new Location(2, 3);
        assertEquals(2, locat.getX());
        assertEquals(3, locat.getY());
    }

    //Tries to create a new Location using negative X value and should return Exception
    @Test(expected = IllegalArgumentException.class)
    public void testConstNegativeX() {
        Location locat = new Location(-8, 4);
    }

    //Tries to create a new Location using negative Y value and should return Exception
    @Test(expected = IllegalArgumentException.class)
    public void testConstNegativeY() {
        Location locat1 = new Location(3, -8);
    }

    //Creates two new locations and calls nextLocation method on the first method with second location as a parameter and ensures it returns correct values
    @Test
    public void testNextLocation() {
        Location locat1 = new Location(3, 4);
        Location locat2 = new Location(5, 6);
        Location nextLoc = locat1.nextLocation(locat2);
        assertEquals(4, nextLoc.getX());
        assertEquals(5, nextLoc.getY());
    }

    //Creates 2 location objects and calls distance method on the first object with second object as the parameter anc checks if it returns the correct values for distance
    @Test
    public void testDist() {
        Location locat1 = new Location(3, 4);
        Location locat2 = new Location(5, 6);
        int distance = locat1.distance(locat2);
        assertEquals(2, distance);
    }

    //Tests the toString method()
    @Test
    public void testToStringMeth() {
        Location locat = new Location(3, 4);
        assertEquals("location 3,4", locat.toString());
    }
}
