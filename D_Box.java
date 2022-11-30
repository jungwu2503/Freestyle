import java.awt.Color;
import java.awt.Graphics;

public class D_Box {
	
	private int x1, y1, x2, y2;
	
	D_Box() {
		
	}
	
	D_Box(int x, int y) {
		x1 = x2 = x;
		y1 = y2 = y;
	}
	
	void draw(Graphics g) {
		int minX = Math.min(x1, x2);
		int minY = Math.min(y1, y2);
		int width = Math.abs(x1-x2);
		int height = Math.abs(y1-y2);

		g.drawRect(minX, minY, width, height);
	}
	
	void drawing(Graphics g, int newX, int newY) {
		draw(g);		
		setXY2(newX, newY);		
		draw(g);		
		g.setColor(Color.black);
	}
	
	void setXY2(int x, int y) {
		//x2 = x; y2 = y;
		setX2(x); setY2(y);
	}
	
	int getX1() {
		return x1;
	}
	
	int getY1() {
		return y1;
	}

	int getX2() {
		return x2;
	}
	
	int getY2() {
		return y2;
	}
	
	void setX1(int x) {
		x1 = x;
	}
	
	void setY1(int y) {
		y1 = y;
	}

	void setX2(int x) {
		x2 = x;
	}
	
	void setY2(int y) {
		y2 = y;
	}
	
}
