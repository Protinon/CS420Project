package action;

import object.Class;

public class SetClassOperationsAction implements Action {
	private String newOperations;

	private Class classBox;

	public SetClassOperationsAction(Class cl, String text) {
		this.classBox = cl;
		this.newOperations = text;
	}

	public void doAction() {
		String temp = newOperations;
		newOperations = classBox.getOperations();
		classBox.setOperations(temp);
	}

	public void undoAction() {
		String temp = newOperations;
		newOperations = classBox.getOperations();
		classBox.setOperations(temp);
	}
}
