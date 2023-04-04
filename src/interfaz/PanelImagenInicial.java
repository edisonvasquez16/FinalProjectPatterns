package interfaz;

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

	// -----------------------------------------------------------------
	// ---------------------------Atributos-----------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 */
	private JLabel labImagen;

	// -----------------------------------------------------------------
	// ---------------------------Constructor---------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 * @param interfaz
	 */
	public PanelImagenInicial(InterfazSpaceInvaders interfaz) {

		// Inicializa la asociaci�n con la interfaz
		this.interfaz = interfaz;

		// Contenedor gr�fico
		setLayout(new BorderLayout());

		// Imagen de fondo
		ImageIcon icono = new ImageIcon("./data/imagenes/menuInicio.gif");
		labImagen = new JLabel(icono);
		Color fondo = new Color(21, 22, 25);
		setBackground(fondo);

		// T�tulo del juego: "SPACE INVADERS"
		JPanel titulo = new JPanel(new FlowLayout());
		JLabel invaders = new JLabel("Space Invaders");
		invaders.setFont(new Font("ArcadeClassic", Font.PLAIN, 82));
		invaders.setForeground(Color.WHITE);
		titulo.setBackground(fondo);
		titulo.add(invaders);

		// Texto instructivo: "PRESIONE LA TECLA ESPACIO"
		JPanel flow = new JPanel(new FlowLayout());
		JLabel espacio = new JLabel("PRESIONE ENTER ");
		espacio.setForeground(Color.WHITE);
		espacio.setFont(new Font("ArcadeClassic", Font.PLAIN, 49));
		flow.setBackground(fondo);
		flow.add(espacio);

		// Agrega los tres elementos al panel: imagen de fondo, t�tulo del juego
		// y la intstrucci�n.
		add(labImagen, BorderLayout.CENTER);
		add(titulo, BorderLayout.NORTH);
		add(flow, BorderLayout.SOUTH);

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
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
			// En caso que el usuario presione la tecla Enter, cambia al panel
			// que contiene el men� del juego
			if(!interfaz.estaEnFuncionamiento())
			interfaz.cambiarPanel("Men�");
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
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
			interfaz.cambiarPanel("Men�");
	}
}