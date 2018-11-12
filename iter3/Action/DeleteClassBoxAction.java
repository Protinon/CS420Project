package UML;

import java.util.ArrayList;

public class DeleteClassBoxAction implements Action{
	Class c;
	ArrayList<Class> classes;
	public DeleteClassBoxAction(Class c, ArrayList<Class> classes) {
		this.c = c;
		this.classes = classes;
	}
	
	public void doAction() {
		classes.remove(c);
	}
	
	public void undoAction() {
		classes.add(c);
	}
}
