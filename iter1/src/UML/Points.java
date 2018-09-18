/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import java.awt.Graphics;
import java.util.ArrayList;
    
public class Points {
    
    // Struct to hold point information
    final class Point {
        int x;
        int y;
    }
    
    // Dynamic array to hold all points
    private ArrayList<Point> m_points;
    
    public void drawPoints(Graphics g) {
        g.drawLine(10, 10, 200, 300);
        g.drawOval(100, 100, 5, 5);
        g.fillOval(100, 100, 5, 5);
        
        // This SHOULD draw all points, but causes weird effects on UI
        // Maybe has to do with default ArrayList constructor?
        /*for (Point tmp : m_points) {
            g.drawOval(tmp.x, tmp.y, 5, 5);
        }*/
    }
    
    // Not tested yet
    /*
    public void addPoint(int x, int y) {
        Point p;
        p.x = x;
        p.y = y;
        m_points.add(p);
    }
*/
}
