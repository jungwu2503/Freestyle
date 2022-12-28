import java.awt.*;

public class D_Box extends D_TwoPointFigure {
	
	D_Box(Color color) {
		super(color);
	}
	
	D_Box(Color color, int x, int y) {
		super(color,x,y);
	}
	
	D_Box(Color color, int x1, int y1, int x2, int y2) {
		super(color,x1,y1,x2,y2);
	}
	
	void draw(Graphics g) {
		int minX = Math.min(x1, x2);
		int minY = Math.min(y1, y2);
		int width = Math.abs(x1-x2);
		int height = Math.abs(y1-y2);

		g.drawRect(minX, minY, width, height);
	}
	
	D_Figure copy() {
		D_Box newBox = new D_Box(color,x1,y1,x2,y2);
		newBox.popup = popup;
		newBox.move(MOVE_DX, MOVE_DY);
		return newBox;
	}
}
