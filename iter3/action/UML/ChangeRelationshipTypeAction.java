package UML;

public class ChangeRelationshipTypeAction implements Action {
	private Controller c;
	private View v;
	private Relationship selectedRelationship;
	String newRelationship;

	public ChangeRelationshipTypeAction (Controller c, View v) {
		this.c = c;
		this.v = v;
		this.selectedRelationship = c.getSelectedRelationship();
		this.newRelationship = v.relationshipTypes.getSelectedItem().toString();
	}

	public void doAction() {
		if (selectedRelationship != null) {
			if (selectedRelationship instanceof Association) {
			} else if (selectedRelationship instanceof Aggregation) {
				if (newRelationship == "Association") {
					c.addAssociation(selectedRelationship.getClass1(), selectedRelationship.getClass2());
					c.getAggregations().remove(selectedRelationship);
				} else if (newRelationship == "Composition") {
					c.addComposition(selectedRelationship.getClass1(), selectedRelationship.getClass2());
					c.getAggregations().remove(selectedRelationship);
				} else if (newRelationship == "Dependency") {
					c.addDependency(selectedRelationship.getClass1(), selectedRelationship.getClass2());
					c.getAggregations().remove(selectedRelationship);
				} else if (newRelationship == "Generalization") {
					c.addGeneralization(selectedRelationship.getClass1(), selectedRelationship.getClass2());
					c.getAggregations().remove(selectedRelationship);
				}
			} else if (selectedRelationship instanceof Composition) {
				if (newRelationship == "Association") {
					c.addAssociation(selectedRelationship.getClass1(), selectedRelationship.getClass2());
					c.getCompositions().remove(selectedRelationship);
				} else if (newRelationship == "Aggregation") {
					c.addAggregation(selectedRelationship.getClass1(), selectedRelationship.getClass2());
					c.getCompositions().remove(selectedRelationship);
				} else if (newRelationship == "Dependency") {
					c.addDependency(selectedRelationship.getClass1(), selectedRelationship.getClass2());
					c.getCompositions().remove(selectedRelationship);
				} else if (newRelationship == "Generalization") {
					c.addGeneralization(selectedRelationship.getClass1(), selectedRelationship.getClass2());
					c.getCompositions().remove(selectedRelationship);
				}
			} else if (selectedRelationship instanceof Dependency) {
				if (newRelationship == "Association") {
					c.addAssociation(selectedRelationship.getClass1(), selectedRelationship.getClass2());
					c.getDependencies().remove(selectedRelationship);
				} else if (newRelationship == "Aggregation") {
					c.addAggregation(selectedRelationship.getClass1(), selectedRelationship.getClass2());
					c.getDependencies().remove(selectedRelationship);
				} else if (newRelationship == "Composition") {
					c.addComposition(selectedRelationship.getClass1(), selectedRelationship.getClass2());
					c.getDependencies().remove(selectedRelationship);
				} else if (newRelationship == "Generalization") {
					c.addGeneralization(selectedRelationship.getClass1(), selectedRelationship.getClass2());
					c.getDependencies().remove(selectedRelationship);
				}
			} else {
				if (newRelationship == "Association") {
					c.addAssociation(selectedRelationship.getClass1(), selectedRelationship.getClass2());
					c.getGeneralizations().remove(selectedRelationship);
				} else if (newRelationship == "Aggregation") {
					c.addAggregation(selectedRelationship.getClass1(), selectedRelationship.getClass2());
					c.getGeneralizations().remove(selectedRelationship);
				} else if (newRelationship == "Composition") {
					c.addComposition(selectedRelationship.getClass1(), selectedRelationship.getClass2());
					c.getGeneralizations().remove(selectedRelationship);
				} else if (newRelationship == "Dependency") {
					c.addDependency(selectedRelationship.getClass1(), selectedRelationship.getClass2());
					c.getGeneralizations().remove(selectedRelationship);
				}
			}
		}
	}
	
	public void undoAction() {
		
	}
}