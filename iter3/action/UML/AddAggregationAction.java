package UML;

import java.awt.Point;
import java.util.ArrayList;

public class AddAggregationAction implements Action {
	private Point p1;
	private Point p2;
	
	private ArrayList<Aggregation> aggregations;
	private ArrayList<Class> classes;
	
	private Class parent;
	private Class child;

	public AddAggregationAction(Point p1, Point p2, ArrayList<Aggregation> aggregations,
			ArrayList<Class> classes) {
		this.aggregations = aggregations;
		this.p1 = p1;
		this.p2 = p2;
		this.classes = classes;
	}

	public void doAction() {
		for (Class c : classes) {
			if (c.contains(p1)) {
				parent = c;
			} else if (c.contains(p2)) {
				child = c;
			}
		}
		
		if (parent != null && child != null) {
			aggregations.add(new Aggregation(parent, child));
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
