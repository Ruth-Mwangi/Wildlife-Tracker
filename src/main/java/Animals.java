
import org.sql2o.Connection;

import java.util.Objects;

public abstract class Animals {

    public int id;
    public String name;
    public String health;
    public String age;
    public String type;

    public static final String HEALTH_HEALTHY="healthy";
    public static final String HEALTH_ILL="ill";
    public static final String HEALTH_OKAY="okay";

    public static final String AGE_NEWBORN="newborn";
    public static final String AGE_YOUNG="young";
    public static final String AGE_ADULT="adult";


    public void save(){
        try (Connection con=DB.sql2o.open()){

            String sql ="INSERT INTO animals (name,health,age,type) VALUES (:name,:health,:age,:type)";

            this.id=(int) con.createQuery(sql,true)
                    .addParameter("name",this.name)
                    .addParameter("health",this.health)
                    .addParameter("age",this.age)
                    .addParameter("type",this.type)
                    .executeUpdate()
                    .getKey();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animals animals = (Animals) o;
        return name.equals(animals.name) &&
                health.equals(animals.health) &&
                age.equals(animals.age) &&
                type.equals(animals.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, health, age, type);
    }
}
