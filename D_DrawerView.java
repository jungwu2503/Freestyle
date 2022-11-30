import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class D_DrawerView extends JPanel implements MouseListener, MouseMotionListener {
	
	public static int DRAW_BOX = 1;
	public static int DRAW_LINE = 2;
	
	private int selectDraw;
	private D_Box pBox;
	private ArrayList<D_Box> boxes = new ArrayList<D_Box>();
	private D_Line pLine;
	private ArrayList<D_Line> lines = new ArrayList<D_Line>();
	
	D_DrawerView() {
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	void selectFigure(int figureType) {
		selectDraw = figureType;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
				
		for (int i = 0; i < boxes.size(); i++) {
			D_Box pBox = boxes.get(i);
			pBox.draw(g);
		}
		for (int i = 0; i < lines.size(); i++) {
			D_Line pLine = lines.get(i);
			pLine.draw(g);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (selectDraw == DRAW_BOX) {
			pBox = new D_Box(e.getX(), e.getY());		
			boxes.add(pBox);
		} else if (selectDraw == DRAW_LINE) {
			pLine = new D_Line(e.getX(), e.getY());
			lines.add(pLine);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {		
		Graphics g = getGraphics();
		
		if (selectDraw == DRAW_BOX) {
			pBox.setXY2(e.getX(), e.getY());
			pBox.draw(g);
		} else if (selectDraw == DRAW_LINE) {
			pLine.setXY2(e.getX(), e.getY());
			pLine.draw(g);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Graphics g = getGraphics();
		g.setXORMode(Color.magenta);
		
		if (selectDraw == DRAW_BOX) {
			pBox.drawing(g, e.getX(), e.getY());
		} else if (selectDraw == DRAW_LINE) {
			pLine.drawing(g, e.getX(), e.getY());
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
	
}
