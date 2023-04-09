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

        // T�tulo del juego: "SPACE INVADERS"
        JLabel invaders = new JLabel("Space Invaders");
        invaders.setFont(new Font(FONT_NAME, Font.PLAIN, 50));
        invaders.setForeground(Color.WHITE);
        invaders.setBounds(150, 20, 400, 50);

        // Texto instructivo: "PRESIONE LA TECLA ENTER"
        JLabel enter = new JLabel("PRESIONE ENTER");
        enter.setForeground(Color.WHITE);
        enter.setFont(new Font(FONT_NAME, Font.PLAIN, 20));
        enter.setBounds(20, 440, 240, 30);

        // Contenedor gr�fico
        builder.setLayout(new BorderLayout());

        // Imagen de fondo
        builder.setLabel(new JLabel(new ImageIcon("./data/imagenes/menuInicio.gif")));

        builder.setLabel(invaders);
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
        builder.setSize(640, 480);
    }
}
