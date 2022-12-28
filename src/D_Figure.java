import java.awt.*;
import javax.swing.*;

public abstract class D_Figure {
	protected static int MOVE_DX = 20;
	protected static int MOVE_DY = 10;
	
	protected Polygon region;
	protected D_Popup popup;
	protected Color color;
	D_Figure(Color color) {
		region = null;
		popup = null;
		this.color = color;
	}	
	abstract void draw(Graphics g);
	abstract void setXY2(int newX, int newY);
	abstract void makeRegion();	
	abstract void move(int dx, int dy);
	abstract D_Figure copy();
	boolean contains(int x, int y) {
		if (region == null) return false;
		return region.contains(x,y);
	}
	void setPopup(D_Popup popup) {
		this.popup = popup;
	}
	void popup(JPanel view, int x, int y) {
		popup.popup(view, x, y);
	}
	void move(Graphics g, int dx, int dy) {
		draw(g);
		move(dx,dy);
		draw(g);
	}
	void drawing(Graphics g, int newX, int newY) {
		draw(g);		
		setXY2(newX, newY);
		draw(g);		
		g.setColor(Color.black);
	}
}
