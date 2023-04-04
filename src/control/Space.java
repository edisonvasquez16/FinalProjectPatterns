package control;

import interfaz.InterfazSpaceInvaders;
import mundo.NaveJugador;

public class Space implements Command{

    private final InterfazSpaceInvaders interfaz;
    private final NaveJugador navesita;
    public Space(InterfazSpaceInvaders interfaz, NaveJugador navesita) {
        this.interfaz = interfaz;
        this.navesita = navesita;
    }

    @Override
    public void execute() {
        if (navesita.getDisparoUno() == null) {
            navesita.disparar(interfaz.darPosActualJugador(), 410);
            interfaz.getThreadsFacade().startShootPlayerThread();
        }
    }
}