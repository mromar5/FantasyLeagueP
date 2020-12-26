public class User implements IObserver {
  
        String firstName, lastName;
        String email;
        String password;
        String favouriteClub;
        
       User(String firstName_, String lastName_, String email_, String password_, String favouriteClub_){
           firstName = firstName_;
           lastName = lastName_;
           email = email_;
           password = password_;
           favouriteClub = favouriteClub_;
           
       
       }
       
       public String getFirstName(){
           return firstName;
       }
       
       public String getLastName(){
           return lastName;
       }
       public String getEmail(){
           return email;
       }
       public String getPassword(){
           return password;
       }
       public String getFavouriteClub(){
           return favouriteClub;
       }
       
       
    User() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
        
        
    @Override
    public void update() {
       
        //Implementation related to the Subject (League)
        
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
