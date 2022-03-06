public abstract class Event {
    int time;

    public Event(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public abstract Event happen();
}
