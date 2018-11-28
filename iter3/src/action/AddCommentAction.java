package action;

import java.awt.Point;
import java.util.ArrayList;
import UML.Comment;

public class AddCommentAction implements Action {
	private Comment comment;
	
	private Point p;
	
	private ArrayList<Comment> comments;
	
	public AddCommentAction(Point p, ArrayList<Comment> comments) {
		this.p = p;
		this.comments = comments;
	}
	
	public void doAction() {
		comment = new Comment(p.x, p.y);
		comments.add(comment);
	}
	
	public void undoAction() {
		comments.remove(comment);
	}
}
