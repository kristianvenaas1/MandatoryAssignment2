public class Simulation {
    public static void main(String[] args) {
        System.out.println("SUPER MARKET SIMULATOR:");
        Supermarket supermarket = new Supermarket("SuperMarket_1");
        supermarket.start();//Starts main thread: the supermarket
        /**********************************************************************/
        System.out.println("\t\t\tFinishing main thread...");
    }
}
