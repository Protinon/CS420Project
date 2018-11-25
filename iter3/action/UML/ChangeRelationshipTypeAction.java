package UML;

public class ChangeRelationshipTypeAction implements Action{
	private Relationship relationship;
	private String type;
public ChangeRelationshipTypeAction(Relationship r, String type) {
	this.relationship = r;
	this.type = type;
}

@Override
public void doAction() {
if (type == "Aggregation") {
	
} else if (type == "Association") {
	
} else if (type == "Composition") {
	
}else if (type == "Dependency") {
	
} else {
	
}
}

@Override
public void undoAction() {
	// TODO Auto-generated method stub
	
}
}
