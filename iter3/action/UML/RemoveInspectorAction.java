package UML;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RemoveInspectorAction implements Action{
	JButton okay;
	JTextField name, atts, ops;
	JLabel nameLabel, attsLabel, opsLabel;
	Class c;
	View v;
	public RemoveInspectorAction (Class c, View v) {
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
