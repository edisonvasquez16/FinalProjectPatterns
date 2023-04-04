package interfaz.dialogs.builders;

import interfaz.InterfazSpaceInvaders;
import interfaz.dialogs.DialogBuilder;
import interfaz.dialogs.concrets.CreatePlayer;

public class CreatePlayerDialogBuilder implements DialogBuilder {

    private CreatePlayer createPlayer;
    @Override
    public void setLayout(InterfazSpaceInvaders interfaz) {
        createPlayer = new CreatePlayer(interfaz);
    }

    @Override
    public void reset() {
        createPlayer = null;
    }

    @Override
    public void getResult() {
        createPlayer.mostrar();
    }
}