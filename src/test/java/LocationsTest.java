import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class LocationsTest {
    @Rule
    public DatabaseRule databaseRule=new DatabaseRule();

    @Test
    public void createInstanceOfLocationsClass() {
        Locations location=setUpNewLocation();
        assertEquals(true,location instanceof Locations);
    }
    //helper function
    private Locations setUpNewLocation() {
        return new Locations("Zone A");
    }
}