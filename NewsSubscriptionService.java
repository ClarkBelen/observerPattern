package observerPattern;

import java.util.Scanner;

public class NewsSubscriptionService {
    private static Subscriber findSubscriber(NewsAgency newsAgency, String username) {
        for (Subscriber subscriber : newsAgency.getSubscriberList()) {
            if (subscriber instanceof Subscriber && subscriber.getSubscriberName().equals(username)) {
                return subscriber;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        NewsAgency agency = new NewsAgency();

        System.out.println("Welcome to Real-time News Subscription Service System!");
        System.out.println("How can I help you today?");
        while(true){
            System.out.println("\nOPTIONS" +
                    "\n1. Register a user who subscribed" +
                    "\n2. Remove a user who unsubscribed" +
                    "\n3. Notify subscribers" +
                    "\n4. Publish new breaking news" +
                    "\n5. Exit");

            System.out.print("\nChoose from 1-5: ");
            Integer choice = input.nextInt();

            switch(choice){
                case 1:
                    System.out.print("Enter user/entity name: ");
                    input.nextLine();
                    String subscribeName = input.nextLine();

                    Subscriber newSubscriber = new Subscriber(subscribeName);
                    agency.subscribe(newSubscriber);
                    System.out.println(subscribeName + " subscribed successfully!");
                    break;
                case 2:
                    System.out.print("Enter user/entity name: ");
                    input.nextLine();
                    String unsubscribeName = input.nextLine();

                    Subscriber exSubscriber = findSubscriber(agency, unsubscribeName);
                    if(exSubscriber != null){
                        agency.unsubscribe(exSubscriber);
                        System.out.println(unsubscribeName + " unsubscribed successfully!");
                    } else{
                        System.out.println("User not found in the Subscribers list!");
                    }
                    break;
                case 3:
                    System.out.println("Notifying all subscribers...\n");
                    agency.notifySubscribers();
                    break;
                case 4:
                    System.out.print("Enter news headline/title: ");
                    input.nextLine();
                    String news = input.nextLine();

                    System.out.println("New breaking news has successfully published.");
                    System.out.println("Notifying all subscribers...\n");
                    agency.publishNews(news);
                    break;
                case 5:
                    System.out.println("Exiting the system... " +
                            "\nThank you for Real-time News Subscription Service System!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose from 1-5.");
            }
        }
    }
}
