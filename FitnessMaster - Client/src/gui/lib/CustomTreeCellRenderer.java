package gui.lib;

import java.awt.Color;
import gui.lib.Painter;
import javax.swing.tree.DefaultTreeCellRenderer;

public class CustomTreeCellRenderer extends DefaultTreeCellRenderer {
    @Override
    public Color getBackgroundSelectionColor() {
        return Painter.GREEN;
    }

//    @Override
//    public Color getBackground() {
//        return (null);
//    }
//
//    @Override
//    public Component getTreeCellRendererComponent(final JTree tree, final Object value, final boolean sel, final boolean expanded, final boolean leaf, final int row, final boolean hasFocus) {
//        final Component ret = super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
//
//        final DefaultMutableTreeNode node = ((DefaultMutableTreeNode) (value));
//        this.setText(value.toString());
//        return ret;
//    }
}