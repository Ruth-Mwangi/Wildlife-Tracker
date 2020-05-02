import org.junit.rules.ExternalResource;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class DatabaseRule extends ExternalResource {

    @Override
    public void before(){
        DB.sql2o=new Sql2o("jdbc:postgresql://tlafeaczpyudbw:cf9f6b81d98c18d5012a80842c01928b0331586444c6b9c08bc8504f67cbc678@ec2-18-209-187-54.compute-1.amazonaws.com:5432/d7m5mfo9caefm6", "tlafeaczpyudbw", "cf9f6b81d98c18d5012a80842c01928b0331586444c6b9c08bc8504f67cbc678");
    }

    @Override
    public void after(){
        try (Connection con = DB.sql2o.open()){

            String deleteAnimalQuery="DELETE FROM animals ";
            String deleteSightingsQuery="DELETE FROM sightings *";
            String deleteRangerQuery="DELETE FROM rangers";
            con.createQuery(deleteAnimalQuery).executeUpdate();
            con.createQuery(deleteSightingsQuery).executeUpdate();
            con.createQuery(deleteRangerQuery).executeUpdate();
            String deleteLocationQuery="DELETE FROM locations *";
            con.createQuery(deleteLocationQuery).executeUpdate();
        }
    }

}
