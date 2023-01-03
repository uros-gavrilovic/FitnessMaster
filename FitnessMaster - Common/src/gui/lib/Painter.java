package gui.lib;

import java.awt.Color;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComponent;

public class Painter {
    public static Color LIGHT = new Color(238, 238, 238);
    public static Color DARK = new Color(41, 42, 43);
    public static Color GREEN = new Color(210,217,34);
    
//    public static Color GREEN_TRANSPARENT = new Color(210, 217, 34, 50);
    
     public static void setOnHoverColor(AbstractButton btn) {
          if (!btn.isEnabled()) return;
          
          btn.setBackground(Painter.GREEN);
          btn.setForeground(Painter.DARK);
     }
     public static void setOffHoverColor(AbstractButton btn) {
          if (!btn.isEnabled()) return;
          
          btn.setBackground(Painter.DARK);
          btn.setForeground(Color.WHITE);
     }
}
