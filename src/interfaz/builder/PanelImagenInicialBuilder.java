package interfaz.builder;

import java.awt.BorderLayout;
import java.awt.Color;

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
     * Set a Label for the Panel
     */
    public void setLabel(JLabel label) {
        this.panelImagenInicial.add(label, BorderLayout.CENTER);
    }

    /**
     * Set Layout Object
     */
    public void setLayout(BorderLayout layout) {
        this.panelImagenInicial.setLayout(layout);
    }

    /**
     * Set Background Object
     */
    public void setBackground(Color background) {
        this.panelImagenInicial.setBackground(background);
    }

    /**
     * Set Panel Object
     */
    public void setPanel(JPanel panel, Object borderLayout) {
        this.panelImagenInicial.add(panel, borderLayout);
    }

    /**
     * Set Menu Object
     */
    public void setMenu() {
      // TODO This Panel does not need a Menu Implementation
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
