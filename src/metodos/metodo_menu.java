package metodos;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.io.File;
import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

public class metodo_menu {

    public void bordeBoton(JButton jb) {
        jb.setBorderPainted(false);
    }

    public static void svgIcon(AbstractButton component, String svgFilePath, int width, int height) {
        Icon icon = new FlatSVGIcon(new File(svgFilePath)).derive(width, height);
        component.setIcon(icon);
    }


}
