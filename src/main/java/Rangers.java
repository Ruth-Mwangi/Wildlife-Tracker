import org.sql2o.Connection;

public class Rangers {

    private int id;
    private String name;
    private String badge_number;
    private String phone_number;

    public Rangers(String name, String badge_number, String phone_number) {
        this.name = name;
        this.badge_number = badge_number;
        this.phone_number = phone_number;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBadge_number() {
        return badge_number;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void save(){
        try (Connection con=DB.sql2o.open()){
            String sql="INSERT INTO rangers (name,badge_number,phone_number) VALUES (:name,:badge_number,:phone_number)";
            if(name.equals("")||badge_number.equals("")||phone_number.equals("")){
                throw new IllegalArgumentException("All fields must be filled");
            }
            this.id=(int) con.createQuery(sql,true)
                    .addParameter("name",this.name)
                    .addParameter("badge_number",this.badge_number)
                    .addParameter("phone_number",this.phone_number)
                    .executeUpdate()
                    .getKey();
        }
    }
}
