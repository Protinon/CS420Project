package action;

import object.Class;

public class SetClassNameAction implements Action {
	private String newName;

	private Class classBox;

	public SetClassNameAction(Class cl, String text) {
		classBox = cl;
		newName = text;
	}

	public void doAction() {
		String temp = newName;
		newName = classBox.getName();
		classBox.setName(temp);
	}

	public void undoAction() {
		String temp = newName;
		newName = classBox.getName();
		classBox.setName(temp);
	}
}
