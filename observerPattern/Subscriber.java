package observerPattern;

public class Subscriber implements SubscriberObserver {
    private String subscriberName;

    public Subscriber(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    public String getSubscriberName() {
        return subscriberName;
    }

    @Override
    public void update() {
        System.out.println("\nHi " + subscriberName + "! New breaking news is available today!");
    }
}
