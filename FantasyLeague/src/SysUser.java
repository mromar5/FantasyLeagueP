
public class SysUser extends User{
    PlayerController pc;
    EventPerformer eventPerformer;
    SysUser(){
        pc = new PlayerController();
        eventPerformer = new EventPerformer();
    }

    SysUser(String firstName, String lastName, String email, String password, String favouriteClub, String type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.favouriteClub = favouriteClub;
        this.type = type;
        pc=new PlayerController();
        eventPerformer=new EventPerformer();
    }
    
}
