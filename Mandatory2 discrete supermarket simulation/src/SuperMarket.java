import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author evenal
 */
public class SuperMarket {

    public static final int NUM_CHECKOUTS = 4;
    public static final int NUM_CUSTOMERS = 5;

    Checkout[] checkouts;
    List<Customer> customers;
    List<Event> init;


    public SuperMarket() {
        checkouts = new Checkout[NUM_CHECKOUTS];
        for (int i = 0; i < NUM_CHECKOUTS; i++)
            checkouts[i] = new Checkout(this, i);
        customers = new ArrayList<>();
        init = new ArrayList<Event>();
        for (int i = 0; i < NUM_CUSTOMERS; i++) {
            Customer c = new Customer(this, i);
            init.add(new BeginShoppingEvent(c));
            customers.add(c);
        }
    }

    public void startSim() {
        EventSim sim = EventSim.getInstance();
        sim.setup(init);
        sim.run();
    }
}