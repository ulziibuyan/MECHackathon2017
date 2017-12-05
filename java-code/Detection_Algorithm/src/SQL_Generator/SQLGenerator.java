
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
    public static void main(String[] args) {
        Entity[] entities_test1 = new Entity[2];
        entities[0] = new Entity("car_age_days", "more");
        entities[1] = new Entity("7", "");
        System.out.println(new SQLGenerator().generateFrom(entities_test1));

        Entity[] entities_test2 = new Entity[2];
        entities[0] = new Entity("car_age_days", "more");
        entities[1] = new Entity("7", "");
        System.out.println(new SQLGenerator().generateFrom(entities_test1));        
    }
}
