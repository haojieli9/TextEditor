package extra;

import ide.interfaz;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PantallaCarga extends JDialog {

    private JLabel gifLabel;

    public PantallaCarga(JFrame parent) {
        super(parent, "Cargando", true);
        setLayout(new BorderLayout());

        // Carga el GIF animado
        ImageIcon gifIcon = new ImageIcon("src/icons/cargando.gif");
        gifLabel = new JLabel(gifIcon);
        add(gifLabel, BorderLayout.CENTER);

        setSize(gifIcon.getIconWidth(), gifIcon.getIconHeight());
        setLocationRelativeTo(null);
        setUndecorated(true); // Sin bordes
        setResizable(false);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        // Simula la carga
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                dispose(); // Cierra la pantalla de carga
                mostrarVentanaPrincipal();
            }
        }, 3000); // Simula 2 segundos de carga
    }

    private void mostrarVentanaPrincipal() {
        // Aquí puedes inicializar la ventana principal
        EventQueue.invokeLater(() -> {
            interfaz ventanaPrincipal = new interfaz();
            ventanaPrincipal.setVisible(true);
        });
    }
}
