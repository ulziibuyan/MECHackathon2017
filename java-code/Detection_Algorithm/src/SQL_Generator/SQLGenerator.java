
import java.util.*;

public class SQLGenerator {
    static class Entity {
        public String name;
        public String tag;
        public Entity(String name, String tag) {
            this.name = name;
            this.tag = tag;
        }
    }
    public String generateFrom(Entity[] entities) {
        StringBuilder sql = new StringBuilder();
        sql.append("select 1 from <table> where ");
        for (int i = 0; i < entities.length; i++) {
            sql.append(entities[i].name);
            if (entities[i].tag.matches("more"))
                sql.append(" < ");
            else if (entities[i].tag.matches("less"))
                sql.append(" > ");
            else if (entities[i].tag.matches("equal"))
                sql.append(" = ");
        }
        return sql.toString();
    }
    public String generateFrom(ArrayList<String> entities) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sql = new StringBuilder();
        sql.append("Select 1 from entity_Table where ");
        for (int i = 0; i < entities.size(); i++)
            sql.append("variable_" + alphabet.charAt(i) + " = " + entities.get(i) + " and ");
        return sql.toString();
    }
    public static void main(String[] args) {
        Entity[] entitiesTest1 = new Entity[2];
        entitiesTest1[0] = new Entity("car_age_days", "more");
        entitiesTest1[1] = new Entity("7", "");
        System.out.println(new SQLGenerator().generateFrom(entitiesTest1));

        Entity[] entitiesTest2 = new Entity[2];
        entitiesTest2[0] = new Entity("car_age_days", "more");
        entitiesTest2[1] = new Entity("7", "");
        System.out.println(new SQLGenerator().generateFrom(entitiesTest2));

        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("vehicleage");
        arrayList.add("7");
        System.out.println(new SQLGenerator().generateFrom(arrayList));
    }
}
