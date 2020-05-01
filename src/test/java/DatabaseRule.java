import org.junit.rules.ExternalResource;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class DatabaseRule extends ExternalResource {

    @Override
    public void before(){
        DB.sql2o=new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "wangui", "33234159");
    }

    @Override
    public void after(){
        try (Connection con = DB.sql2o.open()){

            String deleteAnimalQuery="DELETE FROM animals ";
            String deleteSightingsQuery="DELETE FROM sightings";
            con.createQuery(deleteAnimalQuery).executeUpdate();
            con.createQuery(deleteSightingsQuery).executeUpdate();
            String deleteRangerQuery="DELETE FROM rangers";
            con.createQuery(deleteRangerQuery).executeUpdate();
        }
    }

}
