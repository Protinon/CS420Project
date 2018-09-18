package UML;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

public class Printer implements Printable 
{
    final Component comp;

    public Printer(Component component)
    {
        comp = component;
    }

    @Override
    public int print(Graphics g, PageFormat format, int page_index) 
            throws PrinterException 
    {
        if (page_index > 0) 
        {
            return Printable.NO_SUCH_PAGE;
        }

        Dimension d = comp.getSize();
        double compHeight = d.getHeight();
        double compWidth = d.getWidth();

        double pHeight = format.getImageableHeight();
        double pWidth = format.getImageableWidth();

        double pXStart = format.getImageableX();
        double pYStart = format.getImageableY();

        double xRatio = pWidth / compWidth;
        double yRatio = pHeight / compHeight;

        Graphics2D g2 = (Graphics2D) g;
        g2.translate(pXStart, pYStart);
        g2.scale(xRatio, yRatio);
        comp.paint(g2);

        return Printable.PAGE_EXISTS;
    }
}
