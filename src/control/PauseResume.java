package control;

import interfaz.InterfazSpaceInvaders;

public class PauseResume implements Command{

    private final InterfazSpaceInvaders interfaz;
    public PauseResume(InterfazSpaceInvaders interfaz) {
        this.interfaz = interfaz;
    }
    @Override
    public void execute() {
        if (interfaz.estaEnPausa()) {
            interfaz.modificarFuncionamiento(true);
            interfaz.cambiarPausa(false);
            interfaz.iniciarTodosLosHilos();
        } else {
            interfaz.modificarFuncionamiento(false);
            interfaz.cambiarPausa(true);
        }
    }
}