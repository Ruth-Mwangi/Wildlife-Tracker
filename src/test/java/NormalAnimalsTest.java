//import org.junit.Rule;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class NormalAnimalsTest {
//    @Rule
//    public DatabaseRule databaseRule=new DatabaseRule();
//
//    @Test
//    public void testInstanceOfNormalAnimalsClass_true(){
//        NormalAnimals testAnimal= setUpNewAnimal();
//        assertEquals(true,testAnimal instanceof NormalAnimals);
//    }
//
//    @Test
//    public void allInstancesAreSaved(){
//        NormalAnimals testAnimal=setUpNewAnimal();
//        testAnimal.save();
//        assertTrue(NormalAnimals.all().get(0).equals(testAnimal));
//    }
//
//    @Test
//    public void ensureNameFieldCannotBeEmpty(){
//        NormalAnimals testAnimal=new NormalAnimals("");
//        try {
//            testAnimal.save();
//        }catch (IllegalArgumentException e){
//
//        }
//    }
//
//    @Test
//    public void checkIfUpdateIsSuccessful(){
//        NormalAnimals testAnimal=setUpNewAnimal();
//        NormalAnimals formerAnimal=setUpNewAnimal();
//        testAnimal.save();
//        testAnimal.update(testAnimal.getId(),"endangered");
//        EndangeredAnimals updatedAnimal= (EndangeredAnimals)EndangeredAnimals.findById(testAnimal.getId());
//        assertNotEquals(formerAnimal.getType(),updatedAnimal.getType());
//    }
//
//    private NormalAnimals setUpNewAnimal() {
//        return new NormalAnimals("Albino Giraffe");
//    }
//
//
//}