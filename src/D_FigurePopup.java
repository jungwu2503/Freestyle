import javax.swing.*;

public class D_FigurePopup extends D_Popup {
	D_FigurePopup(D_DrawerView view, String title, boolean fillFlag) {
		super(title);
		JMenuItem deleteItem = new JMenuItem("Delete");
		deleteItem.addActionListener((evt) -> view.deleteFigure() );
		popupPtr.add(deleteItem);
		
		JMenuItem copyItem = new JMenuItem("Copy");
		copyItem.addActionListener((evt) -> view.copyFigure() );
		popupPtr.add(copyItem);
		
		JMenu colorMenu = new JMenu("Colors");
		popupPtr.add(colorMenu);
		
		JMenuItem blackItem = new JMenuItem("Black");
		blackItem.addActionListener((evt) -> view.setBlackColor() );
		colorMenu.add(blackItem);
		
		JMenuItem redItem = new JMenuItem("Red");
		redItem.addActionListener((evt) -> view.setRedColor() );
		colorMenu.add(redItem);
		
		JMenuItem greenItem = new JMenuItem("Green");
		greenItem.addActionListener((evt) -> view.setGreenColor() );
		colorMenu.add(greenItem);
		
		JMenuItem blueItem = new JMenuItem("Blue");
		blueItem.addActionListener((evt) -> view.setBlueColor() );
		colorMenu.add(blueItem);
		
	}
}