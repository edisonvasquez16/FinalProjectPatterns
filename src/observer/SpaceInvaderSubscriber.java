package observer;

import java.io.IOException;
import mundo.SpaceInvaders;

public class SpaceInvaderSubscriber implements Subscriber {

    private SpaceInvaders spaceInvaders;

    public SpaceInvaderSubscriber() {
        spaceInvaders = new SpaceInvaders(false);
    }

    public void update(Object data) {
        try {
            spaceInvaders.eliminarPartida((Boolean) data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
