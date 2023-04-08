package interfaz.builder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import interfaz.InterfazSpaceInvaders;
import interfaz.PanelMenu;

public class PanelMenuBuilder implements Builder {

    private PanelMenu panelMenu;

    public PanelMenuBuilder() {
        this.panelMenu = new PanelMenu(new InterfazSpaceInvaders());
    }

    /**
     * Reset the object
     */
    public void reset() {
        this.panelMenu = new PanelMenu(new InterfazSpaceInvaders());
    }

    /**
     * Set a Label for the Panel
     */
    public void setLabel(JLabel label) {
        this.panelMenu.add(label);
    }

    /**
     * Set Layout Object
     */
    public void setLayout(BorderLayout layout) {
        this.panelMenu.setLayout(layout);

    }

    /**
     * Set Dimension Object
     */
    public void setPreferredSize(Dimension dimension) {
        this.panelMenu.setPreferredSize(dimension);
    }

    /**
     * Set Opaque Object
     */
    public void setOpaque(boolean isOpaque) {
        this.panelMenu.setOpaque(isOpaque);
    }

    /**
     * Set Background Object
     */
    public void setBackground(Color background) {
        this.panelMenu.setBackground(background);
    }

    /**
     * Set Panel Object
     */
    public void setPanel(JPanel panel, Object borderLayout) {
        this.panelMenu.add(panel, borderLayout);
    }

    /**
     * Set Menu Object
     */
    public void setMenu() {
        // Popup Menu Jugar
        JPopupMenu popMenuJugar = new JPopupMenu();

        // Item1 de Menu Jugar
		JMenuItem menuCrearPartida = new JMenuItem("CREAR PARTIDA");
		menuCrearPartida.setFont(new Font("ArcadeClassic", Font.PLAIN, 30));

        // Item2 de Menu Jugar
		JMenuItem menuCargarPartida = new JMenuItem("CARGAR PARTIDA");
		menuCargarPartida.setFont(new Font("ArcadeClassic", Font.PLAIN, 30));

        // A�adir los action listener a los item's de Menu Jugar
        menuCrearPartida.addActionListener(this.panelMenu);
        // menuCrearPartida.setActionCommand(this.panelMenu::CREAR_PARTIDA); //Como se le hace entonces??
        menuCargarPartida.addActionListener(this.panelMenu);
        // menuCargarPartida.setActionCommand(SELECCIONAR_PARTIDA); //Como se le hace entonces??

        // Agregar al Menu Jugar los Item's
        popMenuJugar.add(menuCrearPartida);
        popMenuJugar.add(menuCargarPartida);

        // Popup Menu Jugador
        JPopupMenu popMenuJugador = new JPopupMenu();

        // Item1 de Menu Jugador
		JMenuItem menuNuevoJugador = new JMenuItem("NUEVO JUGADOR");
		menuNuevoJugador.setFont(new Font("ArcadeClassic", Font.PLAIN, 30));

		// Item2 de Menu Jugador
		JMenuItem menuSeleccionarJugador = new JMenuItem("SELECCIONAR JUGADOR");
		menuSeleccionarJugador.setFont(new Font("ArcadeClassic", Font.PLAIN, 30));

		// A�adir los action listener a los Item's de Menu Jugador
		menuNuevoJugador.addActionListener(this.panelMenu);
		// menuNuevoJugador.setActionCommand(CREAR_JUGADOR);
		menuSeleccionarJugador.addActionListener(this.panelMenu);
		// menuSeleccionarJugador.setActionCommand(SELECCIONAR_JUGADOR);

        // Agregar al Menu Jugar los Item's
		popMenuJugador.add(menuNuevoJugador);
		popMenuJugador.add(menuSeleccionarJugador);
    }

    /**
     * Get resulting object
     *
     * @return PanelNivelInicial
     */
    public JPanel getResult() {
        PanelMenu panel = this.panelMenu;
        this.reset();

        return panel;
    }
}
