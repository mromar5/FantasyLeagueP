public  class User{
  
        String firstName, lastName;
        String email;
        String password;
        String favouriteClub;
        protected String type;
       User(String firstName_, String lastName_, String email_, String password_, String favouriteClub_, String type){
           firstName = firstName_;
           lastName = lastName_;
           email = email_;
           password = password_;
           favouriteClub = favouriteClub_;
           this.type = type;
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
       public String getType(){
           return type;
       }
    User() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
