package interfaz.builder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import interfaz.InterfazSpaceInvaders;
import interfaz.panelmenu.PanelMenu;

public class PanelMenuBuilder implements Builder {

    private static final String FONT_NAME = "ArcadeClassic";

    private PanelMenu panelMenu;
    private JPopupMenu popMenuJugar;
    private JPopupMenu popMenuJugador;

    public PanelMenuBuilder() {
        this.panelMenu = new PanelMenu();
    }

    /**
     * Reset the object
     */
    public void reset() {
        this.panelMenu = new PanelMenu();
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
     * Set Size Object
     */
    public void setSize(int x, int y) {
        this.panelMenu.setSize(x, y);
    }

    public void setLabels() {
        // JLabel de las mejoras
        JLabel labLoginRapido = new JLabel("LOGIN RAPIDO");
        labLoginRapido.setForeground(Color.WHITE);
        labLoginRapido.setFont(new Font(FONT_NAME, Font.PLAIN, 20));
        labLoginRapido.setBounds(15, 300, 250, 23);

        this.setLabel(labLoginRapido);

        labLoginRapido.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String respuesta = 	JOptionPane.showInputDialog(null, "Por favor ingresa tu nickname", "Login r�pido", JOptionPane.DEFAULT_OPTION);

                if(respuesta == null || respuesta.equals("")){
                    JOptionPane.showMessageDialog(null, "Por favor ingresar un nickname v�lido",
                            "Error al escribir el nickname", JOptionPane.ERROR_MESSAGE);
                } else if(respuesta.length() != 5){
                    JOptionPane.showMessageDialog(null, "Recuerde que el nickname contiene 5 d�gitos",
                            "Error al escribir el nickname", JOptionPane.ERROR_MESSAGE);
                } else {
                    this.panelMenu.interfaz.loginRapido(respuesta); //TODO: REFERENCIA SIN RESOLVER
                }
            }
        });

        // Boton Open Menu Jugar
        JLabel labOpenMenuJugar = new JLabel("JUGAR");

        labOpenMenuJugar.setBounds(15, 240, 110, 23);
        labOpenMenuJugar.setFont(new Font(FONT_NAME, Font.PLAIN, 20));
        labOpenMenuJugar.setForeground(Color.WHITE);
        labOpenMenuJugar.setAlignmentX(JPanel.RIGHT_ALIGNMENT);

        labOpenMenuJugar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                this.popMenuJugar.show(e.getComponent(), e.getX(), e.getY()); //TODO: REFERENCIA SIN RESOLVER
            }
        });

        this.setLabel(labOpenMenuJugar);

        // Boton Open Menu Jugador
        JLabel labOpenMenuJugador = new JLabel("JUGADOR");

        labOpenMenuJugador.setFont(new Font(FONT_NAME, Font.PLAIN, 20));
        labOpenMenuJugador.setBounds(15, 270, 190, 23);
        labOpenMenuJugador.setForeground(Color.WHITE);
        labOpenMenuJugador.setAlignmentX(JPanel.RIGHT_ALIGNMENT);

        labOpenMenuJugador.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                this.popMenuJugador.show(e.getComponent(), e.getX(), e.getY()); //TODO: REFERENCIA SIN RESOLVER
            }
        });

        this.setLabel(labOpenMenuJugador);

        // JLabel de los mejores puntajes
        JLabel labMejoresPuntajes = new JLabel("MEJORES PUNTAJES");
        labMejoresPuntajes.setForeground(Color.WHITE);
        labMejoresPuntajes.setFont(new Font(FONT_NAME, Font.PLAIN, 20));
        labMejoresPuntajes.setBounds(15, 360, 340, 23);

        this.setLabel(labMejoresPuntajes);

        labMejoresPuntajes.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseClicked(MouseEvent e) {
                this.panelMenu.interfaz.mejoresPuntajes(); //TODO: REFERENCIA SIN RESOLVER
            }
        });

        // JLabel con las intrucciones
        JLabel labInstrucciones = new JLabel("INSTRUCCIONES");

        labInstrucciones.setForeground(Color.WHITE);
        labInstrucciones.setFont(new Font(FONT_NAME, Font.PLAIN, 20));
        labInstrucciones.setBounds(15, 330, 300, 23);

        labInstrucciones.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseClicked(MouseEvent e) {
                this.panelMenu.dialogoInstrucciones.viewDialog();  //TODO: REFERENCIA SIN RESOLVER
            }
        });

        this.setLabel(labInstrucciones);
    }

    /**
     * Set Menu Object
     */
    public void setMenu() {
        // Popup Menu Jugar
        popMenuJugar = new JPopupMenu();

        // Item1 de Menu Jugar
		JMenuItem menuCrearPartida = new JMenuItem("CREAR PARTIDA");
		menuCrearPartida.setFont(new Font("ArcadeClassic", Font.PLAIN, 30));

        // Item2 de Menu Jugar
		JMenuItem menuCargarPartida = new JMenuItem("CARGAR PARTIDA");
		menuCargarPartida.setFont(new Font("ArcadeClassic", Font.PLAIN, 30));

        // A�adir los action listener a los item's de Menu Jugar
        menuCrearPartida.addActionListener(this.panelMenu);
        menuCrearPartida.setActionCommand(PanelMenu.CREAR_PARTIDA); //Como se le hace entonces??
        menuCargarPartida.addActionListener(this.panelMenu);
        menuCargarPartida.setActionCommand(PanelMenu.SELECCIONAR_PARTIDA); //Como se le hace entonces??

        // Agregar al Menu Jugar los Item's
        popMenuJugar.add(menuCrearPartida);
        popMenuJugar.add(menuCargarPartida);

        // Popup Menu Jugador
        popMenuJugador = new JPopupMenu();

        // Item1 de Menu Jugador
		JMenuItem menuNuevoJugador = new JMenuItem("NUEVO JUGADOR");
		menuNuevoJugador.setFont(new Font("ArcadeClassic", Font.PLAIN, 30));

		// Item2 de Menu Jugador
		JMenuItem menuSeleccionarJugador = new JMenuItem("SELECCIONAR JUGADOR");
		menuSeleccionarJugador.setFont(new Font("ArcadeClassic", Font.PLAIN, 30));

		// A�adir los action listener a los Item's de Menu Jugador
		menuNuevoJugador.addActionListener(this.panelMenu);
		menuNuevoJugador.setActionCommand(PanelMenu.CREAR_JUGADOR);
		menuSeleccionarJugador.addActionListener(this.panelMenu);
		menuSeleccionarJugador.setActionCommand(PanelMenu.SELECCIONAR_JUGADOR);

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
