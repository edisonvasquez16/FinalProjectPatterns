package interfaz.panelmenu;

import interfaz.InterfazSpaceInvaders;
import interfaz.dialogs.DialogBuilder;
import interfaz.dialogs.DialogBuilderWithLists;
import interfaz.dialogs.builders.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Panel que contiene el menu principal del juego
 *
 * @author Juan Sebastian Quintero Yoshioka - Manuel Alejandro Coral Lozano
 *         Proyecto final - Algoritmos y programaci�n II
 */
public class PanelMenu extends JPanel implements ActionListener {

	// -----------------------------------------------------------------
	// ---------------------------Constantes----------------------------
	// -----------------------------------------------------------------

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	public final static String CREAR_JUGADOR = "CREAR JUGADOR";

	/**
	 *
	 */
	public final static String SELECCIONAR_JUGADOR = "SELECCIONAR JUGADOR";

	/**
	 *
	 */
	public final static String CREAR_PARTIDA = "CREAR PARTIDA";

	/**
	 *
	 */
	public final static String SELECCIONAR_PARTIDA = "SELECCIONAR PARTIDA";

	private static final String FONT_NAME = "ArcadeClassic";

	// -----------------------------------------------------------------
	// --------------------------Asociaciones---------------------------
	// -----------------------------------------------------------------

	/**
	 *
	 */
	InterfazSpaceInvaders interfaz;

	// -----------------------------------------------------------------
	// ---------------------------Atributos-----------------------------
	// -----------------------------------------------------------------

	/**
	 *
	 */
	DialogBuilder dialogoCrearJugador;

	/**
	 *
	 */
	DialogBuilderWithLists dialogoSeleccionarJugador;

	/**
	 *
	 */
	DialogBuilder dialogoCrearPartida;

	/**
	 *
	 */
	DialogBuilderWithLists dialogoSeleccionarPartida;

	/**
	 *
	 */
	DialogBuilder dialogoInstrucciones;

	/**
	 *
	 */
	DialogBuilder dialogoMejoresPuntajes;

	/**
	 *
	 */
	JPopupMenu popMenuJugar;

	/**
	 *
	 */
	JMenuItem menuCrearPartida;

	/**
	 *
	 */
	JMenuItem menuCargarPartida;

	/**
	 *
	 */
	JPopupMenu popMenuJugador;

	/**
	 *
	 */
	JMenuItem menuNuevoJugador;

	/**
	 *
	 */
	JMenuItem menuSeleccionarJugador;

	// -----------------------------------------------------------------
	// ---------------------------Constructor---------------------------
	// -----------------------------------------------------------------

	/**
	 * PanelMenu Class
	 */
	public PanelMenu() {

		// Inicializa la asociaci�n
		this.interfaz = InterfazSpaceInvaders.getInstance();

		// Establece el tama�o, la contenedora de tama�o y le quita el fondo que
		// trae por defecto.
		setPreferredSize(new Dimension(640, 480));
		setLayout(null);
		setOpaque(false);

		// T�tulo del juego: "SPACE INVADERS"
		JLabel space = new JLabel("SPACE");
		space.setForeground(Color.WHITE);
		space.setFont(new Font("ArcadeClassic", Font.PLAIN, 40));
		space.setBounds(100, 50, 560, 80);
		JLabel invaders = new JLabel("INVADERS");
		invaders.setForeground(Color.WHITE);
		invaders.setFont(new Font("ArcadeClassic", Font.PLAIN, 40));
		invaders.setBounds(150, 90, 560, 80);
		ImageIcon image6 = new ImageIcon("./data/imagenes/menu/invaders.png");
		JLabel invadersIcon = new JLabel(image6);
		invadersIcon.setBounds(20, 75, 64, 64);
		add(invadersIcon);
		add(space);
		add(invaders);

		// Inicializa los 4 di�logos que se puede ver en el menu
		dialogoCrearJugador = new CreatePlayerDialogBuilder();
		dialogoCrearJugador.setLayout();

		dialogoCrearPartida = new CreateGameDialogBuilder();
		dialogoCrearPartida.setLayout();

		dialogoSeleccionarJugador = new SelectPlayerDialogBuilder();
		dialogoSeleccionarJugador.setLayout();

		dialogoSeleccionarPartida = new SelectGameDialogBuilder();
		dialogoSeleccionarPartida.setLayout();

		dialogoInstrucciones = new InstructionsDialogBuilder();
		dialogoInstrucciones.setLayout();

		// Popup Menu Jugar
		popMenuJugar = new JPopupMenu();

		// Item1 de Menu Jugar
		menuCrearPartida = new JMenuItem("Crear partida");
		menuCrearPartida.setFont(new Font(FONT_NAME, Font.PLAIN, 20));

		// Item2 de Menu Jugar
		menuCargarPartida = new JMenuItem("Cargar partida");
		menuCargarPartida.setFont(new Font(FONT_NAME, Font.PLAIN, 20));

		// A�adir los action listener a los item's de Menu Jugar
		menuCrearPartida.addActionListener(this);
		menuCrearPartida.setActionCommand(CREAR_PARTIDA);
		menuCargarPartida.addActionListener(this);
		menuCargarPartida.setActionCommand(SELECCIONAR_PARTIDA);

		// Agregar al Menu Jugar los Item's
		popMenuJugar.add(menuCrearPartida);
		popMenuJugar.add(menuCargarPartida);

		// Popup Menu Jugador
		popMenuJugador = new JPopupMenu();

		// Item1 de Menu Jugador
		menuNuevoJugador = new JMenuItem("Nuevo jugador");
		menuNuevoJugador.setFont(new Font(FONT_NAME, Font.PLAIN, 20));

		// Item2 de Menu Jugador
		menuSeleccionarJugador = new JMenuItem("Seleccionar jugador");
		menuSeleccionarJugador.setFont(new Font(FONT_NAME, Font.PLAIN, 20));

		// A�adir los action listener a los Item's de Menu Jugador
		menuNuevoJugador.addActionListener(this);
		menuNuevoJugador.setActionCommand(CREAR_JUGADOR);
		menuSeleccionarJugador.addActionListener(this);
		menuSeleccionarJugador.setActionCommand(SELECCIONAR_JUGADOR);

		// Agregar al Menu Jugar los Item's
		popMenuJugador.add(menuNuevoJugador);
		popMenuJugador.add(menuSeleccionarJugador);

		// TODO
		// Inicio temporal

		// Boton Open Menu Jugar
		labOpenMenuJugar = new JLabel("JUGAR");
		labOpenMenuJugar.setBounds(55, 242, 110, 23);
		labOpenMenuJugar.setFont(new Font("ArcadeClassic", Font.PLAIN, 20));
		labOpenMenuJugar.setForeground(Color.WHITE);
		labOpenMenuJugar.setAlignmentX(RIGHT_ALIGNMENT);
		labOpenMenuJugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				popMenuJugar.show(e.getComponent(), e.getX(), e.getY());
			}
		});
		ImageIcon image = new ImageIcon("./data/imagenes/menu/play.png");
		JLabel playIcon = new JLabel(image);
		playIcon.setBounds(15, 240, 32, 32);
		add(playIcon);
		add(labOpenMenuJugar);

		// Boton Open Menu Jugador
		labOpenMenuJugador = new JLabel("JUGADOR");
		labOpenMenuJugador.setFont(new Font("ArcadeClassic", Font.PLAIN, 20));
		labOpenMenuJugador.setBounds(55, 282, 190, 23);
		labOpenMenuJugador.setForeground(Color.WHITE);
		labOpenMenuJugador.setAlignmentX(RIGHT_ALIGNMENT);
		labOpenMenuJugador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				popMenuJugador.show(e.getComponent(), e.getX(), e.getY());
			}
		});
		ImageIcon image2 = new ImageIcon("./data/imagenes/menu/player.png");
		JLabel playerIcon = new JLabel(image2);
		playerIcon.setBounds(15, 280, 32, 32);
		add(playerIcon);
		add(labOpenMenuJugador);

		// JLabel de las mejoras
		labLoginRapido = new JLabel("LOGIN RAPIDO");
		labLoginRapido.setForeground(Color.WHITE);
		labLoginRapido.setBounds(55, 322, 250, 23);
		labLoginRapido.setFont(new Font("ArcadeClassic", Font.PLAIN, 20));
		ImageIcon image3 = new ImageIcon("./data/imagenes/menu/fastLogin.png");
		JLabel fastLoginIcon = new JLabel(image3);
		fastLoginIcon.setBounds(15, 320, 32, 32);
		add(fastLoginIcon);
		add(labLoginRapido);
		labLoginRapido.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String respuesta = 	JOptionPane.showInputDialog(null, "Por favor ingresa tu nickname", "Login r�pido", JOptionPane.DEFAULT_OPTION);
				if(respuesta == null || respuesta.equals("")){
					JOptionPane.showMessageDialog(null, "Por favor ingresar un nickname v�lido",
							"Error al escribir el nickname", JOptionPane.ERROR_MESSAGE);
				} else if(respuesta.length() != 5){
					JOptionPane.showMessageDialog(null, "Recuerde que el nickname contiene 5 d�gitos",
							"Error al escribir el nickname", JOptionPane.ERROR_MESSAGE);
				} else
					interfaz.loginRapido(respuesta);
			}
		});

		//Fin temporal

		// JLabel con las intrucciones
		labInstrucciones = new JLabel("INSTRUCCIONES");
		labInstrucciones.setForeground(Color.WHITE);
		labInstrucciones.setFont(new Font("ArcadeClassic", Font.PLAIN, 20));
		labInstrucciones.setBounds(55, 362, 300, 23);
		ImageIcon image4 = new ImageIcon("./data/imagenes/menu/instructions.png");
		JLabel instructionsIcon = new JLabel(image4);
		instructionsIcon.setBounds(15, 360, 32, 32);
		add(instructionsIcon);
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
				dialogoInstrucciones.viewDialog();
			}
		});
		// labInstrucciones.addMouseListener(new MouseAdapter() {
		// @Override
		// public void mouseClicked(MouseEvent e) {
		// dialogoInstrucciones.mostrar();
		// }
		// });
		add(labInstrucciones);

		// JLabel de los mejores puntajes
		labMejoresPuntajes = new JLabel("MEJORES PUNTAJES");
		labMejoresPuntajes.setForeground(Color.WHITE);
		labMejoresPuntajes.setFont(new Font("ArcadeClassic", Font.PLAIN, 20));
		labMejoresPuntajes.setBounds(55, 402, 340, 23);
		ImageIcon image5 = new ImageIcon("./data/imagenes/menu/scores.png");
		JLabel scoresIcon = new JLabel(image5);
		scoresIcon.setBounds(15, 400, 32, 32);
		add(scoresIcon);
		add(labMejoresPuntajes);
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
				interfaz.mejoresPuntajes();
			}
		});

	}

	// -----------------------------------------------------------------
	// ----------------------Manejador de eventos-----------------------
	// -----------------------------------------------------------------

	/**
	 *
	 */
	public void actionPerformed(ActionEvent e) {

		String comando = e.getActionCommand();

		if (comando.equals(CREAR_JUGADOR)) {
			dialogoCrearJugador.viewDialog();
		} else if (comando.equals(SELECCIONAR_JUGADOR)) {
			interfaz.actualizarJugadores();
			dialogoSeleccionarJugador.getResult();
		} else if (comando.equals(CREAR_PARTIDA)) {
			if (interfaz.getJugadorActual() != null) {
				dialogoCrearPartida.viewDialog();
			} else {
				JOptionPane.showMessageDialog(this, "Por favor crear o seleccionar un jugador",
						"Error al iniciar partida", JOptionPane.ERROR_MESSAGE);
			}
		} else if (comando.equals(SELECCIONAR_PARTIDA)) {
			if (interfaz.getJugadorActual() != null) {
				interfaz.actualizarPartidas();
				dialogoSeleccionarPartida.getResult();
			} else {
				JOptionPane.showMessageDialog(this, "Por favor crear o seleccionar un jugador",
						"Error al seleccionar la partida", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	// -----------------------------------------------------------------
	// -----------------------------M�todos-----------------------------
	// -----------------------------------------------------------------

	/**
	 *
	 */
	public DialogBuilderWithLists getDialogoSeleccionarJugador() {
		return dialogoSeleccionarJugador;
	}

	/**
	 *
	 * @return
	 */
	public DialogBuilderWithLists getDialogoSeleccionarPartida() {
		return dialogoSeleccionarPartida;
	}


	/**
	 *
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		// Pinta la imagen de fondo
		ImageIcon fondo = new ImageIcon("./data/imagenes/menu2.png");
		g2.drawImage(fondo.getImage(), 0, 0, getSize().width, getSize().height, null);

		// Dibuja el nickname, nombre y monedas del jugador actual del juego.
		g2.setColor(Color.lightGray);
		g2.setFont(new Font(FONT_NAME, Font.PLAIN, 20));
		g2.drawString("NICKNAME", 360, 430);
		g2.drawString("JUGADOR", 500, 430);
		ImageIcon playerSelect = new ImageIcon("./data/imagenes/menu/playerSelect.png");
		JLabel playerSelectIcon = new JLabel(playerSelect);
		playerSelectIcon.setBounds(320, 430, 32, 32);
		add(playerSelectIcon);


		g2.setColor(Color.CYAN);
		if (interfaz.getJugadorActual() != null) {
			g2.drawString(interfaz.getJugadorActual().getNickname(), 360, 460);

			if (interfaz.getJugadorActual().getNombre().length() <= 13) {
				g2.drawString(interfaz.getJugadorActual().getNombre(), 500, 460);
			} else {
				g2.drawString(interfaz.getJugadorActual().getNombre().substring(0, 13), 500, 470);
			}
		}
	}

	public DialogBuilder getDialogoMejoresPuntajes() {
		return dialogoMejoresPuntajes;
	}

	public void setDialogoMejoresPuntajes(DialogBuilder dialogoMejoresPuntajes) {
		this.dialogoMejoresPuntajes = dialogoMejoresPuntajes;
	}
}