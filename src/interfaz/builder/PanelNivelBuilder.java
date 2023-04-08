package interfaz.builder;

import javax.swing.JPanel;

import interfaz.InterfazSpaceInvaders;
import interfaz.PanelNivel;
import mundo.Partida;
import mundo.SpaceInvaders;

public class PanelNivelBuilder implements Builder {

    private PanelNivel panelNivel;

    public PanelNivelBuilder() {
        this.panelNivel = new PanelNivel(new Partida("wmarin"), new SpaceInvaders(false), new InterfazSpaceInvaders());
    }

    /**
     * Reset the object
     */
    public void reset() {
        this.panelNivel = new PanelNivel(new Partida("wmarin"), new SpaceInvaders(false), new InterfazSpaceInvaders());
    }

    /**
     * Set the Labels for the Panel
     */
    public void setLabels() {

    }

    /**
     * Set Layout Object
     */
    public void setLayout() {
        this.panelNivel.setSize(640, 480);
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
