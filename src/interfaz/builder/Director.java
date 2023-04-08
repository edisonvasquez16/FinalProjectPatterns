package interfaz.builder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import interfaz.panelmenu.PanelMenu;

public class Director {

    private static final String FONT_NAME = "ArcadeClassic";

    private Builder builder;

    /**
     * Create and configure a PanelImagenInicial Object
     *
     * @param builder
     */
    public void makePanelImagenInicial(Builder builder) {
        // Agrega los tres elementos al panel: imagen de fondo, t�tulo del juego
        // y la intstrucci�n.

        // Imagen de fondo
        builder.setLabel(new JLabel(new ImageIcon("./data/imagenes/menuInicio.gif")));

        // Contenedor gr�fico
        builder.setLayout(new BorderLayout());

        // T�tulo del juego: "SPACE INVADERS"
        JLabel invaders = new JLabel("Space Invaders");
        invaders.setFont(new Font(FONT_NAME, Font.PLAIN, 50));
        invaders.setForeground(Color.WHITE);
        invaders.setBounds(150, 20, 400, 50);

        builder.setLabel(invaders);

        // Texto instructivo: "PRESIONE LA TECLA ENTER"
        JLabel enter = new JLabel("PRESIONE ENTER");
        enter.setForeground(Color.WHITE);
        enter.setFont(new Font(FONT_NAME, Font.PLAIN, 20));
        enter.setBounds(20, 440, 240, 30);

        builder.setLabel(enter);
    }

    /**
     * Create and configure a PanelMenu Object
     *
     * @param builder
     */
    public void makePanelMenu(Builder builder) {
        // T�tulo del juego: "SPACE INVADERS"
        JLabel space = new JLabel("SPACE INVADERS");

        space.setForeground(Color.WHITE);
        space.setFont(new Font(FONT_NAME, Font.PLAIN, 40));
        space.setBounds(45, 75, 560, 80);

        builder.setLabel(space);

        // JLabel de las mejoras
        JLabel labLoginRapido = new JLabel("LOGIN RAPIDO");
        labLoginRapido.setForeground(Color.WHITE);
        labLoginRapido.setFont(new Font(FONT_NAME, Font.PLAIN, 20));
        labLoginRapido.setBounds(15, 300, 250, 23);

        builder.setLabel(labLoginRapido);

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

		builder.setLabel(labOpenMenuJugar);

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

        builder.setLabel(labOpenMenuJugador);

        // JLabel de los mejores puntajes
        JLabel labMejoresPuntajes = new JLabel("MEJORES PUNTAJES");
        labMejoresPuntajes.setForeground(Color.WHITE);
        labMejoresPuntajes.setFont(new Font(FONT_NAME, Font.PLAIN, 20));
        labMejoresPuntajes.setBounds(15, 360, 340, 23);

        builder.setLabel(labMejoresPuntajes);

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

		builder.setLabel(labInstrucciones);

        builder.setMenu();

        // Establece el tama�o, la contenedora de tama�o y le quita el fondo que
		// trae por defecto.
        builder.setLayout(null);
        builder.setPreferredSize(new Dimension(640, 480));
        builder.setOpaque(false);
    }

    /**
     * Create and configure a PanelNivel Object
     *
     * @param builder
     */
    public void makePanelNivel(Builder builder) {
        builder.setLabels();
        builder.setLayout();
    }
}
