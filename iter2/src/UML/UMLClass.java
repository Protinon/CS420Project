/*
 * This will become a class node in the UML design
 * Inheriting from JComponent gives extra useful features and better organization
*/
package UML;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.BorderFactory; 
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import java.awt.Graphics;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.RenderingHints;
import java.awt.Shape;

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
        super.addMouseListener(listener);
        super.addMouseMotionListener(listener);
       
    }
    
    // "Paint" the UMLClass - draw it on the screen
    // java.swing decides when to call this
    @Override
    protected void paintComponent (Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setFont(font);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Third box in place for attributes
        Graphics2D g3 = (Graphics2D)g;
        g3.setFont(font);
        g3.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Keep y position so we know where to draw next
        // Increment as you draw
        int drawPosY = fontSize.height + Border;
        
        // Draw "Class Name" box
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, getWidth(), (drawPosY += lineHeight)); 
        
        // Input "Class Title" into box. Incorporates 
        //   use of JOptionPane to populate the text
        g2.setColor(Color.BLACK); 
        int offset = getWidth() / 2 - (name.length() * fontSize.width) / 2;
        // *NOTE* JOptionPane is still being called twice for this box! Should only 
        //    be called once! Debugging still needed to rectify this issue
        String text = (String) JOptionPane.showInputDialog(g2, "Class");
        // If user does not enter any text, default string is put in place
        if (text == null || text.isEmpty()) {
            text = "Class";
        }
        g2.drawString(text, offset, drawPosY);
        
        // Draw a divider between "Class" and "Attributes"
        drawPosY += lineHeight;
        // Line overextends by 1 pixel for some reason...
        g2.drawLine(0, drawPosY, getWidth() - 1, drawPosY);
        
        // Draw "Attributes" box below divider
        g3.setColor(Color.WHITE);
        g3.fillRect(0, drawPosY + 1, getWidth(), (drawPosY += lineHeight));
        
        // Edit text in the "Attributes" box. Incorporates the 
        // 	use of JOptionPane to populate the text
        g3.setColor(Color.BLACK);
        drawPosY += fontSize.height + lineHeight;
        // *NOTE* JOptionPane is still being called twice for this box! Should only 
        //    be called once! Debugging still needed to rectify this issue
        String att = (String) JOptionPane.showInputDialog(g3, "Attributes");
        // If user does not enter text, default string is put in place
        if (att == null || text.isEmpty()) {
            att = "Attributes";
        }
        g3.drawString(att, Border, drawPosY);
        drawPosY += fontSize.height + lineHeight;
        
        // Draw a divider under attributes box
        drawPosY += lineHeight;
        // Line overextends by 1 pixel for some reason...
        g2.drawLine(0, drawPosY, getWidth() - 1, drawPosY);
        
        /*
        // Draw Class box text (Original fixed-text version)
        drawPosY += fontSize.height + lineHeight;
        for (String att : atts.split(", ")) {
            g.drawString(att, Border, drawPosY);
            drawPosY += fontSize.height + lineHeight;
        }
        */
        
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