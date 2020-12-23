
public class Player {
	String Name;
	String Nationality;
	String Club;
	int Position;
	double Price;
	boolean YellowCard=false;
	boolean RedCard=false;
	public Player() {}
	public Player(String Name,String Nationality,String Club,int Position,double Price)
	{
		this.Name=Name;
		this.Nationality=Nationality;
		this.Club=Club;
		this.Position=Position;
		this.Price=Price;
	}
}
