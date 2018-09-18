/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import java.awt.Graphics;
import javax.swing.JPanel;


public class JPanelGraphics extends JPanel {

    private Points m_points;
    
    public JPanelGraphics() {
        super();
        m_points = new Points();
    }
    
    public void paint(Graphics g) {
        m_points.drawPoints(g);
    }
}
