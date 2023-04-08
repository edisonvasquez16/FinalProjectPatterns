package interfaz.builder;

public class Director {

    /**
     * Create and configure a PanelImagenInicial Object
     *
     * @param builder
     */
    public void makePanelImagenInicial(Builder builder) {
        builder.setLabels();
        builder.setLayout();
    }

    /**
     * Create and configure a PanelMenu Object
     *
     * @param builder
     */
    public void makePanelMenu(Builder builder) {
        builder.setLabels();
        builder.setMenu();
        builder.setLayout();
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
