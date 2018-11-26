package UML;

import java.util.ArrayList;

public class AddAggregationAction implements Action {
	private ArrayList<Aggregation> aggregations;

	private Class parent;
	private Class child;

	private Relationship selectedRelationship;
	
	public AddAggregationAction (Class c1, Class c2, Relationship selectedRelationship, ArrayList<Aggregation> aggregations, Canvas rightPane) {
		this.aggregations = aggregations;
		this.parent = c1;
		this.child = c2;
		this.selectedRelationship = selectedRelationship;
	}

	public void doAction() {
		if (parent != null && child != null) {
			Aggregation agg = new Aggregation(parent, child);
			aggregations.add(agg);
			parent.setParentRelated(true);
			parent.setChild(child);
			child.setChildRelated(true);
			child.setParent(parent);
			selectedRelationship = agg;
		}
	}

	public void undoAction() {
		aggregations.remove(parent);
		aggregations.remove(child);
	}
}
