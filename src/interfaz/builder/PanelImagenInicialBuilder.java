package interfaz.builder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaz.InterfazSpaceInvaders;
import interfaz.PanelImagenInicial;

/**
 * PanelImagenInicialBuilder in charge of configure a PanelImagenInicial object
 *
 * @author wmarin
 */
public class PanelImagenInicialBuilder implements Builder {

    private PanelImagenInicial panelImagenInicial;

    public PanelImagenInicialBuilder() {
        this.panelImagenInicial = new PanelImagenInicial(new InterfazSpaceInvaders());
    }

    /**
     * Reset the object
     */
    public void reset() {
        this.panelImagenInicial = new PanelImagenInicial(new InterfazSpaceInvaders());
    }

    /**
     * Set the Labels for the Panel
     */
    public void setLabels() {
        ImageIcon icono = new ImageIcon("./data/imagenes/menuInicio.gif");
        JLabel labelImagen = new JLabel(icono);

        this.panelImagenInicial.add(labelImagen, BorderLayout.CENTER);
    }

    /**
     * Set Layout Object
     */
    public void setLayout() {
        // Contenedor gr�fico
        Color fondo = new Color(21, 22, 25);
        this.panelImagenInicial.setLayout(new BorderLayout());
        this.panelImagenInicial.setBackground(fondo);

        // T�tulo del juego: "SPACE INVADERS"
        JPanel titulo = new JPanel(new FlowLayout());
        JLabel space = new JLabel("Space ");
        space.setFont(new Font("ArcadeClassic", Font.PLAIN, 82));
        space.setForeground(Color.WHITE);

        JLabel invaders = new JLabel("Invaders");
        invaders.setFont(new Font("ArcadeClassic", Font.PLAIN, 82));
        invaders.setForeground(Color.WHITE);

        titulo.setBackground(fondo);
        titulo.add(space);
        titulo.add(invaders);

        // Texto instructivo: "PRESIONE LA TECLA ESPACIO"
        JPanel flow = new JPanel(new FlowLayout());

        JLabel presione = new JLabel("PRESIONE ");
        JLabel la = new JLabel("LA ");
        JLabel tecla = new JLabel("TECLA ");
        JLabel espacio = new JLabel("ENTER ");

        presione.setFont(new Font("ArcadeClassic", Font.PLAIN, 49));
        presione.setForeground(Color.BLUE);

		la.setFont(new Font("ArcadeClassic", Font.PLAIN, 49));
        la.setForeground(Color.RED);

        tecla.setFont(new Font("ArcadeClassic", Font.PLAIN, 49));
        tecla.setForeground(Color.GREEN);

        espacio.setFont(new Font("ArcadeClassic", Font.PLAIN, 49));
        espacio.setForeground(Color.YELLOW);

        flow.setBackground(fondo);
        flow.add(presione);
        flow.add(la);
        flow.add(tecla);
        flow.add(espacio);

        // Agrega los tres elementos al panel: imagen de fondo, t�tulo del juego
        // y la intstrucci�n.
        this.panelImagenInicial.add(titulo, BorderLayout.NORTH);
        this.panelImagenInicial.add(flow, BorderLayout.SOUTH);
    }

    /**
     * Set Menu Object
     */
    public void setMenu() {

    }

    /**
     * Get resulting object
     *
     * @return PanelImagenInicial
     */
    public JPanel getResult() {
        PanelImagenInicial panel = this.panelImagenInicial;
        this.reset();

        return panel;
    }
}
