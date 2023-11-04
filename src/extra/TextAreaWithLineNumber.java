/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package extra;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

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
}

