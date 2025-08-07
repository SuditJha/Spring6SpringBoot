import com.bean.Address;
import com.bean.Customer;
import com.dao.CustomerDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestApplication {

    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        CustomerDAO dao = new CustomerDAO();
        dao.setSession(session);

        Customer customer = new Customer();
        customer.setCustName("John Doe");

        Address address = new Address();
        address.setDoorNo("123");
        address.setStreetName("Main Street");
        address.setDistrict("Anytown");
        address.setPincode("12345");

        int customerId = dao.addCustomer(customer, address);
        System.out.println("Customer added with ID: " + customerId);

        session.close();
        sessionFactory.close();
    }
}