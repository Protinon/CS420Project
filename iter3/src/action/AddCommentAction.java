package action;

import java.awt.Point;
import java.util.ArrayList;

import object.Canvas;
import object.Comment;

public class AddCommentAction implements Action {
	private Comment comment;
	
	private Point p;
	
	private ArrayList<Comment> comments;
	
	private Canvas rightPane;
	
	/**
	 * Initialize this add comment object action
	 * 
	 * @author Bri Long
	 * @param p - point where the comments upper left hand corner will be
	 * @param comments - the list of comment objects on the canvas for us to add a new comment to
	 * @param rightPane - the canvas that the object will be drawn on
	 **/
	public AddCommentAction(Point p, ArrayList<Comment> comments, Canvas rightPane) {
		this.p = p;
		this.comments = comments;
		this.rightPane = rightPane;
	}
	
	/**
	 * Create new comment object and add it to the list of comments on the canvas
	 * 
	 * @author Bri Long
	 * @return void
	 **/
	public void doAction() {
		comment = new Comment(p.x, p.y, rightPane);
		comments.add(comment);
	}
	
	/**
	 * Remove the created comment obejct from the canvas
	 * 
	 * @author Bri Long
	 * @return void
	 **/
	public void undoAction() {
		comments.remove(comment);
	}
}
