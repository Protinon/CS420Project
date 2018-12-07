package action;

import object.Aggregation;
import object.Association;
import object.Composition;
import object.Controller;
import object.Dependency;
import object.Relationship;

public class DeleteRelationshipAction implements Action {
	private Relationship relationshipToDelete;

	private Controller c;

	public DeleteRelationshipAction(Relationship relationshipToDelete, Controller c) {
		this.relationshipToDelete = relationshipToDelete;
		this.c = c;
	}

	public void doAction() {
		relationshipToDelete.getClass1().removeChild(relationshipToDelete.getClass2());
		relationshipToDelete.getClass2().removeParent (relationshipToDelete.getClass1());

		if (relationshipToDelete instanceof Association) {
			c.getAssociations().remove(relationshipToDelete);
		} else if (relationshipToDelete instanceof Aggregation) {
			c.getAggregations().remove(relationshipToDelete);

		} else if (relationshipToDelete instanceof Composition) {
			c.getCompositions().remove(relationshipToDelete);

		} else if (relationshipToDelete instanceof Dependency) {
			c.getDependencies().remove(relationshipToDelete);

		} else {
			c.getGeneralizations().remove(relationshipToDelete);
		}
		
		relationshipToDelete.getClass1().setParentRelated();
		relationshipToDelete.getClass2().setChildRelated();
	}

	public void undoAction() {
		relationshipToDelete.getClass1().setChild(relationshipToDelete.getClass2());
		relationshipToDelete.getClass2().setParent(relationshipToDelete.getClass1());
		relationshipToDelete.getClass1().setParentRelated();
		relationshipToDelete.getClass2().setChildRelated();

		if (relationshipToDelete instanceof Association) {
			c.addAssociation(relationshipToDelete.getClass1(), relationshipToDelete.getClass2(), relationshipToDelete.getChildMultiplicity(), relationshipToDelete.getParentMultiplicity());
		} else if (relationshipToDelete instanceof Aggregation) {
			c.addAggregation(relationshipToDelete.getClass1(), relationshipToDelete.getClass2(), relationshipToDelete.getChildMultiplicity(), relationshipToDelete.getParentMultiplicity());
		} else if (relationshipToDelete instanceof Composition) {
			c.addComposition(relationshipToDelete.getClass1(), relationshipToDelete.getClass2(), relationshipToDelete.getChildMultiplicity(), relationshipToDelete.getParentMultiplicity());
		} else if (relationshipToDelete instanceof Dependency) {
			c.addDependency(relationshipToDelete.getClass1(), relationshipToDelete.getClass2(), relationshipToDelete.getChildMultiplicity(), relationshipToDelete.getParentMultiplicity());
		} else {
			c.addGeneralization(relationshipToDelete.getClass1(), relationshipToDelete.getClass2(), relationshipToDelete.getChildMultiplicity(), relationshipToDelete.getParentMultiplicity());
		}
	}
}
