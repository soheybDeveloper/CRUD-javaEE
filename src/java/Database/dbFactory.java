package Database;

import java.sql.SQLException;
import java.util.Locale;

public class dbFactory {

    private dbFactory(){
    }

    public static DB_api getInstance(String type) throws SQLException, ClassNotFoundException {
       if (type == null) throw new ClassNotFoundException();
        switch (type.toLowerCase(Locale.ROOT)){
            case "sql": return new DBuser();

            default: return null;
        }

    }
}
