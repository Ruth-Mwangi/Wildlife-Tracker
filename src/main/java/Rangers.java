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
}
