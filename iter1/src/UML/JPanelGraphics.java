/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import java.awt.Graphics;
import javax.swing.JPanel;


public class JPanelGraphics extends JPanel {

    private final Points m_points;
    
    public JPanelGraphics() {
        // Initilize JPanel
        super();
        // Do our initilization of JPanelGraphics
        m_points = new Points();
    }
    
    public void paint(Graphics g) {
        // Necessary if we were drawing other components, like buttons
        super.paint(g);
        // Draw our graphics
        m_points.drawPoints(g);
    }
}
