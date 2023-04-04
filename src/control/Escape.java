package control;

import interfaz.InterfazSpaceInvaders;

public class Escape implements Command{

    private final InterfazSpaceInvaders interfaz;
    public Escape(InterfazSpaceInvaders interfaz) {
        this.interfaz = interfaz;
    }
    @Override
    public void execute() {
            interfaz.cerrar();
    }
}
