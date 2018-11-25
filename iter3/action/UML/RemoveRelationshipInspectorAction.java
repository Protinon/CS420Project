package UML;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RemoveRelationshipInspectorAction implements Action {
	private JButton okay;
	private Class parent, child;
	private View v;
	private JCheckBox direction;
	private JComboBox<String> relationships;
	private String[] relats;
	private Relationship relate;
	private JTextField parentM, childM;
	private JLabel pMultiplicity, cMultiplicity;
	public RemoveRelationshipInspectorAction(Class parent, Class child, Relationship r, View vl) {
		this.parent = parent;
		this.child = child;
		this.v = vl;
		this.relationships = vl.cb;
		this.okay =vl.rOkayButton;
		this.relate = r;
		relats = vl.choices;
		this.direction = vl.directionChange;
		this.pMultiplicity = vl.parentMultiplicity;
		this.cMultiplicity = vl.childMultiplicity;
		this.parentM = vl.parentM;
		this.childM = vl.childM;
	}
	
	public void doAction() {
		relationships.setVisible(false);
		okay.setVisible(false);
		direction.setVisible(false);
		pMultiplicity.setVisible(false);
		cMultiplicity.setVisible(false);
		parentM.setVisible(false);
		childM.setVisible(false);
	}

	@Override
	public void undoAction() {
		RemoveRelationshipInspectorAction i = new RemoveRelationshipInspectorAction(parent,child, relate, v);
		i.doAction();
	}
}