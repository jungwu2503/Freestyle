import javax.swing.*;

public class D_Popup {
	JPopupMenu popupPtr;
	D_Popup(String title) {
		popupPtr = new JPopupMenu();
		popupPtr.add(title);
		popupPtr.addSeparator();
	}
	public void popup(JPanel view, int x, int y) {
		popupPtr.show(view, x, y);
	}
}
