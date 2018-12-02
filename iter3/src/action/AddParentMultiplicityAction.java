package action;
import object.Relationship;

public class AddParentMultiplicityAction implements Action {
	private String mult;
	private Relationship selectedRelationship;
	public AddParentMultiplicityAction(String mult, Relationship selectedRelationship) {
		this.mult = mult;
		this.selectedRelationship = selectedRelationship;
	}

	@Override
	public void doAction() {
		String temp = mult;
		mult = selectedRelationship.getParentMultiplicity();
		selectedRelationship.setParentMultiplicity(temp);

	}

	@Override
	public void undoAction() {
		String temp = mult;
		mult = selectedRelationship.getParentMultiplicity();
		selectedRelationship.setParentMultiplicity(temp);

	}
}
