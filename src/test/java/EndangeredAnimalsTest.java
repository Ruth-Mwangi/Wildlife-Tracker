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
        assertTrue(EndangeredAnimals.all().get(0).getHealth().equals(testAnimal.getHealth()));
    }

    @Test
    public void findByIdReturnsCorrectInfo(){
        EndangeredAnimals testAnimal=setUpNewAnimal();
        testAnimal.save();
        System.out.println(testAnimal.getId());
        Animals foundAnimal= Animals.find(testAnimal.getId());
        assertTrue(foundAnimal.getHealth().equals(testAnimal.getHealth()));

    }
    @Test
    public void ensureNameFieldCannotBeEmpty(){
        EndangeredAnimals testAnimal=new EndangeredAnimals("","endangered","","");
        try {
            testAnimal.save();
        }catch (IllegalArgumentException e){

        }
    }

    private EndangeredAnimals setUpNewAnimal() {
        return new EndangeredAnimals("Albino Giraffe","endangered","healthy","young");
    }


}