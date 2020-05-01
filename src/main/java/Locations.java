import org.sql2o.Connection;

public class Locations {

    private int id;
    private  String name;

    public Locations(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void save(){
        try (Connection con=DB.sql2o.open()){
            String sql="INSERT INTO locations (name) VALUES (:name)";
            if(name.equals("")){
                throw new IllegalArgumentException("All fields must be filled");
            }
            this.id=(int) con.createQuery(sql,true)
                    .addParameter("name",this.name)
                    .executeUpdate()
                    .getKey();
        }
    }
}
