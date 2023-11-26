
package Models;

import Database.DB_api;
import Database.dbFactory;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;



public class Users {
 //  public DB_api database ;
public String temp;
    private static Users usersInstance=null;
        private static Map<String,Persone> user;

        private Users() {
            user = new HashMap<>();
            readDBRecords();

        }
        public boolean editUser(String Oldemail,String NEWemail,String name) {
            DB_api database= getInstanceDB();
            Persone p =user.get(Oldemail);

            if (p != null) {
                user.remove(Oldemail);
p.setName(name);
p.setEmail(NEWemail);
                user.put(NEWemail,p);
                try {
                    database.updateUserInfo(Oldemail,p);
                } catch (SQLException e) {
                    return false;
                }
                return true;
            }
            return false;
        }
     private void readDBRecords(){
            DB_api database= getInstanceDB();
        user.putAll(database.dataReader());
     }


     public DB_api getInstanceDB(){
         DB_api database = null;
         try {
             database = dbFactory.getInstance("sql");
         } catch (SQLException e) {
             temp=e.toString();

         } catch (ClassNotFoundException e) {
             temp="ClassNotFoundException";

         }
         return database;
     }


   public static Users getUsersInstance(){

       if (usersInstance==null){
           usersInstance = new Users();
       }
       return usersInstance;
   }
public void AddUser(String name,String email){
    DB_api database= getInstanceDB();

            if(!user.containsKey(email)) {
                Persone persone= new Persone(name, email);
                getUser().putIfAbsent(persone.getEmail(), persone);
               try {
                   database.insertUser(persone);
               }catch (SQLException | ClassNotFoundException e) {
                   e.printStackTrace();
               }
            }

}

public boolean Remove(String email){
    DB_api database= getInstanceDB();
        getUser().remove(email);

    return database.deletePersoneByEmail(email);
}
public Persone getUser(String email){
    return user.get(email);
}
public boolean ContainsUser(String email){
    return user.containsKey(email);
}

public ArrayList getAllUsers(){
    ArrayList response = new ArrayList<>();
    user.keySet().forEach(keySet -> {
        response.add(user.get(keySet));
            });
    return response;
}
    public static Map<String,Persone> getUser() {
        return user;
    }



}



