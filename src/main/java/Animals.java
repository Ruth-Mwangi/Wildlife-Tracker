
import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;
import java.util.Objects;

public class Animals implements DatabaseManagement {

    public int id;
    public String name;
    public String type;
    private String health;
    private String age;
    public static final String ANIMAL_TYPE="normal";



    public Animals(String name,String type) {
        this.name = name;
        this.type=ANIMAL_TYPE;
        this.health="";
        this.age="";
    }

    public String getHealth() {
        return health;
    }

    public String getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public void save(){
        if(this.name.equals("")||this.type.equals("")||this.name.equals(null)||this.type.equals(null)){
            throw new IllegalArgumentException("Fields cannot be empty");
        }
            try (Connection con=DB.sql2o.open()){


                String sql ="INSERT INTO animals (name,type) VALUES (:name,:type)";

                this.id=(int) con.createQuery(sql,true)
                        .addParameter("name",this.name)
                        .addParameter("type",this.type)
                        .executeUpdate()
                        .getKey();
            }

    }

    public void update(int id,String type){
        try (Connection con=DB.sql2o.open()){
            String sql= "UPDATE animals SET type=:type WHERE id=:id";
            con.createQuery(sql)
                    .addParameter("type",this.type)
                    .addParameter("id",this.id)
                    .executeUpdate();

        }catch (Sql2oException ex){
            System.out.println(ex);
        }


    }

    public static Animals find(int id){
        try (Connection con=DB.sql2o.open()){
            String sql= "SELECT * FROM animals WHERE id=:id";
            Animals animal=  con.createQuery(sql)
                    .addParameter("id",id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(Animals.class);
            return animal;

        }

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animals animals = (Animals) o;
        return name.equals(animals.name) &&
                type.equals(animals.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,type);
    }
}
