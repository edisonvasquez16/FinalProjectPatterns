package interfaz.builder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import interfaz.InterfazSpaceInvaders;
import interfaz.PanelMenu;

public class PanelMenuBuilder {

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
     * Set the Labels for the Panel
     */
    public void setLabels() {
        // T�tulo del juego: "SPACE INVADERS"
        JLabel space = new JLabel("SPACE INVADERS");

        space.setForeground(Color.WHITE);
        space.setFont(new Font("ArcadeClassic", Font.PLAIN, 74));
        space.setBounds(5, 75, 560, 80);

        this.panelMenu.add(space);

        JLabel labelLoginRapido = new JLabel("LOGIN RAPIDO");
		labelLoginRapido.setForeground(Color.WHITE);
		labelLoginRapido.setBounds(10, 300, 250, 23);
		labelLoginRapido.setFont(new Font("ArcadeClassic", Font.PLAIN, 40));

        this.panelMenu.add(labelLoginRapido);

        // JLabel de las mejoras
        labelLoginRapido.addMouseListener(new MouseAdapter() {
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
                    this.panelMenu.interfaz.loginRapido(respuesta);
                }
            }
        });

        // Boton Open Menu Jugar
		JLabel labelOpenMenuJugar = new JLabel("JUGAR");
		labelOpenMenuJugar.setBounds(10, 240, 110, 23);
		labelOpenMenuJugar.setFont(new Font("ArcadeClassic", Font.PLAIN, 40));
		labelOpenMenuJugar.setForeground(Color.WHITE);
		labelOpenMenuJugar.setAlignmentX(RIGHT_ALIGNMENT);
		labelOpenMenuJugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				this.popMenuJugar.show(e.getComponent(), e.getX(), e.getY());
			}
		});

		this.panelMenu.add(labelOpenMenuJugar);

        // Boton Open Menu Jugador
        JLabel labelOpenMenuJugador = new JLabel("JUGADOR");
        labelOpenMenuJugador.setFont(new Font("ArcadeClassic", Font.PLAIN, 40));
        labelOpenMenuJugador.setBounds(10, 270, 190, 23);
        labelOpenMenuJugador.setForeground(Color.WHITE);
        labelOpenMenuJugador.setAlignmentX(RIGHT_ALIGNMENT);
        labelOpenMenuJugador.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                this.popMenuJugador.show(e.getComponent(), e.getX(), e.getY());
            }
        });

        this.panelMenu.add(labelOpenMenuJugador);

        // JLabel de los mejores puntajes
        JLabel labelMejoresPuntajes = new JLabel("MEJORES PUNTAJES");
        labelMejoresPuntajes.setForeground(Color.WHITE);
        labelMejoresPuntajes.setFont(new Font("ArcadeClassic", Font.PLAIN, 40));
        labelMejoresPuntajes.setBounds(10, 360, 340, 23);

        this.panelMenu.add(labelMejoresPuntajes);

        labelMejoresPuntajes.addMouseListener(new MouseListener() {

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
				this.panelMenu.interfaz.mejoresPuntajes();
			}
		});

        // JLabel con las intrucciones
		JLabel labelInstrucciones = new JLabel("INSTRUCCIONES");
		labelInstrucciones.setForeground(Color.WHITE);
		labelInstrucciones.setFont(new Font("ArcadeClassic", Font.PLAIN, 40));
		labelInstrucciones.setBounds(10, 330, 300, 23);
		labelInstrucciones.addMouseListener(new MouseListener() {

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
				this.panelMenu.dialogoInstrucciones.mostrar();
			}
		});

		this.panelMenu.add(labelInstrucciones);
    }

    /**
     * Set Layout Object
     */
    public void setLayout() {
        // Establece el tama�o, la contenedora de tama�o y le quita el fondo que
		// trae por defecto.
		this.panelMenu.setPreferredSize(new Dimension(640, 480));
		this.panelMenu.setLayout(null);
		this.panelMenu.setOpaque(false);
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
