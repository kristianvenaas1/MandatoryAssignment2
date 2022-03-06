

public class Customer {
    // customer will pick a random number of products between these two values
    public static final int MAX_PRODUCTS = 35;
    public static final int MIN_PRODUCTS = 1;

    // customer will spend ranom amount of time between these values before
    // going to check out
    public static final int MAX_SHOP_TIME = 1800;// MAX SHOPPING TIME ER 1800 SEKUNDER 1800 sek = 30 min
    public static final int MIN_SHOP_TIME = 60;


    public static final int PROD_DURATION = 8;
    // amount of time to pay
    public static final int PAY_DURATION = 10;

    SuperMarket shop;
    String name;

    int beginShoppingTime;
    int shoppingDuration;
    int numProducts;
    int endShoppingTime;
    int queueWaitDuration;
    int checkoutTime;
    int checkoutDuration;
    int leaveTime;
    int shoppingDurationInMinutes;


    public Customer(SuperMarket shop, int i) {
        this.shop = shop;
        name = " -Customer (" + i +")-";
        beginShoppingTime = i;
        numProducts = EventSim.nextInt(MIN_PRODUCTS, MAX_PRODUCTS);
        shoppingDuration = EventSim.nextInt(MIN_SHOP_TIME, MAX_SHOP_TIME);
        shoppingDurationInMinutes = shoppingDuration/60;
        endShoppingTime = beginShoppingTime + shoppingDuration;
        queueWaitDuration = PAY_DURATION + PROD_DURATION*numProducts;
    }

}