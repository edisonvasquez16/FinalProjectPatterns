package control;

import interfaz.InterfazSpaceInvaders;
import mundo.NaveJugador;

public class MoveRight implements Command{

    private final InterfazSpaceInvaders interfaz;
    private final NaveJugador navesita;
    public MoveRight(InterfazSpaceInvaders interfaz, NaveJugador navesita) {
        this.interfaz = interfaz;
        this.navesita = navesita;
    }
    @Override
    public void execute() {
        navesita.mover(1);
        interfaz.getPanelNivel().updateUI();
    }
}
