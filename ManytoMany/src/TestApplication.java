import java.util.Date;
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

		// Create and save a player and a match for testing
		Transaction tx = session.beginTransaction();

		Player player = new Player();
		player.setPlayerName("MS. Dhoni");
		player.setRunsScored(100);

		CricketMatch match = new CricketMatch();
		match.setMatchName("CSK vs MI");
		match.setMatchDate(new Date());

		session.save(player);
		session.save(match);
		tx.commit();


		CricketDAO dao = new CricketDAO();
		dao.setSession(session);
		dao.allocatePlayertoMatch(match.getMatchId(), player.getPlayerId());

		System.out.println("Player allocated to match successfully!");

		session.close();
		sf.close();
	}
}