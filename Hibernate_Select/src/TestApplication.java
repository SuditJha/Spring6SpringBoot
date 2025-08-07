import com.bean.Customer;
import com.dao.CustomerDAO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestApplication {
    
    public static void main(String args[]){
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        CustomerDAO dao = new CustomerDAO();
        dao.setSession(session);

        List<Customer> customers = dao.viewCustomers();

        if (customers.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            System.out.println("Customer Details:");
            for (Customer customer : customers) {
                System.out.println("ID: " + customer.getCustomerId() + ", Name: " + customer.getCustomerName() +
                                   ", Email: " + customer.getEmailId() + ", Phone: " + customer.getPhoneNo());
            }
        }
        
        session.close();
        sessionFactory.close();
    }
}