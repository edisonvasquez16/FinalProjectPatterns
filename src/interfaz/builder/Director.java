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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Director {

    private static final String FONT_NAME = "ArcadeClassic";

    /**
     * Create and configure a PanelImagenInicial Object
     *
     * @param builder
     */
    public void makePanelImagenInicial(Builder builder) {
        ImageIcon icono = new ImageIcon("./data/imagenes/menuInicio.gif");
        JLabel labelImagen = new JLabel(icono);

        builder.setLabel(labelImagen);
        builder.setLabel(new JLabel(new ImageIcon("./data/imagenes/menuInicio.gif")));

        // Contenedor gr�fico
        Color fondo = new Color(21, 22, 25);

        builder.setLayout(new BorderLayout());
        builder.setBackground(fondo);

        // T�tulo del juego: "SPACE INVADERS"
        JLabel space = new JLabel("Space ");
        space.setFont(new Font(FONT_NAME, Font.PLAIN, 82));
        space.setForeground(Color.WHITE);

        JLabel invaders = new JLabel("Invaders");
        invaders.setFont(new Font(FONT_NAME, Font.PLAIN, 82));
        invaders.setForeground(Color.WHITE);

        /**
         * Could be only one JLabel rather than two?
         */
        // JLabel space_invaders = new JLabel("Space Invaders");
        // invaders.setFont(new Font(FONT_NAME, Font.PLAIN, 82));
        // invaders.setForeground(Color.WHITE);

        // titulo.add(space_invaders);

        /**
         * END
         */

        JPanel titulo = new JPanel(new FlowLayout());

        titulo.setBackground(fondo);
        titulo.add(space);
        titulo.add(invaders);

        builder.setPanel(titulo, BorderLayout.NORTH);

        // Texto instructivo: "PRESIONE LA TECLA ESPACIO"
        JPanel flow = new JPanel(new FlowLayout());

        JLabel presione = new JLabel("PRESIONE ");
        JLabel la = new JLabel("LA ");
        JLabel tecla = new JLabel("TECLA ");
        JLabel espacio = new JLabel("ENTER ");

        presione.setFont(new Font(FONT_NAME, Font.PLAIN, 49));
        presione.setForeground(Color.BLUE);

        la.setFont(new Font(FONT_NAME, Font.PLAIN, 49));
        la.setForeground(Color.RED);

        tecla.setFont(new Font(FONT_NAME, Font.PLAIN, 49));
        tecla.setForeground(Color.GREEN);

        espacio.setFont(new Font(FONT_NAME, Font.PLAIN, 49));
        espacio.setForeground(Color.YELLOW);

        flow.setBackground(fondo);
        flow.add(presione);
        flow.add(la);
        flow.add(tecla);
        flow.add(espacio);

        builder.setPanel(flow, BorderLayout.SOUTH);
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
        space.setFont(new Font(FONT_NAME, Font.PLAIN, 74));
        space.setBounds(5, 75, 560, 80);

        builder.setLabel(space);

        JLabel labelLoginRapido = new JLabel("LOGIN RAPIDO");
        labelLoginRapido.setForeground(Color.WHITE);
        labelLoginRapido.setFont(new Font(FONT_NAME, Font.PLAIN, 40));
        labelLoginRapido.setBounds(10, 300, 250, 23);

        builder.setLabel(labelLoginRapido);

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
		labelOpenMenuJugar.setFont(new Font(FONT_NAME, Font.PLAIN, 40));
		labelOpenMenuJugar.setForeground(Color.WHITE);
		labelOpenMenuJugar.setAlignmentX(RIGHT_ALIGNMENT);

		labelOpenMenuJugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				this.popMenuJugar.show(e.getComponent(), e.getX(), e.getY());
			}
		});

		builder.setLabel(labelOpenMenuJugar);

        // Boton Open Menu Jugador
        JLabel labelOpenMenuJugador = new JLabel("JUGADOR");

        labelOpenMenuJugador.setFont(new Font(FONT_NAME, Font.PLAIN, 40));
        labelOpenMenuJugador.setBounds(10, 270, 190, 23);
        labelOpenMenuJugador.setForeground(Color.WHITE);
        labelOpenMenuJugador.setAlignmentX(RIGHT_ALIGNMENT);

        labelOpenMenuJugador.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                this.popMenuJugador.show(e.getComponent(), e.getX(), e.getY());
            }
        });

        builder.setLabel(labelOpenMenuJugador);

        // JLabel de los mejores puntajes
        JLabel labelMejoresPuntajes = new JLabel("MEJORES PUNTAJES");
        labelMejoresPuntajes.setForeground(Color.WHITE);
        labelMejoresPuntajes.setFont(new Font(FONT_NAME, Font.PLAIN, 40));
        labelMejoresPuntajes.setBounds(10, 360, 340, 23);

        builder.setLabel(labelMejoresPuntajes);

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
		labelInstrucciones.setFont(new Font(FONT_NAME, Font.PLAIN, 40));
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

		builder.setLabel(labelInstrucciones);

        builder.setMenu(); //TODO: Jack work here remaining


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
