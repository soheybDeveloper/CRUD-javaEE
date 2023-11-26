package Database;

import Models.Persone;

import java.sql.SQLException;
import java.util.Map;

public interface DB_api {
//    public void connect() throws SQLException, ClassNotFoundException;
     boolean insertUser(Persone persone) throws SQLException, ClassNotFoundException;
     Map dataReader();
     boolean deletePersoneByEmail(String email);
     boolean updateUserInfo(String oldemail, Persone p) throws SQLException;
}
