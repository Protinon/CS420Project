package UML;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RelationshipInspectorAction implements Action {
	private JButton okay;
	private Class parent, child;
	private View v;
	private JCheckBox direction;
	private JComboBox<String> relationships;
	private String[] relats;
	private Relationship relate;
	private JTextField parentM, childM;
	private JLabel pMultiplicity, cMultiplicity;
	public RelationshipInspectorAction(Class parent, Class child, Relationship r, View vl) {
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
		relationships.setVisible(true);
		if (relate instanceof Association) {
			relationships.setSelectedItem(relats[0]);
		} else if (relate instanceof Aggregation) {
			relationships.setSelectedItem(relats[1]);
		} else if (relate instanceof Composition) {
			relationships.setSelectedItem(relats[2]);
		} else if (relate instanceof Dependency) {
			relationships.setSelectedItem(relats[3]);
		} else {
			relationships.setSelectedItem(relats[4]);
		}
		okay.setVisible(true);
		direction.setVisible(true);
		pMultiplicity.setVisible(true);
		cMultiplicity.setVisible(true);
		parentM.setVisible(true);
		childM.setVisible(true);
	}

	@Override
	public void undoAction() {
		RemoveRelationshipInspectorAction i = new RemoveRelationshipInspectorAction(parent,child, relate, v);
		i.doAction();
	}
}
