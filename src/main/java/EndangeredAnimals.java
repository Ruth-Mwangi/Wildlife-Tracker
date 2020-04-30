public class EndangeredAnimals extends Animals implements DatabaseManagement {

    public static final String ANIMAL_TYPE="endangered";
    public EndangeredAnimals(String name,String health,String age) {
        this.name=name;
        this.health=health;
        this.age=age;
        this.type=ANIMAL_TYPE;

    }
}
