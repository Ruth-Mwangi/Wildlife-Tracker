import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class SightingsTest {

    @Rule
    public DatabaseRule databaseRule=new DatabaseRule();

    @Test
    public void createInstanceOfSightingsClass_true() {

        Sightings sighting= setUpNewSighting();
        assertEquals(true,sighting instanceof Sightings);
    }
    //helper
    private Sightings setUpNewSighting() {
        return new Sightings(1,1,1);
    }
}