package UML;

import java.awt.Point;
import java.util.ArrayList;

public class AddCompositionAction implements Action {
	private Point p1, p2;
	private ArrayList<Composition> compositions;
	private ArrayList<Class> classes;
	private Class class1, class2;

	public AddCompositionAction(Point p1, Point p2, ArrayList<Composition> compositions, ArrayList<Class> classes) {
		this.compositions = compositions;
		this.p1 = p1;
		this.p2 = p2;
		this.classes = classes;
	}

	public void doAction() {
		for (Class c : classes) {
				if (c.contains(p1)) {
					class1 = c;
				} else if (c.contains(p2)) {
					class2 = c;
				}
			}
		compositions.add(new Composition(class1,class2));
		class1.setRelated(true);
		class2.setRelated(true);
	}

	public void undoAction() {
		compositions.remove(class1);
		compositions.remove(class2);
	}
}