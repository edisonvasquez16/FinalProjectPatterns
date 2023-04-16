package interfaz.dialogs.builders;

import interfaz.InterfazSpaceInvaders;
import interfaz.dialogs.DialogBuilderWithLists;
import interfaz.dialogs.concrets.SelectPlayer;

import java.util.Collection;

public class SelectPlayerDialogBuilder implements DialogBuilderWithLists {

    private SelectPlayer selectPlayer;

    @Override
    public void setLayout() {
        selectPlayer = new SelectPlayer();
    }

    @Override
    public void reset() {
        selectPlayer = null;
    }

    @Override
    public void getResult() {
        selectPlayer.mostrar();
    }

    @Override
    public void changeList(Collection lista) {
        selectPlayer.cambiarListaJugadores(lista);
    }
}