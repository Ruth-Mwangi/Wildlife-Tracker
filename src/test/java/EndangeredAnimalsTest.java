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

    @Test
    public void allInstancesAreSaved(){
        EndangeredAnimals testAnimal=setUpNewAnimal();
        testAnimal.save();
        assertTrue(EndangeredAnimals.all().get(0).equals(testAnimal));
    }
    @Test
    public void ensureNameFieldCannotBeEmpty(){
        EndangeredAnimals testAnimal=new EndangeredAnimals("");
        try {
            testAnimal.save();
        }catch (IllegalArgumentException e){

        }
    }

    private EndangeredAnimals setUpNewAnimal() {
        return new EndangeredAnimals("Albino Giraffe");
    }


}