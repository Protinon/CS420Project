/*
 * This will become a class node in the UML design
 * Inheriting from JComponent gives extra useful features and better organization
*/
package UML;

import java.awt.Color;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.RenderingHints;

public class UMLClass extends JComponent{
    
    int posX, posY;
    private String name;
    private String atts;
    private Font font;
    private int Border;
    private int lineHeight;
    
    public UMLClass(int x, int y) {
        this(x, y, 10, 3);
    }
    
    public UMLClass (int x, int y, int border, int lineHeight) {
        // Initilize JComponent
        // "super" is a special keyword used in inheritance to specify the parent class
        super();
        font = new Font("Monospaced", Font.PLAIN, 12);
        this.Border = border;
        this.lineHeight = lineHeight;
        this.posX = x;
        this.posY = y;
    }
    
    // Won't paint unless getPreferredSize() returns something
    // Not sure why
    // Currently set to fit entire window, will have to update with window size?
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 800);
    }
    
    // "Paint" the UMLClass, draw it on the screen
    @Override
    protected void paintComponent (Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setFont(font);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        

        FontMetrics fm = g2.getFontMetrics();
        Dimension rect = fitStrs(fm);
        
        // Get height of font, getAscent() is mostly accurate
        // Still some leading pixels on top, find more accurate method
        int fontHeight = fm.getAscent();
        // Keep y position so we know where to draw next
        // Increment as you draw
        int drawPosY = posY + fontHeight + Border;
        
        // Draw Rectangle
        g2.setColor(Color.BLACK);
        g2.fillRect(posX, posY, rect.width, rect.height);
        g2.setColor(Color.WHITE);
        g2.fillRect(posX + 2, posY + 2, rect.width - 4, rect.height - 4);
        
        // Draw Title
        g2.setColor(Color.BLUE); 
        int offset = rect.width / 2 - fm.stringWidth(name) / 2;
        g2.drawString(this.name, posX + offset, drawPosY);
        
        // Draw Divider
        drawPosY += lineHeight;
        // Line draws 1 pixel longer on the right for some reason...
        g2.drawLine(posX, drawPosY, posX + rect.width - 1, drawPosY);
        
        // Draw Attributes
        drawPosY += fontHeight + lineHeight;
        for (String att : this.atts.split(", ")) {
            g.drawString(att, posX + Border, drawPosY);
            drawPosY += fontHeight + lineHeight;
        }
    }
    
    // Find the dimensions of the rectagle to fit the strings
    // For width, find the string with max length
    // For Height, find combined height of all text and dividers
    private Dimension fitStrs(FontMetrics fm) {
        // Width
        int width = 0;
        for (String str : atts.split(", ")) {
            if (fm.stringWidth(str) > width) {
                width = fm.stringWidth(str);
            }
        }
        // Add border for sides
        width += Border * 2;
        
        // Height
        // There is always a title, so add that
        int fontHeight = fm.getAscent();
        int height = Border * 2 + fontHeight;
        
        // Divider
        height += lineHeight * 2;
        
        // Attributes
        for (String str : atts.split(", ")) {
            height += fontHeight + lineHeight;
        }
        return new Dimension(width, height);
    }
    
    public void setInfo(String name, String atts) {
        this.name = name;
        this.atts = atts;
    }
}
