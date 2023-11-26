
package Database;
import Models.Persone;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.EntityTransaction;
//import jakarta.persistence.Persistence;
//import jakarta.persistence.Query;
public class DBuser implements DB_api {
    private Connection conn = null;
public DBuser() throws SQLException, ClassNotFoundException {
    conn=ConnectionMySql.getConnection();
}


    @Override
 public boolean insertUser(Persone persone){
boolean inserted = false;
        ResultSet resultSet;
     PreparedStatement preparedStatement;

//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
//        EntityManager em = emf.createEntityManager();
//
//        EntityTransaction transac = em.getTransaction();


        try {
//            transac.begin();
            String query;

            query="INSERT INTO `people` (`email`, `name`) VALUES ('"+persone.getEmail()+"','"+persone.getName()+"')";

            preparedStatement= conn.prepareStatement(query);
            inserted=preparedStatement.execute();
            inserted = true;
            conn.commit();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
            inserted=false;
        }
return inserted;

}

public ResultSet projector() throws SQLException{
    Statement statement;
    ResultSet resultSet;
    statement= conn.createStatement();
    resultSet =  statement.executeQuery("select email,name From people;");
    return resultSet;
}
    @Override
public Map dataReader(){
    Map<String,Persone>peopleMap=new HashMap<>();
    ResultSet resultSet;
    try {
        resultSet =projector();
        while(resultSet.next()){

            String email=    resultSet.getString("email");
            String name = resultSet.getString("name");
                    Persone persone=new Persone(name,email);
            peopleMap.put(email,persone);
        }
    }catch (SQLException e){

    }
    return peopleMap;
}
    @Override
public boolean deletePersoneByEmail(String email)  {

//        EntityManagerFactory emf = Persistence
//                .createEntityManagerFactory("pu");
//        EntityManager em = emf.createEntityManager();
//
//        EntityTransaction transac = em.getTransaction();
//        try {
//            transac.begin();
//
//            Persone persone = em.find(Persone.class, email);
//
//                em.remove(persone);
//
//
//            transac.commit();
//            return true;
//        }catch (Exception e){
//        em.close();
//        emf.close();
//        return false;
//        }
//    }


    ResultSet resultSet;
    PreparedStatement preparedStatement;


    try {
        String query;

        query="DELETE FROM `people` WHERE `email` = '"+email+"'";
        preparedStatement= conn.prepareStatement(query);
        preparedStatement.execute();
        conn.commit();
        conn.close();
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }


}

    @Override
    public boolean updateUserInfo(String oldemail, Persone p) throws SQLException {

        ResultSet resultSet;
        PreparedStatement preparedStatement;
        boolean success=false;


        try {
            String query;
            query ="UPDATE `people` SET `email` = '"+p.getEmail()+"', `name` = '"+p.getName()+"' WHERE `people`.`email` = '"+oldemail+"'";
            preparedStatement= conn.prepareStatement(query);
            preparedStatement.execute();
            conn.commit();
            conn.close();
            success=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }

}
