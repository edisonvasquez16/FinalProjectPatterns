package interfaz.dialogs.concrets;

import interfaz.InterfazSpaceInvaders;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author squin
 *
 */
public class CreatePlayer extends JDialog implements ActionListener {

	// -----------------------------------------------------------------
	// ---------------------------Constantes----------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/***
	 * 
	 */
	private final static String ACEPTAR = "Aceptar";

	/**
	 * 
	 */
	private final static String CANCELAR = "Cancelar";

	// -----------------------------------------------------------------
	// --------------------------Asociaciones---------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 */
	InterfazSpaceInvaders interfaz;

	/**
	 * 
	 */
	JPanel auxiliar;

	// -----------------------------------------------------------------
	// ----------------------------Atributos----------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 */
	JLabel labNombre;

	/**
	 * 
	 */
	JLabel labNickname;

	/**
	 * 
	 */
	JTextField txtNombre;

	/**
	 * 
	 */
	JTextField txtNickame;

	/**
	 * 
	 */
	JButton butBotonAceptar;

	/**
	 * 
	 */
	JButton butBotonCancelar;

	// -----------------------------------------------------------------
	// ---------------------------Constructor---------------------------
	// -----------------------------------------------------------------

	public CreatePlayer() {

		super(InterfazSpaceInvaders.getInstance(), true);

		this.interfaz = InterfazSpaceInvaders.getInstance();
		setLayout(null);

		auxiliar = new JPanel();
		auxiliar.setLayout(null);

		labNombre = new JLabel("NOMBRE DEL JUGADOR");
		labNombre.setForeground(Color.LIGHT_GRAY);
		labNombre.setFont(new Font("ArcadeClassic", Font.PLAIN, 20));
		labNombre.setBounds(160, 60, 350, 20);

		txtNombre = new JTextField();
		txtNombre.setBackground(Color.white);
		txtNombre.setBounds(180, 85, 205, 25);
		txtNombre.setForeground(Color.black);
		txtNombre.setFont(new Font("ArcadeClassic", Font.PLAIN, 15));

		labNickname = new JLabel("NICKNAME");
		labNickname.setForeground(Color.LIGHT_GRAY);
		labNickname.setFont(new Font("ArcadeClassic", Font.PLAIN, 20));
		labNickname.setBounds(270, 150, 260, 20);

		txtNickame = new JTextField();
		txtNickame.setBackground(Color.white);
		txtNickame.setBounds(230, 180, 150, 25);
		txtNickame.setForeground(Color.black);
		txtNickame.setFont(new Font("ArcadeClassic", Font.PLAIN, 15));

		JLabel imagen = new JLabel();
		ImageIcon icono = new ImageIcon("./data/imagenes/fondAgJ.jpg");
		imagen.setIcon(icono);
		imagen.setBounds(0, 0, icono.getIconWidth(), icono.getIconHeight());

		butBotonAceptar = new JButton(ACEPTAR);
		butBotonAceptar.setActionCommand(ACEPTAR);
		butBotonAceptar.addActionListener(this);
		butBotonAceptar.setBounds(250, 210, 130, 25);
		butBotonAceptar.setBackground(Color.WHITE);
		butBotonAceptar.setFont(new Font("ArcadeClassic", Font.PLAIN, 20));
		butBotonAceptar.setForeground(Color.BLACK);

		butBotonCancelar = new JButton(CANCELAR);
		butBotonCancelar.setActionCommand(CANCELAR);
		butBotonCancelar.addActionListener(this);
		butBotonCancelar.setBounds(250, 350, 130, 25);
		butBotonCancelar.setBackground(Color.WHITE);
		butBotonCancelar.setFont(new Font("ArcadeClassic", Font.PLAIN, 20));
		butBotonCancelar.setForeground(Color.BLACK);

		auxiliar.setSize(icono.getIconWidth(), icono.getIconHeight());
		auxiliar.add(labNombre);
		auxiliar.add(txtNombre);
		auxiliar.add(labNickname);
		auxiliar.add(txtNickame);
		auxiliar.add(butBotonAceptar);
		auxiliar.add(butBotonCancelar);
		auxiliar.add(imagen);

		setTitle("Crear Jugador");
		setUndecorated(true);
		getRootPane().setBorder(BorderFactory.createLineBorder(Color.WHITE));
	}

	// -----------------------------------------------------------------
	// ----------------------Manejador de eventos-----------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		String comando = e.getActionCommand();
		if (comando.equals(CANCELAR)) {
			this.dispose();
		} else if (comando.equals(ACEPTAR)) {
			if (txtNombre.getText().equals(null) || txtNombre.getText().equals("") || txtNickame.getText().equals(null)
					|| txtNickame.getText().equals(""))
				JOptionPane.showMessageDialog(this, "Por favor ingrese un nombre y un nickname v�lido",
						"Error al crear el jugador", JOptionPane.ERROR_MESSAGE);

			else if (txtNickame.getText().length() < 5) {
				JOptionPane.showMessageDialog(this, "El nickname debe contener 5 o mas caracteres",
						"Error al asignar el nickname", JOptionPane.ERROR_MESSAGE);
			} else {
				interfaz.reqAgregarJugador(txtNombre.getText(), txtNickame.getText());
				this.dispose();
			}
		}
	}
	// Fin temporal
	// -----------------------------------------------------------------
	// -----------------------------M�todos-----------------------------
	// -----------------------------------------------------------------

	// -----------------------------------------------------------------
	// -----------------------------M�todos-----------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 */
	public void mostrar() {
		setSize(400, 400);
		add(auxiliar);
		setLocationRelativeTo(null);
		this.setVisible(true);
	}

}