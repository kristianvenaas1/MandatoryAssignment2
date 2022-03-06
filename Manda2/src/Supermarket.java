
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Supermarket extends Thread {

    private final int Ncashiers = 8; // number of cashiers (and queues)
    private final int custPerLine = 20; // size of each queue (customers per line)
    private final int hrs = 15; //hours that the supermarket remains open
    private final int totalTimeInSecs = hrs*1000*60*60; //time in seconds that the supermarket remains open
    private long clock;  //variable to count elapsed time.
    // To use the java.util.Queue interface replace with: private final Queue<Integer>[] lines; (B)/>/>/>/>
    private final køArray[] lines; // where the customers are going to queue.
    private final Thread[] checkers; // an array of threads that represents the cashiers attending to the customers.
    private boolean closing; //flag to close the supermarket
    private final long NewCustTimeMax = 10; //Max time (in seconds) before a new cutomer queues.
    private final long NewCustTimeMin = 5; //Min time (in seconds) before a new cutomer queues.
    private final long groceryPass = 1000; // average time that takes a cashier passing each item (1sec).
    private final long maxGroceries = 200; // max amount of groceries a customer takes
    private final long otherTransac = 1000*30; //an average of half a minute in other transactions such as withdraws.

    public Supermarket(String string) {
        super(string);
        clock = 0;
        this.lines = new køArray[Ncashiers];
        closing = false;
        this.checkers = new Thread[Ncashiers];
    }

    @Override
    public void run() {
        System.out.println("\t\t\tStarting supermarket thread...");
        for (int i = 0; i < Ncashiers; i++)
        {
            final int index;

            index = i;//this is possible because we only initilize index with one value for each iteration.
            // To use the java.util.Queue interface replace with:  lines[i] = new LinkedList<>(); (C)
            lines[i] = new køArray(this.custPerLine); //queues
            checkers[i] = new Thread() //cashiers
            {
                @Override
                public void run() {
                    System.out.println("\t\t\tStarting cashier " + (index+1) + " thread...");
                    while(!closing)
                    {
                        if( !lines[index].isEmpty() )
                            try {
                                /*The thread waits as it simulates the cashier chargin the current customer, then it removes it.*/
                                Thread.sleep(lines[index].peek() * groceryPass + otherTransac );
                                System.out.println("A customer just left cashier " + (index+1) + ", with " + lines[index].remove() + "items." );

                            } catch (InterruptedException ex) {
                                System.out.println("For some reason cashier " + (index+1) + "couldn't charge,"
                                        + "hints about the reason: \n" + ex);
                            }
                        else
                            try
                            {
                                /**The cashier waits for the arrival of a new customer if their queue is empty **/
                                Thread.sleep(NewCustTimeMin*1000);
                            } catch (InterruptedException ex) {
                                System.out.println("For some reason cashier " + (index+1) + "couldn't wait for a new customer,"
                                        + "hints about the reason: \n" + ex);
                            }
                    }
                }

            };

            checkers[i].start();
        }
        int best;
        long groseries;

        while(!closing)
        {
            best = this.pickTheBest();
            if( !this.lines[best].isFull() )
                try
                {
                    /**There is a time from NewCustTimeMin to NewCustTimeMax (in seconds) before a new customer queues**/
                    long timePassed = (long)Math.random()*NewCustTimeMax*1000+NewCustTimeMin*1000;
                    Thread.sleep(timePassed);
                    clock+=timePassed;//counting the time that's passed
                    groseries = (long)(Math.random()*this.maxGroceries) + 1 ;//Queuing customers with random amount of groceries
                    this.lines[best].insert( groseries );
                    System.out.println("A customer just queued at cashier " + (best+1) + ", with " + groseries + "items.");//displays where the last customer has queued

                    //displays all the cashiers
                    for (int i = 0; i < this.Ncashiers; i++)
                        if(!lines[i].isEmpty())
                        {
                            System.out.print((i+1)+". ");
                            /*Line to modify if you want to use the java.util.Queue interface*/
                            this.lines[i].displayQueue();/* To use the java.util.Queue interface replace with: System.out.println( Arrays.toString( this.lines[i].toArray() ) );(D)*/
                        }
                    System.out.println("");

                    closing = clock>totalTimeInSecs; //checks if it's time to close the supermarket
                } catch (InterruptedException ex) {
                    System.out.println("For some reason cashier " + (best+1) + "couldn't wait for a new customer,"
                            + "hints about the reason: \n" + ex);
                }
        }
    }

    /*With this function customer decides which line is the best to queuing by picking
        the one with the lowest amount of customers queued*/
    private int pickTheBest()
    {
        int temp = this.lines[0].size(), pos = 0;

        for (int i = 0; i < this.lines.length; i++)
            if(this.lines[i].size() < temp)
            {
                temp = this.lines[i].size();
                pos = i;
            }
        return pos;
    }
}

