import java.util.ArrayList;

public class LimitedPlayers extends ArrayList<Player> {
	  @Override
	  public boolean add(Player p) {
	      if (this.size() < 15) {
	          return super.add(p);
	      }
	      return false;
	  }
	}
