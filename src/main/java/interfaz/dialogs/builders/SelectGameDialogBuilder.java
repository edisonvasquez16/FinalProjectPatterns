package interfaz.dialogs.builders;

import interfaz.InterfazSpaceInvaders;
import interfaz.dialogs.DialogBuilderWithLists;
import interfaz.dialogs.concrets.SelectGame;

import java.util.Collection;

public class SelectGameDialogBuilder implements DialogBuilderWithLists {

    private SelectGame selectGame;
    @Override
    public void setLayout() {
        selectGame = new SelectGame();
    }

    @Override
    public void reset() {
        selectGame = null;
    }

    @Override
    public void getResult() {
        selectGame.mostrar();
    }

    @Override
    public void changeList(Collection lista) {
        selectGame.cambiarListaPartidas(lista);
    }
}
