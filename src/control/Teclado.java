package control;

import interfaz.InterfazSpaceInvaders;
import mundo.NaveJugador;
import mundo.SpaceInvaders;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Manuel Alejandro Coral Lozano - Juan Sebasti�n Quintero Yoshioka
 * Proyecto final - Algoritmos y programaci�n II.
 */
public class Teclado implements KeyListener {

    // -----------------------------------------------------------------
    // ----------------------------Atributos----------------------------
    // -----------------------------------------------------------------

    // public Partida actu;

    private SpaceInvaders actu;

    public NaveJugador navesita;

    public InterfazSpaceInvaders interfaz;

    // -----------------------------------------------------------------
    // -----------------------------M�todos-----------------------------
    // -----------------------------------------------------------------

    public Teclado(InterfazSpaceInvaders principal, SpaceInvaders actual) {
        // TODO Auto-generated constructor stub
        interfaz = principal;
        actu = actual;
        navesita = actu.getJugadorActual();

    }

    public void keyPressed(KeyEvent e) {

        Invoker invoker = new Invoker();

        if (actu.getEnFuncionamiento()) {
            navesita = actu.getJugadorActual();
            switch (e.getKeyCode()) {
                case KeyEvent.VK_SPACE:
                    invoker.setCommand(new Space(interfaz, navesita));
                    break;
                case KeyEvent.VK_LEFT:
                    invoker.setCommand(new MoveLeft(interfaz, navesita));
                    break;
                case KeyEvent.VK_RIGHT:
                    invoker.setCommand(new MoveRight(interfaz, navesita));
                    break;
            }
        }

        switch (e.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                invoker.setCommand(new Escape(interfaz));
                break;
            case KeyEvent.VK_P:
                invoker.setCommand(new PauseResume(interfaz));
                break;
        }

        invoker.executeCommand();
    }

    /**
     *
     */
    public void keyReleased(KeyEvent e) {

    }

    /**
     *
     */
    public void keyTyped(KeyEvent e) {

    }

}
