package com.mkr.oodpatterns.behavioral;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

// Observable
class User {
    private String status;
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void setStatus(String status) {
        support.firePropertyChange("status", this.status, status);
        this.status = status;
    }

    public void addPropertyChangeListeners(NewsFeed newsFeed) {
        support.addPropertyChangeListener(newsFeed);
    }
}

// Observer
class NewsFeed implements PropertyChangeListener {
    private List<String> statuses = new ArrayList<>();

    public void printStatuses() {
        statuses.forEach(System.out::println);
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        statuses.add(event.getNewValue().toString());
    }
}

public class ObserverDemo {
    public static void main(String[] args) {
        User user = new User();
        User user2 = new User();
        NewsFeed newsFeed = new NewsFeed();
        user.addPropertyChangeListeners(newsFeed);
        user2.addPropertyChangeListeners(newsFeed);

        user.setStatus("Going for a walk");
        user2.setStatus("Enjoying the beach");

        newsFeed.printStatuses();

    }
}
