import org.sql2o.Connection;

import java.util.List;

public class EndangeredAnimals extends Animals implements DatabaseManagement {

    private String health;
    private String age;
    public static final String HEALTH_HEALTHY="healthy";
    public static final String HEALTH_ILL="ill";
    public static final String HEALTH_OKAY="okay";

    public static final String AGE_NEWBORN="newborn";
    public static final String AGE_YOUNG="young";
    public static final String AGE_ADULT="adult";

    public static final String ANIMAL_TYPE="endangered";
    public EndangeredAnimals(String name,String type,String health,String age) {
        super(name,type);
        this.type=type;
        this.health=health;
        this.age=age;

    }

    public String getHealth() {
        return health;
    }

    public String getAge() {
        return age;
    }

    @Override
    public void save() {
        if(this.name.equals("")||this.type.equals("")||this.health.equals("")||this.age.equals("")){
            throw new IllegalArgumentException("Fields cannot be empty");
        }
        try (Connection con=DB.sql2o.open()){


            String sql ="INSERT INTO animals (name,type,health,age) VALUES (:name,:type,:health,:age)";

            this.id=(int) con.createQuery(sql,true)
                    .addParameter("name",this.name)
                    .addParameter("type",this.type)
                    .addParameter("health",this.health)
                    .addParameter("age",this.age)
                    .executeUpdate()
                    .getKey();
        }

    }



}
