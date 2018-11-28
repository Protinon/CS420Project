package action;

import UML.*;

public class DeleteRelationshipAction implements Action {
	private Relationship relationshipToDelete;

	private Controller c;

	public DeleteRelationshipAction(Relationship relationshipToDelete, Controller c) {
		this.relationshipToDelete = relationshipToDelete;
		this.c = c;
	}

	public void doAction() {
		relationshipToDelete.getClass1().setParentRelated(false);
		relationshipToDelete.getClass1().setChild(null);
		relationshipToDelete.getClass2().setChildRelated(false);
		relationshipToDelete.getClass2().setParent(null);

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
	}

	public void undoAction() {
		relationshipToDelete.getClass1().setParentRelated(true);
		relationshipToDelete.getClass1().setChild(relationshipToDelete.getClass2());
		relationshipToDelete.getClass2().setChildRelated(true);
		relationshipToDelete.getClass2().setParent(relationshipToDelete.getClass1());

		if (relationshipToDelete instanceof Association) {
			c.getAssociations().add((Association) relationshipToDelete);
		} else if (relationshipToDelete instanceof Aggregation) {
			c.getAggregations().add((Aggregation) relationshipToDelete);

		} else if (relationshipToDelete instanceof Composition) {
			c.getCompositions().add((Composition) relationshipToDelete);

		} else if (relationshipToDelete instanceof Dependency) {
			c.getDependencies().add((Dependency) relationshipToDelete);

		} else {
			c.getGeneralizations().add((Generalization) relationshipToDelete);
		}
	}
}
