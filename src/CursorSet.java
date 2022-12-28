import java.awt.*;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;

class CursorSet extends JFrame {
	CursorSet() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image cursorImage;
		try {
			cursorImage = ImageIO.read(MainFrame.class.getResource("img/StarArrow.gif"));
			Cursor cursor = tk.createCustomCursor(cursorImage, new Point(0,0), "");
			setCursor(cursor);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}