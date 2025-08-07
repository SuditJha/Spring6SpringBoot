
import com.bean.Country;
import com.bean.State;
import com.dao.CountryDAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestApplication {

    public static void main(String[] args) {
        // Load Hibernate configuration
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        
        // Add annotated classes
        config.addAnnotatedClass(Country.class);
        config.addAnnotatedClass(State.class);

        // Create SessionFactory and Session
        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();

        // Create and set up the DAO
        CountryDAO dao = new CountryDAO();
        dao.setSession(session);

        // 1. Add a country with its states
        Country country = new Country();
        country.setCountryName("USA");
        country.setCapital("Washington, D.C.");
        country.setCurrency("USD");

        List<State> states = new ArrayList<>();
        State california = new State();
        california.setStateName("California");
        california.setLanguage("English");
        california.setPopulation(39538223);
        california.setCountry(country);
        states.add(california);

        State texas = new State();
        texas.setStateName("Texas");
        texas.setLanguage("English");
        texas.setPopulation(29145505);
        texas.setCountry(country);
        states.add(texas);

        country.setStatelist(states);
        dao.addCountry(country);
        System.out.println("Country 'USA' and its states added successfully.");

        // 2. Add a new state to the existing country
        State florida = new State();
        florida.setStateName("Florida");
        florida.setLanguage("English");
        florida.setPopulation(21538187);
        dao.addStatetoCountry("USA", florida);
        System.out.println("State 'Florida' added to 'USA'.");
        
        // 3. Find the state with the maximum population
        System.out.println("\nFinding state with the maximum population in 'USA':");
        List<State> maxPopStates = dao.stateWithMaxPopulation("USA");
        for (State state : maxPopStates) {
            System.out.println("State with max population: " + state.getStateName() + " (Population: " + state.getPopulation() + ")");
        }
        
        // 4. Remove the country
        System.out.println("\nRemoving country 'USA'...");
        dao.removeCountry("USA");
        System.out.println("Country 'USA' and its associated states have been removed.");


        // Close the session and factory
        session.close();
        sf.close();
    }
}