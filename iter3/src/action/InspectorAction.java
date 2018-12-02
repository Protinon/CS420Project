package action;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import object.Class;
import object.View;

public class InspectorAction implements Action {
	private JButton okay;

	private JTextArea name;
	private JTextArea atts;
	private JTextArea ops;

	private JLabel nameLabel;
	private JLabel attsLabel;
	private JLabel opsLabel;

	private Class c;

	private View v;

	public InspectorAction(Class c, View v) {
		this.v = v;
		this.okay = v.classOkayButton;
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
