package Behavioral;
import java.util.ArrayList;
import java.util.List;

// Observer
interface Observer {
    void update(String post);
}

// Subject
interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Concrete Subject - SocialMediaAccount
class SocialMediaAccount implements Subject {
    private List<Observer> followers = new ArrayList<>();
    private String post;

    public void addPost(String post) {
        this.post = post;
        notifyObservers();  // Notify all followers about the new post
    }

    @Override
    public void registerObserver(Observer observer) {
        followers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        followers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : followers) {
            observer.update(post);
        }
    }
}

// Concrete Observer - Follower
class Follower implements Observer {
    private String followerName;

    public Follower(String followerName) {
        this.followerName = followerName;
    }

    @Override
    public void update(String post) {
        System.out.println(followerName + " received a new post: " + post);
    }
}

// Client
public class ObserverPattern {
    public static void main(String[] args) {
        // Create a social media account and followers (observers)
        SocialMediaAccount account = new SocialMediaAccount();
        Follower follower1 = new Follower("John");
        Follower follower2 = new Follower("Alice");

        // Register followers as observers
        account.registerObserver(follower1);
        account.registerObserver(follower2);

        // Add a new post (subject will notify observers)
        account.addPost("Hello world! This is my first post!");  // Followers are notified

        // Another post, followers will be notified again
        account.addPost("Just finished a new project! Check it out!");  // Followers are notified
    }
}

/*
In this code simulates a social media platform where users (followers) subscribe to a social
media account (subject) to receive notifications about new posts. When a new post is published,
all subscribed followers are notified automatically, demonstrating how multiple observers
can react to changes in the state of a subject. This pattern is useful in scenarios like
social media notifications or event-driven systems.
 */