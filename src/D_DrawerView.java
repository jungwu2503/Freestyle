import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;

import javax.imageio.*;
import javax.swing.*;

public class D_DrawerView extends JPanel implements MouseListener, MouseMotionListener {
	
	public static int DRAW_BOX = 1;
	public static int DRAW_LINE = 2;
	
	public static int NOTHING = 0;
	public static int DRAWING = 1;
	public static int MOVING = 2;
	
	private int actionMode;
	private int selectDraw;
	private D_Figure currentFigure;
	private ArrayList<D_Figure> figures = new ArrayList<D_Figure>();
	
	private int currentX;
	private int currentY;
	
	D_Popup mainPopup;
	D_Popup boxPopup;
	D_Popup linePopup;
	
	private Toolkit tk = Toolkit.getDefaultToolkit();
	private Image cursorImage;
	private Cursor cursor;
	
	D_DrawerView() {
		mainPopup = new D_MainPopup(this);
		boxPopup = new D_FigurePopup(this,"Box",true);
		linePopup = new D_FigurePopup(this,"Line",false);
		
		actionMode = NOTHING;
		selectDraw = DRAW_BOX;
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	D_Popup boxPopup() {
		return boxPopup;
	}
	D_Popup linePopup() {
		return linePopup;
	}
	
	void selectFigure(int figureType) {
		selectDraw = figureType;
	}
	
	public void addFigure(D_Figure newFigure) {
		newFigure.makeRegion();
		figures.add(newFigure);
		repaint();
	}
	
	public void deleteFigure() {
		if (currentFigure == null) return;
		figures.remove(currentFigure);
		currentFigure = null;
		repaint();
	}
	
	public void setColorForSelected(Color color) {
		
	}
	
	public void setBlackColor() {
		setColorForSelected(Color.black);
	}
	
	public void setRedColor() {
		
	}

	public void setGreenColor() {
		
	}
	
	public void setBlueColor() {
		
	}
	
	public void copyFigure() {
		if (currentFigure == null) return;
		D_Figure newFigure = currentFigure.copy();
		addFigure(newFigure);
		currentFigure = newFigure;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
				
		for (int i = 0; i < figures.size(); i++) {
			D_Figure pFigure = figures.get(i);
			pFigure.draw(g);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		if (e.getButton() == MouseEvent.BUTTON3) {
			actionMode = NOTHING;
			return;
		}
		currentFigure = find(x,y);
		if (currentFigure != null) {
			actionMode = MOVING;
			currentX = x;
			currentY = y;
			figures.remove(currentFigure);
			repaint();
			return;
		}
		
		if (selectDraw == DRAW_BOX) {
			currentFigure = new D_Box(Color.black,x,y);
			currentFigure.setPopup(boxPopup);
		} else if (selectDraw == DRAW_LINE) {
			currentFigure = new D_Line(Color.black,x,y);
			currentFigure.setPopup(linePopup);
		}
		actionMode = DRAWING;
	}

	@Override
	public void mouseReleased(MouseEvent e) {	
		int x = e.getX();
		int y = e.getY();
		
		if (e.isPopupTrigger()) {
			currentFigure = find(x,y);
			if (currentFigure == null) {
				mainPopup.popup(this,x,y);				
			} else {
				currentFigure.popup(this,x,y);
			}
			return;
		}
		Graphics g = getGraphics();
		if (actionMode == DRAWING) {
			currentFigure.setXY2(x,y);
		}
		currentFigure.draw(g);
		addFigure(currentFigure);
		currentFigure = null;
	}

	@Override
	public void mouseEntered(MouseEvent e) {		
	}

	@Override
	public void mouseExited(MouseEvent e) {		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		Graphics g = getGraphics();
		g.setXORMode(Color.magenta);
		if (actionMode == DRAWING) {
			currentFigure.drawing(g,x,y);
		} else if (actionMode == MOVING) {
			currentFigure.move(g,x-currentX,y-currentY);
			currentX = x;
			currentY = y;
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		currentFigure = find(x,y);
		if (currentFigure != null) {			
			try {
				cursorImage = ImageIO.read(MainFrame.class.getResource("img/StarWorking.gif"));
				cursor = tk.createCustomCursor(cursorImage, new Point(0,0), "");
				setCursor(cursor);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			//setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		} else {
			try {
				cursorImage = ImageIO.read(MainFrame.class.getResource("img/StarArrow.gif"));
				cursor = tk.createCustomCursor(cursorImage, new Point(0,0), "");
				setCursor(cursor);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			//setCursor(Cursor.getDefaultCursor());
		}
	}
	
	private D_Figure find(int x, int y) {
		for (int i = 0; i < figures.size(); i++) {
			D_Figure pFigure = figures.get(i);
			if (pFigure.contains(x,y)) {
				return pFigure;
			}
		}
		return null;
	}	
}
