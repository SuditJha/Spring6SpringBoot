import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.bean.BonusCard;
import com.bean.Customer;
import com.dao.CustomerDAO;

public class TestApplication {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

		CustomerDAO dao = new CustomerDAO();
		dao.setSession(session);

		Customer customer = new Customer();
		customer.setCustName("John Doe");
		customer.setCustAddress("123 Main St");

		BonusCard card = new BonusCard();
		card.setCardType("Gold");
		card.setPoints(100);

		customer.setCard(card);

		int customerId = dao.addCustomer(customer);
		System.out.println("Customer added with ID: " + customerId);

		session.close();
		sf.close();
	}
}