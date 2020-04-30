import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredAnimalsTest {

    @Rule
    public DatabaseRule databaseRule=new DatabaseRule();

    @Test
    public void testInstanceOfEndangeredAnimalsClass_true(){
        EndangeredAnimals testAnimal= setUpNewAnimal();
        assertEquals(true,testAnimal instanceof EndangeredAnimals);
    }

    private EndangeredAnimals setUpNewAnimal() {
        return new EndangeredAnimals("Albino Girrafe","healthy","young");
    }


}