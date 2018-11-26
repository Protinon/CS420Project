package UML;

import java.util.ArrayList;

public class AddAggregationAction implements Action {
	private ArrayList<Aggregation> aggregations;

	private Class parent;
	private Class child;

	private String childM;
	private String parentM;

	public AddAggregationAction(Class c1, Class c2, ArrayList<Aggregation> aggregations, String childM,
			String parentM) {
		this.aggregations = aggregations;
		this.parent = c1;
		this.child = c2;
		this.childM = childM;
		this.parentM = parentM;
	}

	public void doAction() {
		if (parent != null && child != null) {
			Aggregation cl = new Aggregation(parent, child);
			aggregations.add(cl);
			cl.setChildMultiplicity(childM);
			cl.setParentMultiplicity(parentM);
			parent.setParentRelated(true);
			parent.setChild(child);
			child.setChildRelated(true);
			child.setParent(parent);
		}
	}

	public void undoAction() {
		aggregations.remove(parent);
		aggregations.remove(child);
	}
}
