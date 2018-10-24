/*
 * This will become a class node in the UML design
 * Inheriting from JComponent gives extra useful features and better organization
*/
package UML;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.BorderFactory; 
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.RenderingHints;

public class UMLClass extends JComponent{
    
    // Space between text and class edge
    private int Border;
    // Space between consecutive lines
    private int lineHeight;
    // Displayed text
    private String name;
    private String atts;
    private Font font;
    private Dimension fontSize;
    
    public UMLClass(int x, int y) {
        this(x, y, 10, 3);
    }
    
    public UMLClass (int x, int y, int border, int lineHeight) {
        // Initilize JComponent
        // "super" is a special keyword used in inheritance to specify the parent class
        super();
        
        // Font stays static
        // Font dimensions is not calculated at run-time, must be set here
        // For ease of use, font should be monospaced
        this.font = new Font("Monospaced", Font.PLAIN, 12);
        this.fontSize = new Dimension(7, 13);
        
        this.Border = border;
        this.lineHeight = lineHeight;
        
        // Previously used a Rectangle to store this node's position and dimensions
        // Now uses JComponent's built-in coordinate managment
        // Update height and width with setBounds()
        // Update location with setLocation()
        // Get respective values with getX(), getY(), getWidth(), getHeight()
        super.setBounds(new Rectangle(x, y, border * 2, border * 2));
        super.setLocation(x, y);
        
        super.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
        
        // Allows for node to be dragged with mouse
        UMLMouseListener listener = new UMLMouseListener();
        //super.addMouseListener(listener);
        //super.addMouseMotionListener(listener);
    }
    
    // "Paint" the UMLClass - draw it on the screen
    // java.swing decides when to call this
    @Override
    protected void paintComponent (Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setFont(font);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Keep y position so we know where to draw next
        // Increment as you draw
        int drawPosY = fontSize.height + Border;
        
        // Draw Rectangle
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, getWidth(), getHeight());
        
        // Draw Title
        g2.setColor(Color.BLUE); 
        int offset = getWidth() / 2 - (name.length() * fontSize.width) / 2;
        g2.drawString(name, offset, drawPosY);
        
        // Draw Divider
        drawPosY += lineHeight;
        // Line overextends by 1 pixel for some reason...
        g2.drawLine(0, drawPosY, getWidth() - 1, drawPosY);
        
        // Draw Attributes
        drawPosY += fontSize.height + lineHeight;
        for (String att : atts.split(", ")) {
            g.drawString(att, Border, drawPosY);
            drawPosY += fontSize.height + lineHeight;
        }
    }
    
    // Find the dimensions of the rectagle to fit the strings
    // For width, find the string with max length
    // For Height, find combined height of all text and dividers
    private Dimension fitStrs() {
        // Width
        int width = 0;
        for (String str : atts.split(", ")) {
            if (str.length() > width) {
                width = str.length();
            }
        }
        width = width * fontSize.width;
        // Add border for sides
        width += Border * 2;
        
        // Height
        // There is always a title, so add that
        int height = Border * 2 + fontSize.height;
        
        // Divider
        height += lineHeight * 2;
        
        // Attributes
        for (String str : atts.split(", ")) {
            height += fontSize.height + lineHeight;
        }
        return new Dimension(width, height);
    }
    
    public void setInfo(String name, String atts) {
        this.name = name;
        this.atts = atts;
        Dimension size = fitStrs();
        setBounds(new Rectangle(getX(), getY(), size.width, size.height));
    }
}