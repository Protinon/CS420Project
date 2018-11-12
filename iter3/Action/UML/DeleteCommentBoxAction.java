package UML;

import java.util.ArrayList;

public class DeleteCommentBoxAction implements Action {
	Comment c;
	ArrayList<Comment> comments;
	public DeleteCommentBoxAction(Comment c, ArrayList<Comment> comments) {
		this.c = c;
		this.comments = comments;
	}
	
	public void doAction() {
		comments.remove(c);
	}
	
	public void undoAction() {
		comments.add(c);
	}
}
