package gui.lib;

import javax.swing.ImageIcon;
import java.awt.Image;

public class ImageResizer {
    public ImageIcon resize(ImageIcon icon, int height, int width){
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newImage);
    }
}
