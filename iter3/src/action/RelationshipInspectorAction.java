package action;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import object.Aggregation;
import object.Association;
import object.Class;
import object.Composition;
import object.Dependency;
import object.Relationship;
import object.View;

public class RelationshipInspectorAction implements Action {
	private JButton okayButton;

	private Class parent;
	private Class child;

	private View v;

	private JCheckBox directionChange;

	private JComboBox<String> relationshipTypes;

	private String[] relationships;

	private Relationship relationship;

	private JTextField pMultiplicity, cMultiplicity;

	private JLabel pMultiplicityLabel;
	private JLabel cMultiplicityLabel;

	public RelationshipInspectorAction(Class parent, Class child, Relationship r, View vl) {
		this.parent = parent;
		this.child = child;

		this.v = vl;

		this.relationshipTypes = vl.relationshipTypes;

		this.okayButton = vl.rOkayButton;

		this.relationship = r;

		this.relationships = vl.relationships;

		this.directionChange = vl.directionChange;

		this.pMultiplicityLabel = vl.pMultiplicityLabel;
		this.cMultiplicityLabel = vl.cMultiplicityLabel;

		this.pMultiplicity = vl.pMultiplicity;
		this.cMultiplicity = vl.cMultiplicity;
	}

	public void doAction() {
		relationshipTypes.setVisible(true);
		if (relationship instanceof Association) {
			relationshipTypes.setSelectedItem(relationships[0]);
		} else if (relationship instanceof Aggregation) {
			relationshipTypes.setSelectedItem(relationships[1]);
		} else if (relationship instanceof Composition) {
			relationshipTypes.setSelectedItem(relationships[2]);
		} else if (relationship instanceof Dependency) {
			relationshipTypes.setSelectedItem(relationships[3]);
		} else {
			relationshipTypes.setSelectedItem(relationships[4]);
		}
		
		cMultiplicity.setText(relationship.getChildMultiplicity());
		pMultiplicity.setText(relationship.getParentMultiplicity());
		okayButton.setVisible(true);
		directionChange.setVisible(true);
		pMultiplicity.setVisible(true);
		cMultiplicity.setVisible(true);
		pMultiplicityLabel.setVisible(true);
		cMultiplicityLabel.setVisible(true);
	}

	@Override
	public void undoAction() {
		RemoveRelationshipInspectorAction i = new RemoveRelationshipInspectorAction(parent, child, relationship, v);
		i.doAction();
	}
}
