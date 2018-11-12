package UML;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InspectorAction implements Action {
	JButton okay;
	JTextField name, atts, ops;
	JLabel nameLabel, attsLabel, opsLabel;
	Class c;
	View v;
	public InspectorAction (Class c, View v) {
		this.v = v;
		this.okay = v.okayButton;
		this.name = v.title;
		this.nameLabel = v.titleLabel;
		this.atts = v.atts;
		this.attsLabel = v.attsLabel;
		this.ops = v.ops;
		this.opsLabel = v.opsLabel;
		this.c = c;
		
	}
	
	public void doAction() {
		okay.setVisible(true);
		nameLabel.setVisible(true);
		name.setText(c.getName());
		name.setVisible(true);
		attsLabel.setVisible(true);
		atts.setText(c.getAttributes());
		atts.setVisible(true);
		opsLabel.setVisible(true);
		ops.setText(c.getOperations());
		ops.setVisible(true);
	}
	
	public void undoAction() {
		RemoveInspectorAction i = new RemoveInspectorAction(c, v);
		i.doAction();
	}
}
