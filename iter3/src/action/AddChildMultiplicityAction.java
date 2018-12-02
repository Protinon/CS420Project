package action;

import object.Relationship;

public class AddChildMultiplicityAction implements Action {
	private String mult;
	private Relationship selectedRelationship;
	public AddChildMultiplicityAction(String mult, Relationship selectedRelationship) {
		this.mult = mult;
		this.selectedRelationship = selectedRelationship;
	}

	@Override
	public void doAction() {
		String temp = mult;
		mult = selectedRelationship.getChildMultiplicity();
		selectedRelationship.setChildMultiplicity(temp);

	}

	@Override
	public void undoAction() {
		String temp = mult;
		mult = selectedRelationship.getChildMultiplicity();
		selectedRelationship.setChildMultiplicity(temp);

	}
}
