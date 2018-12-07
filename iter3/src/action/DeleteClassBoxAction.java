package action;

import java.util.ArrayList;

import object.Aggregation;
import object.Association;
import object.Class;
import object.Composition;
import object.Controller;
import object.Dependency;
import object.Generalization;

public class DeleteClassBoxAction implements Action {
	private Class classBox;
	private ArrayList<Class> classBoxes;
	private ArrayList<Association> associations = new ArrayList<Association>();
	private ArrayList<Aggregation> aggregations = new ArrayList<Aggregation>();
	private ArrayList<Composition> compositions = new ArrayList<Composition>();
	private ArrayList<Dependency> dependencies = new ArrayList<Dependency>();
	private ArrayList<Generalization> generalizations = new ArrayList<Generalization>();
	Controller c;

	public DeleteClassBoxAction(Class c, ArrayList<Class> classes, Controller con) {
		this.classBox = c;
		this.classBoxes = classes;
		this.c = con;
		for (Association a : con.getAssociations()) {
			if (a.getClass1() == classBox || a.getClass2() == classBox) {
				this.associations.add(a);
			}
		}

		for (Aggregation a : con.getAggregations()) {
			if (a.getClass1() == classBox || a.getClass2() == classBox) {
				this.aggregations.add(a);
			}
		}

		for (Composition a : con.getCompositions()) {
			if (a.getClass1() == classBox || a.getClass2() == classBox) {
				this.compositions.add(a);
			}
		}

		for (Dependency a : con.getDependencies()) {
			if (a.getClass1() == classBox || a.getClass2() == classBox) {
				this.dependencies.add(a);
			}
		}

		for (Generalization a : con.getGeneralizations()) {
			if (a.getClass1() == classBox || a.getClass2() == classBox) {
				this.generalizations.add(a);
			}
		}

	}

	public void doAction() {
		classBox.delete();
		classBoxes.remove(classBox);
		for(Association a : associations) {
			c.deleteObject(a.getLocation2());
		}
		
		for(Aggregation a : aggregations) {
			c.deleteObject(a.getLocation2());
		}
		
		for(Composition a : compositions) {
			c.deleteObject(a.getLocation2());
		}
		
		for(Dependency a : dependencies) {
			c.deleteObject(a.getLocation2());
		}
		
		for(Generalization a : generalizations) {
			c.deleteObject(a.getLocation2());
		}
	}

	public void undoAction() {
		classBoxes.add(classBox);
		for(Association a : associations) {
			c.addAssociation(a.getClass1(), a.getClass2(), a.getChildMultiplicity(), a.getParentMultiplicity());
		}
		
		for(Aggregation a : aggregations) {
			c.addAggregation(a.getClass1(), a.getClass2(), a.getChildMultiplicity(), a.getParentMultiplicity());
		}
		
		for(Composition a : compositions) {
			c.addComposition(a.getClass1(), a.getClass2(), a.getChildMultiplicity(), a.getParentMultiplicity());
		}
		
		for(Dependency a : dependencies) {
			c.addDependency(a.getClass1(), a.getClass2(), a.getChildMultiplicity(), a.getParentMultiplicity());
		}
		
		for(Generalization a : generalizations) {
			c.addGeneralization(a.getClass1(), a.getClass2(), a.getChildMultiplicity(), a.getParentMultiplicity());
		}
	}
}
