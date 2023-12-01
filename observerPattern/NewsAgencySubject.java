package observerPattern;

public interface NewsAgencySubject {
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);

    void notifySubscribers();

    void publishNews(String headline);
}
