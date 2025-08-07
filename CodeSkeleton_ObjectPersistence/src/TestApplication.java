
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bean.Customer;
import com.dao.CustomerDAO;

public class TestApplication {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        CustomerDAO dao = new CustomerDAO();
        dao.setSession(session);

        Customer customer = new Customer();
        customer.setCustomerName("John Doe");
        customer.setEmailId("john.doe@example.com");
        customer.setPhoneNo(1234567890L);

        int customerId = dao.createCustomer(customer);

        System.out.println("Successfully created customer with ID: " + customerId);

        session.close();
        factory.close();
    }
}