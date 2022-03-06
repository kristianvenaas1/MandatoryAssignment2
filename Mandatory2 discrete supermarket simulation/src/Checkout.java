public class Checkout {
    // amount of time per prouct (to scan barcode)
    public static final int PROD_DURATION = 2;
    // amount of time to pay
    public static final int PAY_DURATION = 10;
    //total time for checkout = PAY_DURATION + PROD_DURATION*customer.numProd

    SuperMarket shop;
    String name;


    public Checkout(SuperMarket shop, int i) {
        this.shop = shop;
        this.name = "Checkout " + i;
    }







}
