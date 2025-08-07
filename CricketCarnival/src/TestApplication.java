import java.util.Date;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.bean.CricketMatch;
import com.bean.Player;
import com.dao.CricketDAO;

public class TestApplication {
	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

		// --- Begin Setup: Create and save sample data ---
		Transaction tx = session.beginTransaction();

		Player p1 = new Player();
		p1.setPlayerName("Virat Kohli");
		p1.setRunsScored(120);

		Player p2 = new Player();
		p2.setPlayerName("Rohit Sharma");
		p2.setRunsScored(85);

		CricketMatch match1 = new CricketMatch();
		match1.setMatchName("India vs Australia");
		match1.setMatchDate(new Date());
		match1.getPlayers().add(p1);
		match1.getPlayers().add(p2);

		session.save(match1);
		tx.commit();
		// --- End Setup ---


		CricketDAO dao = new CricketDAO();
		dao.setSession(session);

		// Test the viewMatchwithPlayerDetails method
		CricketMatch retrievedMatch = dao.viewMatchwithPlayerDetails(match1.getMatchId());

		if (retrievedMatch != null) {
			System.out.println("Match Details:");
			System.out.println("Match ID: " + retrievedMatch.getMatchId());
			System.out.println("Match Name: " + retrievedMatch.getMatchName());
			System.out.println("Match Date: " + retrievedMatch.getMatchDate());
			System.out.println("\nPlayers in this match:");

			Set<Player> players = retrievedMatch.getPlayers();
			for (Player player : players) {
				System.out.println("  Player ID: " + player.getPlayerId() + ", Name: " + player.getPlayerName() + ", Runs Scored: " + player.getRunsScored());
			}
		} else {
			System.out.println("Match not found.");
		}

		session.close();
		sf.close();
	}
}