package interfaz.builder;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;

public interface Builder {
    public void reset();
    public void setLabel(JLabel label);
    public void setLayout(BorderLayout layout);
    public void setBackground(Color background);
    public void setPanel(JPanel panel, Object borderLayout);
    public void setPreferredSize(Dimension dimension);
    public void setOpaque(boolean isOpaque);
    public void setMenu();
    public void setSize(int x, int y);
    public JPanel getResult();
}