public class køArray {
    protected int maxStørrelse;
    protected long[] queArray;
    protected int køForan;
    protected int køBak;
    protected int nVarer;


    public køArray(int s) {
        maxStørrelse = s;
        queArray = new long[maxStørrelse];
        køForan = 0;
        køBak = -1;
        nVarer = 0;
    }

    public void insert(long j) {
        queArray[++køBak] = j;
        nVarer++;
    }

    public long remove() {
        long temp = queArray[køForan++];
        nVarer--;
        return temp;
    }

    /*Simply allows you to see the element in the front without removing it.*/
    public long peek()
    {
        return queArray[køForan];
    }
    /*Checks if there are no items left in the queue*/
    public boolean isEmpty()
    {
        return (nVarer==0);
    }
    /*Checks if there is no space available in the queue*/
    public boolean isFull()
    {
        return (nVarer==maxStørrelse);
    }
    /*Returns the number of elements in the queue*/
    public int size()
    {
        return nVarer;
    }

    /*Displays the queue from left to right: [front]...[2][3][4]....[rear]*/
    public void displayQueue()
    {
        int disp = køForan;
        if(!this.isEmpty())
            while(disp <= køBak)
                System.out.print("[" + this.queArray[disp++] + "]");
        else
            System.out.println("Empty queue");
        System.out.println("");
    }
}

