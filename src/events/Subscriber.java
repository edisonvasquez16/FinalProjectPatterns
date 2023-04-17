package events;

public interface Subscriber {
    public void update(Events eventType, Object data);
}
