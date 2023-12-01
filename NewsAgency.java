package observerPattern;

import java.util.ArrayList;
import java.util.List;

public class NewsAgency implements NewsAgencySubject {
    private String newsHeadline;
    private List<Subscriber> subscriberList = new ArrayList<>();

    public List<Subscriber> getSubscriberList() {
        return subscriberList;
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        subscriberList.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        subscriberList.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {
        if (subscriberList != null && !subscriberList.isEmpty()) {
            for (Subscriber subscriber : subscriberList) {
                subscriber.update();
                if(newsHeadline != null){
                    System.out.println("[Latest news update: " + newsHeadline + "]\n");
                }
            }
        } else {
            System.out.println("No subscribers yet to notify.\n");
        }
    }

    @Override
    public void publishNews(String headline) {
        newsHeadline = headline;
        notifySubscribers();
    }
}
