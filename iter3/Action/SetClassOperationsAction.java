package UML;

public class SetClassOperationsAction implements Action {
	private String alt;
	private Class clazz;
	

	public SetClassOperationsAction(Class cl, String text) {
		clazz = cl;
		alt = text;
	}
	
	public void doAction() {
		String temp = alt;
		alt = clazz.getOperations();
		clazz.setOperations(temp);
	}
	
	public void undoAction() {
		String temp = alt;
		alt = clazz.getOperations();
		clazz.setOperations(temp);
		
	}
}
