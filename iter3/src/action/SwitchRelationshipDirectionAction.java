package action;

import object.Class;
import object.Controller;
import object.Relationship;
import object.View;

public class SwitchRelationshipDirectionAction implements Action {
	private View v;

	private Controller c;
	
	private Class parent;
	private Class child;
	private Relationship relationship;
	
	public SwitchRelationshipDirectionAction(Controller c, View v, Relationship relationship) {
		this.v = v;
		this.c = c;
		this.parent = c.getSelectedRelationship().getClass1();
		this.child = c.getSelectedRelationship().getClass2();
		this.relationship = relationship;
	}

	@Override
	public void doAction() {
		Class temp = parent;
		parent = child;
		child = temp;
		relationship.setClass1(parent);
		relationship.setClass2(child);
	}

	@Override
	public void undoAction() {
		Class temp = parent;
		parent = child;
		child = temp;
		relationship.setClass1(parent);
		relationship.setClass2(child);
	}
}