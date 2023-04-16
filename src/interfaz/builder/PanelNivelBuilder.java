package interfaz.builder;

import javax.swing.*;

import interfaz.PanelNivel;
import mundo.Partida;
import mundo.SpaceInvaders;

import java.awt.*;

public class PanelNivelBuilder implements Builder {

    private PanelNivel panelNivel;
    private Partida actual;
    private SpaceInvaders mundo;

    public PanelNivelBuilder(Partida actual, SpaceInvaders mundo) {
        this.actual = actual;
        this.mundo = mundo;
        this.panelNivel = new PanelNivel(actual, mundo);
    }

    /**
     * Reset the object
     */
    public void reset() {
        this.panelNivel = new PanelNivel(actual, mundo);
    }

    /**
     * Set a Label for the Panel
     */
    public void setLabel(JLabel label) {
        this.panelNivel.add(label);
    }

    /**
     * Set Layout Object
     */
    public void setLayout(BorderLayout layout) {
        this.panelNivel.setLayout(layout);
    }

    /**
     * Set Size Object
     */
    public void setSize(int x, int y) {
        this.panelNivel.setSize(x, y);
    }

    /**
     * Set Background Object
     */
    public void setBackground(Color background) {
        this.panelNivel.setBackground(background);
    }

    /**
     * Set Panel Object
     */
    public void setPanel(JPanel panel, Object borderLayout) {
        this.panelNivel.add(panel, borderLayout);
    }

    /**
     * Set Dimension Object
     */
    public void setPreferredSize(Dimension dimension) {
        this.panelNivel.setPreferredSize(dimension);
    }

    /**
     * Set Opaque Object
     */
    public void setOpaque(boolean isOpaque) {
        this.panelNivel.setOpaque(isOpaque);
    }

    /**
     * Get resulting object
     *
     * @return PanelNivelInicial
     */
    public JPanel getResult() {
        PanelNivel panel = this.panelNivel;
        this.reset();

        return panel;
    }
}
