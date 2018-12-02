package object;
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

public class TestTextArea extends JFrame {

    public TestTextArea() {
    	JPanel p = new JPanel();
        p.setLayout(new SpringLayout());

        JTextArea textArea = new JTextArea();
        textArea.setColumns(10);
        textArea.setRows(1);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        p.add(textArea);
        textArea.setLocation(0,0);
        p.setBackground(Color.RED);
        p.setSize(200, 200);
        add(p);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        textArea.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent ce) {

                System.out.println("I've changed size");

            }

        });

    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new TestTextArea();
    }

}