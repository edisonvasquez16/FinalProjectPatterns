package interfaz.builder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

import interfaz.InterfazSpaceInvaders;
import interfaz.panelmenu.PanelMenu;

public class PanelMenuBuilder implements Builder {

    private PanelMenu panelMenu;

    public PanelMenuBuilder() {
        this.panelMenu = new PanelMenu();
    }

    /**
     * Reset the object
     */
    public void reset() {
        this.panelMenu = new PanelMenu();
    }

    /**
     * Set a Label for the Panel
     */
    public void setLabel(JLabel label) {
        this.panelMenu.add(label);
    }

    /**
     * Set Layout Object
     */
    public void setLayout(BorderLayout layout) {
        this.panelMenu.setLayout(layout);

    }

    /**
     * Set Dimension Object
     */
    public void setPreferredSize(Dimension dimension) {
        this.panelMenu.setPreferredSize(dimension);
    }

    /**
     * Set Opaque Object
     */
    public void setOpaque(boolean isOpaque) {
        this.panelMenu.setOpaque(isOpaque);
    }

    /**
     * Set Background Object
     */
    public void setBackground(Color background) {
        this.panelMenu.setBackground(background);
    }

    /**
     * Set Panel Object
     */
    public void setPanel(JPanel panel, Object borderLayout) {
        this.panelMenu.add(panel, borderLayout);
    }

    /**
     * Set Size Object
     */
    public void setSize(int x, int y) {
        this.panelMenu.setSize(x, y);
    }

    /**
     * Get resulting object
     *
     * @return PanelNivelInicial
     */
    public JPanel getResult() {
        PanelMenu panel = this.panelMenu;
        this.reset();

        return panel;
    }
}
