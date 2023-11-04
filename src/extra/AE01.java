package es.florida.ad_ae01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;

public class AE01 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_Directorio;
	private JEditorPane editorPane_info;
	private JTextPane textPane_contenido;
	private JTextField textField_find;
	private JTextField textField_replace;
	private JList list_Directorio;
	private String directorioTrabajo;
	private JLabel lblFileContent;
	private String itemSeleccionado = "";
	private DefaultHighlighter.DefaultHighlightPainter highlightPainter = new DefaultHighlighter.DefaultHighlightPainter(
			Color.YELLOW);

	/**
	 * Launch the application.
	 * 
	 * @param args Argumentos de entrada (no se utilizan)
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AE01 frame = new AE01();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AE01() {
		setTitle("File Explorer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 22, 873, 38);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Working path:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 10, 112, 18);
		panel.add(lblNewLabel);

		textField_Directorio = new JTextField();
		textField_Directorio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Directorio.setBounds(118, 6, 637, 25);
		panel.add(textField_Directorio);
		textField_Directorio.setColumns(10);

		JButton btn_load = new JButton("Load");
		btn_load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.setCurrentDirectory(new java.io.File("."));
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int returnVal = fc.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File directorio = fc.getSelectedFile();
					directorioTrabajo = directorio.getAbsolutePath();
					textField_Directorio.setText(directorioTrabajo);
					String[] listaFicheros = listarFicheros(directorioTrabajo);
					DefaultListModel model = new DefaultListModel();
					for (String elemento : listaFicheros) {
						model.addElement(elemento);
					}
					list_Directorio.setModel(model);
				}
			}
		});
		btn_load.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_load.setBounds(765, 6, 98, 25);
		panel.add(btn_load);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 70, 231, 375);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblFileList = new JLabel("File list");
		lblFileList.setBounds(10, 10, 101, 20);
		lblFileList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblFileList);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 40, 211, 328);
		panel_1.add(scrollPane_1);

		list_Directorio = new JList();
		list_Directorio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				itemSeleccionado = (String) list_Directorio.getSelectedValue();
				String fileInfo = obtenerInfo(itemSeleccionado);
				editorPane_info.setText(fileInfo);
			}
		});

		scrollPane_1.setViewportView(list_Directorio);
		list_Directorio.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(251, 70, 632, 143);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblFileInfo = new JLabel("File info");
		lblFileInfo.setBounds(10, 10, 68, 20);
		lblFileInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblFileInfo);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 40, 612, 93);
		panel_2.add(scrollPane_2);

		editorPane_info = new JEditorPane();
		editorPane_info.setContentType("text/html");
		editorPane_info.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane_2.setViewportView(editorPane_info);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(251, 223, 632, 357);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		lblFileContent = new JLabel("File content");
		lblFileContent.setBounds(10, 10, 612, 20);
		lblFileContent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblFileContent);

		JLabel lblFindText = new JLabel("Find text:");
		lblFindText.setBounds(10, 329, 68, 20);
		lblFindText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblFindText);

		textField_find = new JTextField();
		textField_find.setBounds(75, 328, 96, 22);
		textField_find.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(textField_find);
		textField_find.setColumns(10);

		JLabel lblReplaceWith = new JLabel("Replace with:");
		lblReplaceWith.setBounds(253, 329, 106, 20);
		lblReplaceWith.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblReplaceWith);

		textField_replace = new JTextField();
		textField_replace.setBounds(338, 328, 96, 22);
		textField_replace.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_replace.setColumns(10);
		panel_3.add(textField_replace);

		JButton btn_find = new JButton("Find");
		btn_find.setBounds(175, 327, 63, 25);
		btn_find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane_contenido.getHighlighter().removeAllHighlights();
				String contenido = textPane_contenido.getText();
				String expresion = textField_find.getText();
				ArrayList<Integer> posiciones = buscarTexto(contenido, expresion);
				try {
					for (int posicion : posiciones) {
						textPane_contenido.getHighlighter().addHighlight(posicion, posicion + expresion.length(),
								highlightPainter);
					}
					JOptionPane.showMessageDialog(new JFrame(), "Coincidences: " + posiciones.size(), "Info",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (BadLocationException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btn_find.setHorizontalAlignment(SwingConstants.LEFT);
		btn_find.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(btn_find);

		JButton btn_replace = new JButton("Replace");
		btn_replace.setBounds(440, 327, 89, 25);
		btn_replace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String contenido = textPane_contenido.getText();
				String expresion = textField_find.getText();
				String expresion2 = textField_replace.getText();
				contenido = reemplazarTexto(contenido, expresion, expresion2);
				textPane_contenido.setText(contenido);
				ArrayList<Integer> posiciones = buscarTexto(contenido, expresion2);
				try {
					for (int posicion : posiciones) {
						textPane_contenido.getHighlighter().addHighlight(posicion, posicion + expresion2.length(),
								highlightPainter);
					}
				} catch (BadLocationException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btn_replace.setHorizontalAlignment(SwingConstants.LEFT);
		btn_replace.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(btn_replace);

		JButton btn_save = new JButton("Save");
		btn_save.setBounds(554, 327, 68, 25);
		btn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String contenido = textPane_contenido.getText();
				guardar(contenido);
			}
		});
		btn_save.setHorizontalAlignment(SwingConstants.LEFT);
		btn_save.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(btn_save);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 612, 273);
		panel_3.add(scrollPane);

		textPane_contenido = new JTextPane();
		textPane_contenido.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		scrollPane.setViewportView(textPane_contenido);

		JButton btn_create = new JButton("Create file");
		btn_create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearFichero();
			}
		});
		btn_create.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_create.setBounds(10, 455, 231, 25);
		contentPane.add(btn_create);

		JButton btn_rename = new JButton("Rename file");
		btn_rename.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				renombrarFichero();
			}
		});
		btn_rename.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_rename.setBounds(10, 480, 231, 25);
		contentPane.add(btn_rename);

		JButton btn_content = new JButton("View file content");
		btn_content.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblFileContent.setText("File content: " + itemSeleccionado);
				String contenidoFichero = obtenerContenido();
				textPane_contenido.setText(contenidoFichero);
			}
		});
		btn_content.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_content.setBounds(10, 555, 231, 25);
		contentPane.add(btn_content);

		JButton btn_copy = new JButton("Copy file");
		btn_copy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				copiarFichero();
			}
		});
		btn_copy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_copy.setBounds(10, 505, 231, 25);
		contentPane.add(btn_copy);

		JButton btn_delete = new JButton("Delete file");
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarFichero();
			}
		});
		btn_delete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_delete.setBounds(10, 530, 231, 25);
		contentPane.add(btn_delete);

	}

	/**
	 * Metodo para explorar y devolver el contenido de un directorio
	 * 
	 * @param directorioTrabajo: directorio de trabajo para listar
	 * @return Devuelve un array de strings con el contenido del directorio
	 *         (carpetas y ficheros)
	 */
	public String[] listarFicheros(String directorioTrabajo) {
		File directorio = new File(directorioTrabajo);
		String[] contenido = directorio.list();
		Arrays.sort(contenido);
		return contenido;
	}

	/**
	 * Metodo para obtener la informacion de un fichero
	 * 
	 * @param archivo: nombre del fichero (se podria utilizar tambien la variable
	 *                 global itemSeleccionado)
	 * @return Devuelve un string formateado en HTML con informacion segun si se
	 *         trata de un fichero o un directorio: tipo, extension, permisos, ruta,
	 *         fecha modificacion, oculto, numero de elementos, tamanyo, espacio en
	 *         disco
	 */
	public String obtenerInfo(String archivo) {
		String info = "";
		String strFichero = directorioTrabajo + File.separator + archivo;
		File fichero = new File(strFichero);
		info = info + "<b>Name:</b> " + fichero.getName() + "&#9;"; // &#9; tabulador HTML
		if (fichero.isFile()) {
			info = info + "<b>Type</b>: File" + "&#9;";
			String extension;
			try {
				extension = archivo.split("\\.")[1]; // Controlar si tiene extension
			} catch (Exception e) {
				extension = "";
			}
			info = info + "<b>Extension</b>: " + extension + "&#9;";
			String[] permisos = new String[] { "X", "X" };
			if (fichero.canRead()) {
				permisos[0] = "R";
			}
			if (fichero.canWrite()) {
				permisos[1] = "W";
			}
			info = info + "<b>Can (R/W)</b>: " + permisos[0] + "|" + permisos[1] + "<br>";
		} else {
			info = info + "<b>Type:</b> Folder" + "<br>";
		}
		info = info + "<b>Path:</b> " + fichero.getAbsolutePath() + "<br>";
		info = info + "<b>Last modified:</b> " + new Date(fichero.lastModified()) + "&#9;";
		info = info + "<b>Hidden:</b> " + fichero.isHidden() + "&#9;";
		if (fichero.isFile()) {
			info = info + "<b>Size:</b> " + fichero.length() + " bytes" + "<br>";
		} else {
			info = info + "<b>Elements:</b> " + fichero.list().length + "<br>";
			info = info + "<b>Free space:</b> " + fichero.getFreeSpace() / 1024 / 1024 / 1024 + " GB" + "&#9;";
			info = info + "<b>Ocupied space:</b> "
					+ (fichero.getTotalSpace() / 1024 / 1024 / 1024 - fichero.getFreeSpace() / 1024 / 1024 / 1024)
					+ " GB" + "&#9;";
			info = info + "<b>Total space:</b> " + fichero.getTotalSpace() / 1024 / 1024 / 1024 + " GB";
		}
		return info;
	}

	/**
	 * Metodo para crear un fichero nuevo, solicitando el nombre al usuario
	 */
	public void crearFichero() {
		String nuevoNombre = JOptionPane.showInputDialog("New file name?");
		File nuevoFichero = new File(directorioTrabajo + File.separator + nuevoNombre);
		try {
			nuevoFichero.createNewFile();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Metodo que permite renombrar el fichero definido en la variable global
	 * itemSeleccionado por otro nombre que solicita al usuario
	 */
	public void renombrarFichero() {
		int opcion = JOptionPane.showConfirmDialog(null, "Confirm rename action?");
		if (opcion == 0)
			try {
				String nuevoNombre = JOptionPane.showInputDialog("New file name (without extension)?");
				int posicionPunto = itemSeleccionado.indexOf(".");
				String extension = itemSeleccionado.substring(posicionPunto);
				String nombreFicheroCopia = nuevoNombre + extension;
				File ficheroOriginal = new File(directorioTrabajo + File.separator + itemSeleccionado);
				File ficheroCopia = new File(directorioTrabajo + File.separator + nombreFicheroCopia);
				FileReader fr = new FileReader(ficheroOriginal);
				BufferedReader br = new BufferedReader(fr);
				FileWriter fw = new FileWriter(ficheroCopia);
				BufferedWriter bw = new BufferedWriter(fw);
				String linea = br.readLine();
				while (linea != null) {
					bw.write(linea);
					linea = br.readLine();
				}
				br.close();
				bw.close();
				fr.close();
				fw.close();
				ficheroOriginal.delete();
				JOptionPane.showMessageDialog(null, "Renamed correctly!", "Info", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
			}
	}

	/**
	 * Metodo que realiza una copia del fichero definido en la variable glboal
	 * itemSeleccionado en el mismo directorio de trabajo y con nombre
	 * itemSeleccionado + '_copia'
	 */
	public void copiarFichero() {
		try {
			int posicionPunto = itemSeleccionado.indexOf(".");
			String nombreFicheroSinExtension = itemSeleccionado.substring(0, posicionPunto);
			String extension = itemSeleccionado.substring(posicionPunto);
			String nombreFicheroCopia = nombreFicheroSinExtension + "_copia" + extension;
			File ficheroOriginal = new File(directorioTrabajo + File.separator + itemSeleccionado);
			File ficheroCopia = new File(directorioTrabajo + File.separator + nombreFicheroCopia);
			FileReader fr = new FileReader(ficheroOriginal);
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter(ficheroCopia);
			BufferedWriter bw = new BufferedWriter(fw);
			String linea = br.readLine();
			while (linea != null) {
				bw.write(linea + "\n");
				linea = br.readLine();
			}
			br.close();
			bw.close();
			fr.close();
			fw.close();
			JOptionPane.showMessageDialog(null, "Copied correctly!", "Info", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Metodo para borrar el fichero definido por la variable global
	 * itemSeleccionado
	 */
	public void borrarFichero() {
		int opcion = JOptionPane.showConfirmDialog(null, "Confirm delete action?");
		if (opcion == 0)
			try {
				File ficheroOriginal = new File(directorioTrabajo + File.separator + itemSeleccionado);
				ficheroOriginal.delete();
				JOptionPane.showMessageDialog(null, "Deleted correctly!", "Info", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
			}
	}

	/**
	 * Metodo para obtener como string el contenido del fichero de texto
	 * seleccionado (variable global itemSeleccionado)
	 * 
	 * @return Devuelve un string con el contenido del fichero
	 */
	public String obtenerContenido() {
		String contenido = "";
		try {
			File ficheroOriginal = new File(directorioTrabajo + File.separator + itemSeleccionado);
			FileReader fr = new FileReader(ficheroOriginal);
			// FileReader fr = new FileReader(ficheroOriginal, StandardCharsets.UTF_8);
			// //Para seleccionar charset especifico
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			while (linea != null) {
				contenido = contenido + linea + "\n";
				linea = br.readLine();
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
		}
		return contenido;
	}

	/**
	 * Metodo para buscar una cadena dentro de un texto
	 * 
	 * @param texto:       texto completo donde buscar
	 * @param textoBuscar: cadena a buscar
	 * @return Devuelve un ArrayList de enteros con las posiciones de las
	 *         ocurrencias
	 */
	public ArrayList<Integer> buscarTexto(String texto, String textoBuscar) {
		int coincidencias = 0;
		ArrayList<Integer> posiciones = new ArrayList<Integer>();
		int indice = texto.indexOf(textoBuscar);
		while (indice >= 0) {
			posiciones.add(indice);
			coincidencias++;
			indice = texto.indexOf(textoBuscar, (indice + 1));
		}
		return posiciones;
	}

	/**
	 * Metodo que reemplaza una cadena por otra en el texto mostrado en la
	 * aplicacion
	 * 
	 * @param texto:           texto mostrado en la aplicacion
	 * @param textoBuscar:     cadena de texto a buscar
	 * @param textoReemplazar: cadena de texto nueva
	 * @return Devuelve el nuevo texto con las cadenas remplazadas
	 */
	public String reemplazarTexto(String texto, String textoBuscar, String textoReemplazar) {
		texto = texto.replaceAll(textoBuscar, textoReemplazar);
		JOptionPane.showMessageDialog(null, "Replaced correctly!", "Info", JOptionPane.INFORMATION_MESSAGE);
		return texto;
	}

	/**
	 * Metodo para guardar el contenido del texto en un fichero (permite
	 * sobreescribir o crear nuevo)
	 * 
	 * @param contenido: texto mostrado en la aplicacion
	 */
	public void guardar(String contenido) {
		int opcion = JOptionPane.showConfirmDialog(null, "Overwrite?");
		File fichero;
		if (opcion == 0) {
			fichero = new File(directorioTrabajo + File.separator + itemSeleccionado);
		} else if (opcion == 1) {
			String nuevoNombre = JOptionPane.showInputDialog("New file name?");
			fichero = new File(directorioTrabajo + File.separator + nuevoNombre);
		} else {
			return;
		}
		FileWriter fw;
		try {
			fw = new FileWriter(fichero);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(contenido);
			bw.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}

	}
}
