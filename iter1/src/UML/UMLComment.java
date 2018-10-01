package UML;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class UMLComment extends JComponent{
    
    public UMLComment(int x, int y) {
        super.setBounds(new Rectangle(x, y, 500,500));
        super.setLocation(x, y);
       
        UMLMouseListener listener = new UMLMouseListener();
        super.addMouseListener(listener);
        super.addMouseMotionListener(listener);
    }

    @Override
    protected void paintComponent (Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
   
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3));
        g2.drawLine(0,0, 0, 200);
        g2.drawLine(0, 0, 150, 0);
        g2.setStroke(new BasicStroke(2));
        g2.drawLine(0, 200, 200, 200);
        g2.drawLine(200, 200, 200, 50);
        g2.drawLine(150, 0, 150, 50);
        g2.drawLine(150, 50, 200,50);
        g2.drawLine(150, 0, 200, 50);
    }
}
