import javax.swing.*;

public class D_MainPopup extends D_Popup{
	D_MainPopup(D_DrawerView view) {
		super("±×¸²");
		JMenuItem boxItem = new JMenuItem("Box");
		popupPtr.add(boxItem);
		boxItem.addActionListener((evt) -> {
			view.selectFigure(D_DrawerView.DRAW_BOX);
		});
		JMenuItem lineItem = new JMenuItem("Line");
		popupPtr.add(lineItem);
		lineItem.addActionListener((evt) -> {
			view.selectFigure(D_DrawerView.DRAW_LINE);
		});
	}
}
