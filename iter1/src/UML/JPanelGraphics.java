/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author lukas
 */
public class JPanelGraphics extends JPanel {
    
    public void paint(Graphics g) {
        g.drawLine(10, 10, 200, 300);
    }
}
