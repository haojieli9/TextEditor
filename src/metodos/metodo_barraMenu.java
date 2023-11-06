package metodos;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import extra.TextAreaWithLineNumber;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class metodo_barraMenu {

    public static void newFile(JTabbedPane tabbedPane) {
        // Crear un nuevo componente de TextAreaWithLineNumber
        TextAreaWithLineNumber textAreaWithLineNumber = new TextAreaWithLineNumber();
        JTextArea textArea = textAreaWithLineNumber.getTextArea();

        // Agregar una nueva pestaña al JTabbedPane con un nombre predeterminado
        tabbedPane.addTab("Untitled", textAreaWithLineNumber);

        // Obtener el índice de la nueva pestaña recién creada
        int tabIndex = tabbedPane.indexOfComponent(textAreaWithLineNumber);

        // Crear un panel personalizado para la pestaña con un botón de cierre
        JPanel tabPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        tabPanel.setOpaque(false);

        // Crear una etiqueta para el título de la pestaña
        JLabel tabLabel = new JLabel("Untitled");
        tabLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));

        // Crear un botón de cierre
        JButton closeButton = new JButton();
        closeButton.setIcon(new FlatSVGIcon(new File("src/svg/x.svg")).derive(13, 13));
        closeButton.setFocusable(false);

        // Establecer el estilo del botón de cierre
        closeButton.setOpaque(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));

        // Configurar un ActionListener para el botón de cierre
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el índice de la pestaña a cerrar
                int indexToClose = tabbedPane.indexOfTabComponent(tabPanel);
                if (indexToClose != -1) {
                    // Cerrar la pestaña si se encontró un índice válido
                    tabbedPane.remove(indexToClose);
                }
            }
        });

        // Agregar la etiqueta y el botón de cierre al panel personalizado
        tabPanel.add(tabLabel);
        tabPanel.add(closeButton);

        // Establecer el panel personalizado como componente de la pestaña
        tabbedPane.setTabComponentAt(tabIndex, tabPanel);

        // Actualizar la interfaz de usuario del JTabbedPane
        tabbedPane.revalidate();
        tabbedPane.repaint();
    }

    public static void closeFile(JPanel jPanel) {
        JTabbedPane tabbedPane = (JTabbedPane) jPanel.getComponent(0); // Obtén el JTabbedPane existente en jPanel

        int selectedIndex = tabbedPane.getSelectedIndex();

        if (selectedIndex != -1) {
            tabbedPane.remove(selectedIndex);
            jPanel.revalidate();
            jPanel.repaint();
        }
    }

    public static void openFile(JTabbedPane tabbedPane, File file) {
        if (!file.exists()) {
            System.err.println("selected file does not exists");
            return;
        }

        TextAreaWithLineNumber textAreaWithLineNumber = new TextAreaWithLineNumber();
        JTextArea textArea = textAreaWithLineNumber.getTextArea();

        tabbedPane.addTab(file.getName(), textAreaWithLineNumber);
        int tabIndex = tabbedPane.indexOfComponent(textAreaWithLineNumber);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            textArea.setText(content.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        JPanel tabPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        tabPanel.setOpaque(false);

        JLabel tabLabel = new JLabel(file.getName());
        tabLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));

        JButton closeButton = new JButton();
        closeButton.setIcon(new FlatSVGIcon(new File("src/svg/x.svg")).derive(13, 13));
        closeButton.setFocusable(false);

        closeButton.setOpaque(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indexToClose = tabbedPane.indexOfTabComponent(tabPanel);
                if (indexToClose != -1) {
                    tabbedPane.remove(indexToClose);
                }
            }
        });

        tabPanel.add(tabLabel);
        tabPanel.add(closeButton);

        tabbedPane.setTabComponentAt(tabIndex, tabPanel);

        tabbedPane.revalidate();
        tabbedPane.repaint();
    }
    
    

}
