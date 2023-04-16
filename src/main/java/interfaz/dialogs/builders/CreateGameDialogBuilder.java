package interfaz.dialogs.builders;

import interfaz.InterfazSpaceInvaders;
import interfaz.dialogs.DialogBuilder;
import interfaz.dialogs.concrets.CreateGame;

public class CreateGameDialogBuilder implements DialogBuilder {

    private CreateGame createGame;
    @Override
    public void setLayout() {
        createGame = new CreateGame();
    }

    @Override
    public void reset() {
        createGame = null;
    }

    @Override
    public void viewDialog() {
        createGame.mostrar();
    }
}