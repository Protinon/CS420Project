package UML;

public class SetClassAttributesAction implements Action {
	private String alt;
	private Class clazz;
	

	public SetClassAttributesAction(Class cl, String text) {
		clazz = cl;
		alt = text;
	}
	
	public void doAction() {
		String temp = alt;
		alt = clazz.getAttributes();
		clazz.setAttributes(temp);
	}
	
	public void undoAction() {
		String temp = alt;
		alt = clazz.getAttributes();
		clazz.setAttributes(temp);
		
	}
}
