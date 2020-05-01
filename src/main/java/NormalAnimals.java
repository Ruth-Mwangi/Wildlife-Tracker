//import org.sql2o.Connection;
//
//import java.util.List;
//
//public class NormalAnimals extends Animals implements DatabaseManagement {
//
//    public static final String ANIMAL_TYPE="normal";
//    public NormalAnimals(String name) {
//        this.name=name;
//        this.type=ANIMAL_TYPE;
//
//    }
//
////    public NormalAnimals findById(int id){
////        try (Connection con=DB.sql2o.open()){
////            String sql= "SELECT * animals WHERE id=:id";
////            con.createQuery(sql)
////                    .throwOnMappingFailure(false)
////                    .executeAndFetch(NormalAnimals.class);
////        }
////
////    }
//
//
//
//
//    public static List<NormalAnimals> all(){
//        try (Connection con=DB.sql2o.open()) {
//            String sql ="SELECT * FROM animals WHERE type='normal'";
//            return con.createQuery(sql)
//                    .throwOnMappingFailure(false)
//                    .executeAndFetch(NormalAnimals.class);
//
//        }
//    }
//}
