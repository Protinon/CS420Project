package action;

import java.util.ArrayList;

import object.Aggregation;
import object.Class;

public class AddAggregationAction implements Action {
	private ArrayList<Aggregation> aggregations;

	private Class parent;
	private Class child;

	private String childM;
	private String parentM;
	
	private Aggregation agg;

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
			agg = new Aggregation(parent, child);
			aggregations.add(agg);
			
			agg.setChildMultiplicity(childM);
			agg.setParentMultiplicity(parentM);
	
			parent.setChild(child);
			child.setParent(parent);
			
			parent.setParentRelated();
			child.setChildRelated();
		}
	}

	public void undoAction() {
		aggregations.remove(agg);
		agg.setChildMultiplicity("");
		agg.setParentMultiplicity("");
		parent.removeChild(child);
		child.removeParent(parent);
	}
}
