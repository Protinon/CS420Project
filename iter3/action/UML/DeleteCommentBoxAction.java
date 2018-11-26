package UML;

import java.util.ArrayList;

public class DeleteCommentBoxAction implements Action {
	private Comment comment;
	private ArrayList<Comment> comments;

	public DeleteCommentBoxAction(Comment comment, ArrayList<Comment> comments) {
		this.comment = comment;
		this.comments = comments;
	}

	public void doAction() {
		comments.remove(comment);
	}

	public void undoAction() {
		comments.add(comment);
	}
}
