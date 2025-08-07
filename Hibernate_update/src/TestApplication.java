import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bean.Customer;
import com.dao.CustomerDAO;

public class TestApplication {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Scanner sc = new Scanner(System.in);
        try {
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
            session = sessionFactory.openSession();

            CustomerDAO dao = new CustomerDAO();
            dao.setSession(session);

            System.out.println("Enter the customer id to update:");
            int id = sc.nextInt();
            System.out.println("Enter the new phone number:");
            long phone = sc.nextLong();

            Customer updatedCustomer = dao.updateCustomer(id, phone);

            if (updatedCustomer != null) {
                System.out.println("Customer details updated successfully");
                System.out.println("Updated details: " + updatedCustomer.getCustomerId() + " "
                        + updatedCustomer.getCustomerName() + " " + updatedCustomer.getPhoneNo());
            } else {
                System.out.println("Customer not found with the given id");
            }
        } finally {
            if (session != null) {
                session.close();
            }
            if (sessionFactory != null) {
                sessionFactory.close();
            }
            sc.close();
        }
    }
}