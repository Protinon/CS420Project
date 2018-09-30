/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import java.awt.event.*;

public class UMLMouseListener extends MouseAdapter {
    
    // Position on the monitor
    int monitorX;
    int monitorY;
    
    // Position of the component
    int cmpX;
    int cmpY;

    @Override
    public void mousePressed(MouseEvent e) {
        monitorX = e.getXOnScreen();
        monitorY = e.getYOnScreen();

        cmpX = e.getComponent().getX();
        cmpY = e.getComponent().getY();
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        int deltaX = e.getXOnScreen() - monitorX;
        int deltaY = e.getYOnScreen() - monitorY;

        e.getComponent().setLocation(cmpX + deltaX, cmpY + deltaY);
    }
      
}
