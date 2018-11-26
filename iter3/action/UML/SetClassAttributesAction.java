package UML;

public class SetClassAttributesAction implements Action {
	private String newAttributes;

	private Class classBox;

	public SetClassAttributesAction(Class cl, String text) {
		classBox = cl;
		newAttributes = text;
	}

	public void doAction() {
		String temp = newAttributes;
		newAttributes = classBox.getAttributes();
		classBox.setAttributes(temp);
	}

	public void undoAction() {
		String temp = newAttributes;
		newAttributes = classBox.getAttributes();
		classBox.setAttributes(temp);
	}
}
