package Relationship;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.Component;
import UML.UMLClass;

public class Updater implements ComponentListener {
	
	Relationship relationship;
	
	public Updater(Relationship rel) {
		this.relationship = rel;
	}
	
	private void update(ComponentEvent e) {
		Component cmp = e.getComponent();
		if (cmp instanceof UMLClass) {
			relationship.updatePosition((UMLClass)cmp);
		}
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		update(e);
	}

	@Override
	public void componentResized(ComponentEvent e) {
		update(e);
	}

	@Override
	public void componentShown(ComponentEvent e) {
		
	}

}
