package action;

import java.util.ArrayList;
import object.Class;

public class DeleteClassBoxAction implements Action {
	private Class classBox;
	private ArrayList<Class> classBoxes;

	public DeleteClassBoxAction(Class c, ArrayList<Class> classes) {
		this.classBox = c;
		this.classBoxes = classes;
	}

	public void doAction() {
		classBoxes.remove(classBox);
	}

	public void undoAction() {
		classBoxes.add(classBox);
	}
}
