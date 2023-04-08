package interfaz.panelmenu;

import interfaz.InterfazSpaceInvaders;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Panel que representa la imagen inicial al ejecutar el programa
 *
 * @author Juan Sebasti�n Quintero Yoshioka - Manuel Alejandro Coral Lozano
 *         Proyecto final - Algoritmos y programaci�n II
 */
public class PanelImagenInicial extends JPanel implements KeyListener {

	// -----------------------------------------------------------------
	// ---------------------------Constantes----------------------------
	// -----------------------------------------------------------------

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	// -----------------------------------------------------------------
	// --------------------------Asociaciones---------------------------
	// -----------------------------------------------------------------

	/**
	 *
	 */
	private InterfazSpaceInvaders interfaz;

	/**
	 * Constructor
	 *
	 * @param interfaz
	 */
	public PanelImagenInicial() {

		// Inicializa la asociaci�n con la interfaz
		this.interfaz = InterfazSpaceInvaders.getInstance();

		// Contenedor gr�fico
		setLayout(new BorderLayout());

		// Imagen de fondo
		ImageIcon icono = new ImageIcon("./data/imagenes/menuInicio.gif");
		labImagen = new JLabel(icono);

		// T�tulo del juego: "SPACE INVADERS"
		JLabel invaders = new JLabel("Space Invaders");
		invaders.setFont(new Font("ArcadeClassic", Font.PLAIN, 50));
		invaders.setForeground(Color.WHITE);
		invaders.setBounds(150, 20, 400, 50);

		// Texto instructivo: "PRESIONE LA TECLA ESPACIO"
		JLabel espacio = new JLabel("PRESIONE ENTER");
		espacio.setForeground(Color.WHITE);
		espacio.setFont(new Font("ArcadeClassic", Font.PLAIN, 20));
		espacio.setBounds(20, 440, 240, 30);

		// Agrega los tres elementos al panel: imagen de fondo, t�tulo del juego
		// y la intstrucci�n.
		add(invaders);
		add(espacio);
		add(labImagen);

	}

	// -----------------------------------------------------------------
	// ----------------------Manejador de eventos-----------------------
	// -----------------------------------------------------------------

	/**
	 * Manejo de eventos de los botones
	 *
	 * @param e
	 *            Evento que gener� la acci�n - e != null.
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			// En caso que el usuario presione la tecla Enter, cambia al panel
			// que contiene el men� del juego
			if (!interfaz.estaEnFuncionamiento()) {
				interfaz.cambiarPanel("Menu");
			}
		}
	}

	/**
	 * Manejo de eventos de los botones
	 *
	 * @param e
	 *            Evento que gener� la acci�n - e != null.
	 */
	@Override
	public void keyReleased(KeyEvent e) {
	}

	/**
	 * Manejo de eventos de los botones
	 *
	 * @param e
	 *            Evento que gener� la acci�n - e != null.
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			interfaz.cambiarPanel("Menu");
		}
	}
}