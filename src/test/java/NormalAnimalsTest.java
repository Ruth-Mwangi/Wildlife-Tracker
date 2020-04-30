import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class NormalAnimalsTest {
    @Rule
    public DatabaseRule databaseRule=new DatabaseRule();

    @Test
    public void testInstanceOfNormalAnimalsClass_true(){
        NormalAnimals testAnimal= setUpNewAnimal();
        assertEquals(true,testAnimal instanceof NormalAnimals);
    }

    @Test
    public void allInstancesAreSaved(){
        NormalAnimals testAnimal=setUpNewAnimal();
        testAnimal.save();
        assertTrue(NormalAnimals.all().get(0).equals(testAnimal));
    }

    @Test
    public void ensureNameFieldCannotBeEmpty(){
        NormalAnimals testAnimal=new NormalAnimals("");
        try {
            testAnimal.save();
        }catch (IllegalArgumentException e){

        }
    }

    private NormalAnimals setUpNewAnimal() {
        return new NormalAnimals("Albino Giraffe");
    }

}