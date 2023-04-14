package interfaz.builder;

import java.awt.*;

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
        this.panelImagenInicial = new PanelImagenInicial();
    }

    /**
     * Reset the object
     */
    public void reset() {
        this.panelImagenInicial = new PanelImagenInicial();
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
     * Set Dimension Object
     */
    public void setPreferredSize(Dimension dimension) {
        this.panelImagenInicial.setPreferredSize(dimension);
    }

    /**
     * Set Opaque Object
     */
    public void setOpaque(boolean isOpaque) {
        this.panelImagenInicial.setOpaque(isOpaque);
    }

    /**
     * Set Size Object
     */
    public void setSize(int x, int y) {
        this.panelImagenInicial.setSize(x, y);
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
