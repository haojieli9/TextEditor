package extra;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

public class TextAreaWithLineNumber extends JScrollPane {

    private JTextArea textArea;
    private NumeroLinea numeroLinea;

    public TextAreaWithLineNumber() {
        textArea = new JTextArea();
        numeroLinea = new NumeroLinea(textArea);

        setViewportView(textArea);
        setRowHeaderView(numeroLinea);
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void buscarYReemplazarTexto(String palabraBuscar, String palabraReemplazar) {
        String texto = textArea.getText();
        texto = texto.replace(palabraBuscar, palabraReemplazar);
        textArea.setText(texto);
    }

    public void buscar(String palabraBuscar) {
        eliminarResaltado(); // Elimina cualquier resaltado previo

        String texto = textArea.getText();
        Highlighter highlighter = textArea.getHighlighter();
        DefaultHighlighter.DefaultHighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);

        int pos = texto.indexOf(palabraBuscar);
        while (pos >= 0) {
            try {
                highlighter.addHighlight(pos, pos + palabraBuscar.length(), painter);
                pos = texto.indexOf(palabraBuscar, pos + 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void eliminarResaltado() {
        Highlighter highlighter = textArea.getHighlighter();
        Highlighter.Highlight[] highlights = highlighter.getHighlights();

        for (Highlighter.Highlight highlight : highlights) {
            if (highlight.getPainter() instanceof DefaultHighlighter.DefaultHighlightPainter) {
                highlighter.removeHighlight(highlight);
            }
        }
    }

    public void guardarArchivo() {
        String contenido = textArea.getText();
        JFileChooser fileChooser = new JFileChooser();

        int resultado = fileChooser.showSaveDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            try {
                FileWriter fileWriter = new FileWriter(archivo);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                bufferedWriter.write(contenido);
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al guardar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
