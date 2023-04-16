package interfaz;

import control.Keyboard;
import excepciones.NicknameYaExisteException;
import excepciones.PartidaYaExisteException;
import hilos.ThreadsFacade;
import interfaz.builder.Director;
import interfaz.builder.PanelImagenInicialBuilder;
import interfaz.builder.PanelMenuBuilder;
import interfaz.builder.PanelNivelBuilder;
import interfaz.dialogs.DialogBuilder;
import interfaz.dialogs.builders.BestScoreDialogBuilder;
import interfaz.panelmenu.PanelImagenInicial;
import interfaz.panelmenu.PanelMenu;
import interfaz.panelmenu.PanelNivel;
import mundo.NaveJugador;
import mundo.partida.Partida;
import mundo.SpaceInvaders;
import events.Events;
import events.LogSubscriber;
import events.Publisher;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public final class InterfazSpaceInvaders extends JFrame {

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

    private static InterfazSpaceInvaders instance;

    private InterfazSpaceInvaders() {
        publisher = new Publisher();
    }

    /**
     * Init InterfazSpaceInvaders logic
     */
    public void init() {
        mundo = new SpaceInvaders(false);

        Director director = new Director();

        PanelMenuBuilder panelMenuBuilder = new PanelMenuBuilder();
        director.makePanelMenu(panelMenuBuilder);
        panelMenu = (PanelMenu) panelMenuBuilder.getResult();

        PanelNivelBuilder panelNivelBuilder = new PanelNivelBuilder(mundo.getPartidaActual(), mundo);
        director.makePanelNivel(panelNivelBuilder);
        panelNivel = (PanelNivel) panelNivelBuilder.getResult();

        PanelImagenInicialBuilder panelImagenInicialBuilder = new PanelImagenInicialBuilder();
        director.makePanelImagenInicial(panelImagenInicialBuilder);
        imagen = (PanelImagenInicial) panelImagenInicialBuilder.getResult();

        addKeyListener(imagen);

        contenedor = this.getContentPane();
        card.addLayoutComponent(imagen, "Inicio");
        card.addLayoutComponent(panelMenu, "Menu");
        card.addLayoutComponent(panelNivel, "Juego");

        contenedor.add(imagen);
        contenedor.add(panelMenu);
        contenedor.add(panelNivel);

        contenedor.setLayout(card);
        card.show(contenedor, "Inicio");

        Keyboard keyboard = new Keyboard(mundo);
        addKeyListener(keyboard);

        setSize(640, 480);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getRootPane().setBorder(BorderFactory.createLineBorder(Color.WHITE));
    }

    /**
     * Singleton pattern
     *
     * @return InterfazSpaceInvaders
     */
    public static InterfazSpaceInvaders getInstance() {
        if (instance == null) {
            instance = new InterfazSpaceInvaders();
        }

        return instance;
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
     * @param pause
     */
    public void cambiarPausa(boolean pause) {
        this.pausa = pause;

        publisher.notifySubscribers(Events.TOGGLE_PAUSE, pause);
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
     *
     */
    public void iniciarTodosLosHilos() {
        this.modificarFuncionamiento(true);

        threadsFacade = new ThreadsFacade(mundo);
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

        Partida partidaActual = mundo.getJugadorActual().getPartidaRaiz().partidas.createPartidasIterator().buscarPartida(nombre);
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
                mundo.deleteGame(true);
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
        try {
            mundo.deleteGame(false);
        } catch (IOException e) {
            e.printStackTrace();
        }

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
        dialog.setLayout();

        panelMenu.setDialogoMejoresPuntajes(dialog);
        panelMenu.getDialogoMejoresPuntajes().viewDialog();
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        InterfazSpaceInvaders gameWindow = InterfazSpaceInvaders.getInstance();
        gameWindow.init();

        for (Events event : Events.values()) {
            gameWindow.publisher.subscribe(event, new LogSubscriber("./data/log/log.txt"));
        }

        gameWindow.setVisible(true);
    }

}
