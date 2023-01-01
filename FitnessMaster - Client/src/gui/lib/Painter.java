package gui.lib;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComponent;

public class Painter {
    public static Color LIGHT = new Color(238, 238, 238);
    public static Color DARK = new Color(41, 42, 43);
    public static Color GREEN = new Color(210,217,34);
    
        public static void setOnHoverColor(JButton btn) {
        if (!btn.isEnabled()) return;
        btn.setBorder(javax.swing.BorderFactory.createLineBorder(Painter.DARK, 3));
        btn.setBackground(Painter.GREEN);
        btn.setForeground(Painter.DARK);
    }

    public static void setOffHoverColor(JButton btn) {
        if (!btn.isEnabled()) return;
        btn.setBorder(javax.swing.BorderFactory.createLineBorder(Painter.LIGHT, 3));
        btn.setBackground(Painter.DARK);
        btn.setForeground(Painter.LIGHT);
    }
}
