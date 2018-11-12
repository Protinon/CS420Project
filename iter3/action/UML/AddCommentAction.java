package UML;

import java.awt.Point;
import java.util.ArrayList;

public class AddCommentAction implements Action {
	Comment c;
	Point p;
	ArrayList<Comment> comments;
	
	public AddCommentAction(Point p, ArrayList<Comment> comments) {
		this.p = p;
		this.comments = comments;
	}
	
	public void doAction() {
		c = new Comment(p.x, p.y);
		comments.add(c);
	}
	
	public void undoAction() {
		comments.remove(c);
	}
}
