package gui.lib;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JToggleButton;

public class CustomDarkToggleButton extends JToggleButton {
    private boolean over;
    private Color backgroundColor;
    private Color foregroundColor;
    private Color colorOver;
    private Color colorClick;
    private Color borderColor;
    private int radius = 0;
     
    public CustomDarkToggleButton() {
        setBackgroundColor(Painter.DARK);
        setForegroundColor(Color.WHITE);
        setBorder(new javax.swing.border.LineBorder(Painter.DARK, 3, true));
        setFocusable(false);
        
        colorOver = Painter.GREEN;
        colorClick = new Color(152, 184, 144);
        borderColor = Painter.DARK;
        setContentAreaFilled(false);
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                 setBackground(colorOver);
                 setForeground(Painter.DARK);
                 over = true;
            }
            @Override
            public void mouseExited(MouseEvent me) {
                  setBackground(backgroundColor);
                  setForeground(Color.WHITE);
                  over = false;
             }
            @Override
            public void mousePressed(MouseEvent me) {
                setBackground(colorClick);
            }
            @Override
            public void mouseReleased(MouseEvent me) {
                if (over) {
                    setBackground(colorOver);
                } else {
                    setBackground(backgroundColor);
                }
            }
        });
    }
     
    public boolean isOver() {
        return over;
    }
    public void setOver(boolean over) {
        this.over = over;
    }
    public Color getBackgroundColor() {
        return backgroundColor;
    }
    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
        setBackground(color);
    }
    public Color getColorOver() {
        return colorOver;
    }
    public void setColorOver(Color colorOver) {
        this.colorOver = colorOver;
    }
    public Color getColorClick() {
        return colorClick;
    }
    public void setColorClick(Color colorClick) {
        this.colorClick = colorClick;
    }
    public Color getBorderColor() {
        return borderColor;
    }
    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }
    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Color getForegroundColor(){
         return foregroundColor;
    }
    public void setForegroundColor(Color color){
         this.foregroundColor = color;
         setForeground(color);
    }
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //  Paint Border
        g2.setColor(borderColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        g2.setColor(getBackground());
        //  Border set 2 Pix
        g2.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, radius, radius);
        super.paintComponent(grphcs);
    }
}