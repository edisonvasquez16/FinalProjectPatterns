package interfaz.dialogs.builders;

import interfaz.InterfazSpaceInvaders;
import interfaz.dialogs.DialogBuilder;
import interfaz.dialogs.concrets.Instructions;

public class InstructionsDialogBuilder implements DialogBuilder {

    private Instructions instructions;
    @Override
    public void setLayout(InterfazSpaceInvaders interfaz) {
        instructions = new Instructions(interfaz);
    }

    @Override
    public void reset() {
        instructions = null;
    }

    @Override
    public void getResult() {
        instructions.mostrar();
    }
}