package object;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.MouseInputAdapter;

public class Editor {

	public static void main(String[] args) {
		JFrame frame = new Window();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(30, 30, 1000, 700);
		frame.setVisible(true);
	}
}

class Window extends JFrame {

	private static final long serialVersionUID = 1L;

	public Window() {
		addMenus();
	}

	public void addMenus() {
		MyPanel myPanel = new MyPanel();
		this.add(myPanel);
	//	this.setLocationRelativeTo(myPanel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

class MyPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public MyPanel() {
		
		this.setLayout(null);
		JTextArea textArea = new JTextArea(10,10);
		JScrollPane j = new JScrollPane(textArea);
		textArea.setText("Y");
	textArea.setBounds(50,50, 50,50);
		j.setBounds(50,50,50,50);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		DragListener drag = new DragListener();
		textArea.addMouseListener(drag);
		textArea.addMouseMotionListener(drag);
		j.setBackground(Color.RED);
		j.addMouseListener(drag);
		j.addMouseMotionListener(drag);
		this.add(j);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	public class DragListener extends MouseInputAdapter {
		Point location;
		MouseEvent pressed;

		public void mousePressed(MouseEvent me) {
			pressed = me;
		}

		public void mouseDragged(MouseEvent me) {
			Component component = me.getComponent();
			location = component.getLocation(location);
			int x = location.x - pressed.getX() + me.getX();
			int y = location.y - pressed.getY() + me.getY();
			component.setLocation(x, y);
		}
	}
}