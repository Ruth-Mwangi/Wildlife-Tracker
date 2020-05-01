import org.sql2o.Connection;

import java.util.List;

public class EndangeredAnimals extends Animals implements DatabaseManagement {

    public static final String ANIMAL_TYPE="endangered";
    public EndangeredAnimals(String name) {

        this.name=name;
        this.type=ANIMAL_TYPE;

    }



    public static List<EndangeredAnimals> all(){
        try (Connection con=DB.sql2o.open()) {
            String sql ="SELECT * FROM animals WHERE type='endangered'";
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(EndangeredAnimals.class);

        }
    }
}
