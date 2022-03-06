import java.util.ArrayList;

public class Simulation {

    public static void main(String[] arts) {
        SuperMarket supern = new SuperMarket();
        Customer cust = new Customer(supern, 1);
        System.out.println("----------Start Simulation----------");
        System.out.println("The max products a customer can buy is " + cust.MAX_PRODUCTS);
        System.out.println("The minimum products a customer can buy is " + cust.MIN_PRODUCTS);
        System.out.println("The max shopping time a customer can have is " + cust.MAX_SHOP_TIME+ " seconds.");
        System.out.println("The minimum shopping time a customer can have is " + cust.MIN_SHOP_TIME +  " seconds.");
        supern.startSim();
        System.out.println("----------End Simulation----------");

    }


}
