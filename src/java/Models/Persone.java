
package Models;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Table;
//import jakarta.persistence.Id;

//@Entity
//@Table(name ="people")
public class Persone {
   private long ID;

//   @Column(name="name")
   private String name;
//   @Id
//   @Column(name= "email")
   private String email;
   private static long idgenerater=0;
   public Persone(){
     this("","");
   }
   public Persone(String name,String email){
         ID=idgenerater++;
       this.name=name;
       this.email=email;
   }

    /**
     * @return the ID
     */
    public long getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(long ID) {
        this.ID = ID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
//    @Id
    public String getEmail() {
        return email;
    }

  
    public void setEmail(String email) {
        this.email = email;
    }
  
  
   @Override
  public String toString(){
      return "Persone: name : "+getName()+" email: "+getEmail();
  }
 
}
