package interfaz.dialogs.builders;

import interfaz.InterfazSpaceInvaders;
import interfaz.dialogs.DialogBuilder;
import interfaz.dialogs.concrets.CreatePlayer;

public class CreatePlayerDialogBuilder implements DialogBuilder {

    private CreatePlayer createPlayer;
    @Override
    public void setLayout() {
        createPlayer = new CreatePlayer();
    }

    @Override
    public void reset() {
        createPlayer = null;
    }

    @Override
    public void viewDialog() {
        createPlayer.mostrar();
    }
}