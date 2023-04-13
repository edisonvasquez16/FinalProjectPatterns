package interfaz;

import control.Keyboard;
import excepciones.NicknameYaExisteException;
import excepciones.PartidaYaExisteException;
import hilos.ThreadsFacade;
import interfaz.dialogs.DialogBuilder;
import interfaz.dialogs.builders.BestScoreDialogBuilder;
import interfaz.panelmenu.PanelMenu;
import mundo.NaveJugador;
import mundo.Partida;
import mundo.SpaceInvaders;
import observer.Events;
import observer.Publisher;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class InterfazSpaceInvaders extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public static CardLayout card = new CardLayout();

    public static Container contenedor;

    private PanelMenu panelMenu;

    private PanelNivel panelNivel;

    private Publisher publisher;

    private SpaceInvaders mundo;
    private ThreadsFacade threadsFacade;
    private boolean pausa;

    public InterfazSpaceInvaders() {

        mundo = new SpaceInvaders(false);

        panelMenu = new PanelMenu(this);
        panelNivel = new PanelNivel(mundo.getPartidaActual(), mundo, this);

        PanelImagenInicial image = new PanelImagenInicial(this);
        addKeyListener(image);
        contenedor = this.getContentPane();
        card.addLayoutComponent(image, "Inicio");
        card.addLayoutComponent(panelMenu, "Menu");
        card.addLayoutComponent(panelNivel, "Juego");

        contenedor.add(image);
        contenedor.add(panelMenu);
        contenedor.add(panelNivel);

        contenedor.setLayout(card);
        card.show(contenedor, "Inicio");

        Keyboard keyboard = new Keyboard(this, mundo);
        addKeyListener(keyboard);

        setSize(640, 480);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getRootPane().setBorder(BorderFactory.createLineBorder(Color.WHITE));

        publisher = new Publisher();
    }

    /**
     * @param nombre
     */
    public void cambiarPanel(String nombre) {
        if (nombre.equals("Menu")) {
            card.show(contenedor, "Menu");
        } else if (nombre.equals("Juego")) {
            card.show(contenedor, "Juego");
        }
    }

    /**
     *
     */
    public void cerrar() {
        int input = JOptionPane.showConfirmDialog(null,
                "Desea salir del juego?", "Selecione una Opcion...",
                JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);

        if (input != 1) {
            try {
                mundo.serializarJugador();
            } catch (IOException e) {
                e.printStackTrace();
            }

            publisher.notifySubscribers(Events.CLOSED_GAME, "");

            System.exit(0);
        }
    }

    /**
     * @return
     */
    public boolean estaEnPausa() {
        return pausa;
    }

    /**
     * @return
     */
    public ThreadsFacade getThreadsFacade() {
        return this.threadsFacade;
    }

    /**
     * @param paus
     */
    public void cambiarPausa(boolean paus) {
        this.pausa = paus;

        publisher.notifySubscribers(Events.TOGGLE_PAUSE, paus);
    }

    /*
     *
     *
    public void startHiloEnemigo() {
        for (int i = 0; i < mundo.getPartidaActual().getEnemigos().length; i++) {
            for (int j = 0; j < mundo.getPartidaActual().getEnemigos()[0].length; j++) {
                if (mundo.getPartidaActual().getEnemigos()[i][j] != null) {
                    hilitoEnemigo = new HiloEnemigos(mundo.getPartidaActual().getEnemigos()[i][j], this);
                    hilitoEnemigo.start();
                }
            }
        }
    }

    /*
     *
     *
    public void startHiloAuxiliar() {
        hilitoAuxiliar = new HiloAuxiliarCreaDisparo(mundo.getPartidaActual(), this);
        hilitoAuxiliar.start();
    }

    /*
     *
     *
    public void startHiloAnimacion() {
        for (int i = 0; i < mundo.getPartidaActual().getEnemigos().length; i++) {
            for (int j = 0; j < mundo.getPartidaActual().getEnemigos()[0].length; j++) {
                if (mundo.getPartidaActual().getEnemigos()[i][j] != null) {
                    hilitoAnimacion = new HiloAnimacionEnemigos(mundo.getPartidaActual().getEnemigos()[i][j], this);
                    hilitoAnimacion.start();
                }
            }
        }
    }

    /*
     *
     *
    public void startHiloDisparoEnemigo() {
        hilitoEnemigoDisparo = new HiloDisparoEnemigos(mundo.getPartidaActual(), this, mundo);
        hilitoEnemigoDisparo.start();
    }

    /*
     *
     *
    public void startHiloJugador() {
        hilitoDisparo = new HiloDisparoJugador((NaveJugador) mundo.getJugadorActual(), this,
                mundo.getPartidaActual().getEnemigos(), mundo.getPartidaActual());
        hilitoDisparo.start();
    }

    /**
     * @return
     */
    public int darPosActualJugador() {
        return panelNivel.getPosJugadorActualX();
    }

    /**
     * @return
     */
    public boolean estaEnFuncionamiento() {
        return mundo.getEnFuncionamiento();
    }

    /**
     * @param salida
     */
    public void modificarFuncionamiento(boolean salida) {
        mundo.setEnFuncionamiento(salida);

        publisher.notifySubscribers(Events.TOGGLE_RUNNING, salida);
    }

    /**
     * @return
     */
    public PanelNivel getPanelNivel() {
        return panelNivel;
    }

    /**
     * @return
     */
    public NaveJugador getJugadorActual() {
        return mundo.getJugadorActual();
    }

    /**
     * @param panelNivel
     */
    public void setPanelNivel(PanelNivel panelNivel) {
        this.panelNivel = panelNivel;
    }

    /**
     * @return
     */
    public PanelMenu getPanelMenu() {
        return panelMenu;
    }

    /**
     * @param panelMenu
     */
    public void setPanelMenu(PanelMenu panelMenu) {
        this.panelMenu = panelMenu;
    }

    /**
     *
     */
    public void iniciarTodosLosHilos() {
        this.modificarFuncionamiento(true);

        threadsFacade = new ThreadsFacade(this, mundo);
        threadsFacade.startThreads();

        publisher.notifySubscribers(Events.START_THREADS, "");
    }

    /**
     * @param nombre
     */
    public void reqCrearPartida(String nombre) {
        try {
            mundo.crearPartida(nombre);
            mundo.getPartidaActual().inicializarPartida();
            actualizarPartidas();
            actualizarPartidaActual(nombre);
            panelNivel.setPartida(mundo.getPartidaActual());
            mundo.iniciarPartida();
            cambiarPanel("Juego");

            publisher.notifySubscribers(Events.NEW_GAME, nombre);
        } catch (PartidaYaExisteException | IOException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error al crear la partida", JOptionPane.ERROR_MESSAGE);

            publisher.notifySubscribers(Events.EXISTING_GAME, nombre);
        }
    }

    /**
     * @param nombre
     * @param nickname
     */
    public void reqAgregarJugador(String nombre, String nickname) {
        try {
            mundo.agregarJugador(nombre, nickname);
            panelMenu.repaint();
            actualizarJugadores();
            actualizarJugadorActual(nickname);

            publisher.notifySubscribers(Events.ADDED_PLAYER, nickname);
        } catch (NicknameYaExisteException | IOException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error al agregar el jugador",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * @param nickname
     */
    public void actualizarJugadorActual(String nickname) {
        if (!nickname.equals("")) {
            NaveJugador actual = mundo.buscarJugador(nickname);
            mundo.setJugadorActual(actual);
            panelMenu.repaint();
        } else
            JOptionPane.showMessageDialog(this, "Por favor cree algun jugador", "No existen jugadores",
                    JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * @param nombre
     */
    public void actualizarPartidaActual(String nombre) {

        Partida partidaActual = mundo.getJugadorActual().getPartidaRaiz().buscarPartida(nombre);
        mundo.setPartidaActual(partidaActual);
        panelNivel.setPartida(partidaActual);
        iniciarTodosLosHilos();
    }

    /**
     *
     */
    public void actualizarJugadores() {
        ArrayList<NaveJugador> jugadores = mundo.getJugadores();
        if (jugadores == null)
            jugadores = new ArrayList<>();
        panelMenu.getDialogoSeleccionarJugador().changeList(jugadores);
    }

    /**
     *
     */
    public void actualizarPartidas() {
        ArrayList<Partida> partidas = mundo.darPartidasJugador();
        if (partidas.size() == 0) {
            partidas = new ArrayList<Partida>();
        }

        panelMenu.getDialogoSeleccionarPartida().changeList(partidas);
    }

    /**
     *
     */
    public void nivelCompleto() {
        try {
            if (mundo.getPartidaActual().nivelCompleto()) {

                JOptionPane.showConfirmDialog(null,
                        "NIVEL COMPLETADO!!!", "Informacion...",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);

                iniciarTodosLosHilos();

                publisher.notifySubscribers(Events.COMPLETED_LEVEL, "");
            } else {
                panelMenu.repaint();
                mundo.eliminarPartida(true);
                actualizarPartidas();
                cambiarPanel("Menu");
                panelMenu.repaint();

                publisher.notifySubscribers(Events.COMPLETED_GAME, true);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    public void perder() {
        panelMenu.repaint();

        publisher.notifySubscribers(Events.LOST_GAME, false);

        actualizarPartidas();
        cambiarPanel("Menu");
        panelMenu.repaint();
    }

    /**
     *
     */
    public void ordenarJugadores() {
        ArrayList<NaveJugador> jugadores = mundo.ordenarPorNickname();
        if (jugadores == null)
            jugadores = new ArrayList<>();
        panelMenu.getDialogoSeleccionarJugador().changeList(jugadores);
    }

    /**
     * @param nickname
     */
    public void loginRapido(String nickname) {
        if (!mundo.busquedaRapida(nickname)) {
            JOptionPane.showMessageDialog(null, "El jugador con el nickname " + nickname + " no existe",
                    "Jugador no encontrado", JOptionPane.ERROR_MESSAGE);
        }
        panelMenu.repaint();
    }

    /**
     *
     */
    public void mejoresPuntajes() {
        DialogBuilder dialog = new BestScoreDialogBuilder(mundo.mejoresPuntajes());
        dialog.setLayout(this);
        panelMenu.setDialogoMejoresPuntajes(dialog);
        panelMenu.getDialogoMejoresPuntajes().viewDialog();
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        InterfazSpaceInvaders ventana = new InterfazSpaceInvaders();
        ventana.setVisible(true);
    }

}
