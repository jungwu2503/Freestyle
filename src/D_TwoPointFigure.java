import java.awt.*;

public abstract class D_TwoPointFigure extends D_Figure {
	protected int x1, y1, x2, y2;
	
	D_TwoPointFigure(Color color) {
		super(color);
	}
	
	D_TwoPointFigure(Color color, int x, int y) {
		super(color);
		x1 = x2 = x;
		y1 = y2 = y;
	}
	
	D_TwoPointFigure(Color color, int x1, int y1, int x2, int y2) {
		super(color);
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	void move(int dx, int dy) {
		x1 = x1 + dx; y1 = y1 + dy;
		x2 = x2 + dx; y2 = y2 + dy;
	}
	
	void makeRegion() {
		if (x1 > x2) {
			int tmp = x1;
			x1 = x2;
			x2 = tmp;
		}
		if (y1 > y2) {
			int tmp = y1;
			y1 = y2;
			y2 = tmp;
		}
		int[] xPoints = new int[4];
		int[] yPoints = new int[4];
		
		xPoints[0] = x1; yPoints[0] = y1;
		xPoints[1] = x2; yPoints[1] = y1;
		xPoints[2] = x2; yPoints[2] = y2;
		xPoints[3] = x1; yPoints[3] = y2;
		
		region = new Polygon(xPoints, yPoints, 4);
	}
	
	void setXY2(int x, int y) {
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
