package interfaz.builder;

import javax.swing.JPanel;

import interfaz.InterfazSpaceInvaders;
import interfaz.PanelNivel;
import mundo.Partida;
import mundo.SpaceInvaders;

public class PanelNivelBuilder implements Builder {

    private PanelNivel panelNivel;

    public PanelNivelBuilder() {
        this.panelNivel = new PanelNivel(new Partida(""), new SpaceInvaders(false), new InterfazSpaceInvaders());
    }

    /**
     * Reset the object
     */
    public void reset() {
        this.panelNivel = new PanelNivel(new Partida(""), new SpaceInvaders(false), new InterfazSpaceInvaders());
    }

    /**
     * Set Layout Object
     */
    public void setLayout(BorderLayout layout) {
        this.panelImagenInicial.setLayout(layout);
    }

    /**
     * Set Size Object
     */
    public void setSize(x, y) {
        this.panelImagenInicial.setSize(x, y);
    }

    /**
     * Set Menu Object
     */
    public void setMenu() {

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
