package action;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import UML.Class;
import UML.View;

public class RemoveInspectorAction implements Action {
	private JButton okay;

	private JTextField name;
	private JTextField atts;
	private JTextField ops;

	private JLabel nameLabel;
	private JLabel attsLabel;
	private JLabel opsLabel;

	private Class c;

	private View v;

	public RemoveInspectorAction(Class c, View v) {
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
		okay.setVisible(false);
		nameLabel.setVisible(false);
		name.setVisible(false);
		attsLabel.setVisible(false);
		atts.setVisible(false);
		opsLabel.setVisible(false);
		ops.setVisible(false);
	}

	public void undoAction() {
		InspectorAction i = new InspectorAction(c, v);
		i.doAction();
	}
}
