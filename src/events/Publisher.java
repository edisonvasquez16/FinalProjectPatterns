package events;

import java.util.*;

public class Publisher {
    private Map<Events, List<Subscriber>> subscribers = new HashMap<>();

    public Publisher () {
        for (Events event: Events.values()) {
            this.subscribers.put(event, new ArrayList<>());
        }
    }

    public void subscribe(Events eventType, Subscriber subscriber) {
        List<Subscriber> eventSubscribers = subscribers.get(eventType);
        eventSubscribers.add(subscriber);
    }

    public void unsubscribe(Events eventType, EventListener subscriber) {
        List<Subscriber> eventSubscribers = subscribers.get(eventType);
        eventSubscribers.remove(subscriber);
    }

    public void notifySubscribers(Events eventType, Object data) {
        List<Subscriber> eventSubscribers = subscribers.get(eventType);

        for (Subscriber eventSubscriber : eventSubscribers) {
            eventSubscriber.update(eventType, data);
        }
    }
}
