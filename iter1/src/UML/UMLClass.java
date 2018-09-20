/*
 * This will become a class node in the UML design
 * Inheriting from JComponent gives extra useful features and better organization
*/

package UML;

import java.awt.Color;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Dimension;

public class UMLClass extends JComponent{
    
    private Rectangle rect;
    
    public UMLClass (int x, int y, int width, int height) {
        super();
        this.rect = new Rectangle(x, y, width, height);
    }
    
    // Won't paint unless getPreferredSize() returns something
    @Override
    public Dimension getPreferredSize() {
        if (super.isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(rect.width, rect.height);
    }
    
    @Override
    protected void paintComponent (Graphics g) {
        super.paintComponent(g);
//        Graphics2D g2 = (Graphics2D)g;
        g.setColor(Color.BLACK);
        g.drawRect(rect.x, rect.y, rect.width, rect.height);
        g.fillRect(rect.x, rect.y, rect.width, rect.height);
    }
}
