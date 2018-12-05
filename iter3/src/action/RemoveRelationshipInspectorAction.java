package action;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import object.Class;
import object.Relationship;
import object.View;

public class RemoveRelationshipInspectorAction implements Action {
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

	public RemoveRelationshipInspectorAction(Class parent, Class child, Relationship r, View vl) {
		this.parent = parent;
		this.child = child;

		this.v = vl;

		this.relationshipTypes = vl.relationshipTypes;

		this.okayButton = vl.okayButton;

		this.relationship = r;

		this.relationships = vl.relationships;

		this.directionChange = vl.directionChange;

		this.pMultiplicityLabel = vl.pMultiplicityLabel;
		this.cMultiplicityLabel = vl.cMultiplicityLabel;

		this.pMultiplicity = vl.pMultiplicity;
		this.cMultiplicity = vl.cMultiplicity;
	}

	public void doAction() {
		relationshipTypes.setVisible(false);
		okayButton.setVisible(false);
		directionChange.setVisible(false);
		pMultiplicityLabel.setVisible(false);
		cMultiplicityLabel.setVisible(false);
		pMultiplicity.setVisible(false);
		cMultiplicity.setVisible(false);
	}

	@Override
	public void undoAction() {
		RemoveRelationshipInspectorAction i = new RemoveRelationshipInspectorAction(parent, child, relationship, v);
		i.doAction();
	}
}