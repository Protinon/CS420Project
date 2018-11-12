package UML;


public class SetClassNameAction implements Action{
	private String alt;
	private Class clazz;
	

	public SetClassNameAction(Class cl, String text) {
		clazz = cl;
		alt = text;
	}
	
	public void doAction() {
		String temp = alt;
		alt = clazz.getName();
		clazz.setName(temp);
	}
	
	public void undoAction() {
		String temp = alt;
		alt = clazz.getName();
		clazz.setName(temp);
		
	}
}
