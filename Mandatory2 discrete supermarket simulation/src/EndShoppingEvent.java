public class EndShoppingEvent extends Event {
    Customer customer;
    Checkout checkout;


    public EndShoppingEvent(Customer customer) {
        super(EventSim.getClock() + customer.shoppingDuration);
        this.customer = customer;
    }


    @Override
    public Event happen() {
        customer.leaveTime = customer.checkoutTime + customer.checkoutDuration;
        return null;
    }


    @Override
    public String toString() {
        return "EndShoppingEvent{" + getTime()  + customer.name
                + " The customer spends " + customer.shoppingDurationInMinutes + " minutes shopping" +
                 "'}'" +
                ". And is going to spend " +customer.queueWaitDuration+ " seconds in queue." +
                "The customer had " + customer.numProducts + " products in their shoppingcart";

    }

}
