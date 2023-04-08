package interfaz.builder;

import javax.swing.JPanel;

public interface Builder {
    public void reset();
    public void setLabels();
    public void setLayout();
    public void setMenu();
    public JPanel getResult();
}