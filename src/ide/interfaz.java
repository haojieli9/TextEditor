package ide;

import com.formdev.flatlaf.*;
import com.formdev.flatlaf.FlatLightLaf;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import extra.PantallaCarga;
import javax.swing.*;
import extra.SideMenuPanel;
import extra.TextAreaWithLineNumber;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.text.JTextComponent;
import javax.swing.text.StyledDocument;
import metodos.metodo_barraMenu;
import metodos.metodo_menu;
import themes.themes;

public final class interfaz extends javax.swing.JFrame {

    private themes themeConfig;

    //Declaracion clase
    SideMenuPanel sp;
    metodo_menu mM = new metodo_menu();
    login lg = new login();
    configuracion cf = new configuracion();
    JPopupMenu menuEmergente = new JPopupMenu();
    JTabbedPane tabbedPane;
    JTextPane currentTextPane;

    //Constructor
    public interfaz() {
        initComponents();
        setLocationRelativeTo(null);
        setIcons();

        loadThemeConfig(); // Cargar la configuración del tema al iniciar

        JMenuItem opcion1 = new JMenuItem("Login");
        JMenuItem opcion2 = new JMenuItem("Logout");
        JMenuItem opcion3 = new JMenuItem("GitHub");
        JMenuItem opcion4 = new JMenuItem("Version control");

        menuEmergente.add(opcion1);
        menuEmergente.add(new JSeparator());
        menuEmergente.add(opcion2);
        menuEmergente.add(new JSeparator());
        menuEmergente.add(opcion3);
        menuEmergente.add(opcion4);

        /*JButton[] botones = {jbMenu1, jbMenu2, jbMenu3, jbMenu4, jbMenu5, jbMenu6};
        for (JButton boton : botones) {
            menuMeto.bordeBoton(boton);
        }
         */
        //declaracion menubar
        sp = new SideMenuPanel(this);
        sp.setMain(mainPanel);
        sp.setSide(sidebar);
        sp.setMinWidth(55);
        sp.setMaxWidth(150);
        sp.setMainAnimation(true);
        sp.setSpeed(4);
        sp.setResponsiveMinWidth(600);

        //tabbedpane
        tabbedPane = new JTabbedPane();
        jPanel2.setLayout(new BorderLayout());
        jPanel2.add(tabbedPane, BorderLayout.CENTER);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jMenu5 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        sidebar = new javax.swing.JPanel();
        jbMenu1 = new javax.swing.JButton();
        jbMenu2 = new javax.swing.JButton();
        jbMenu3 = new javax.swing.JButton();
        jbMenu5 = new javax.swing.JButton();
        jbMenu4 = new javax.swing.JButton();
        jbMenu6 = new javax.swing.JButton();
        tgg = new javax.swing.JToggleButton();
        mainPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        output = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        closefile = new javax.swing.JMenuItem();
        openfile = new javax.swing.JMenuItem();
        closepro = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        copyfile = new javax.swing.JMenuItem();
        delfile = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        undo = new javax.swing.JMenuItem();
        redo = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        cut = new javax.swing.JMenuItem();
        copy = new javax.swing.JMenuItem();
        paste = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        find = new javax.swing.JMenuItem();
        replace = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        all = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        up = new javax.swing.JMenuItem();
        down = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        duplicate = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        terminal = new javax.swing.JMenuItem();
        outputItem = new javax.swing.JMenuItem();
        debcon = new javax.swing.JMenuItem();
        problem = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        appa = new javax.swing.JMenuItem();
        zoom = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        ww = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        run = new javax.swing.JMenuItem();
        rundebug = new javax.swing.JMenuItem();
        stoprun = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        debug = new javax.swing.JMenuItem();
        stopdebug = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem32 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem34 = new javax.swing.JMenuItem();
        usm = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        jav = new javax.swing.JMenuItem();
        kot = new javax.swing.JMenuItem();
        ht = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        about = new javax.swing.JMenuItem();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jMenu5.setText("jMenu5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(932, 561));

        jbMenu1.setToolTipText("Menu");
        jbMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMenu1ActionPerformed(evt);
            }
        });

        jbMenu2.setToolTipText("Open proyect/directory");
        jbMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMenu2ActionPerformed(evt);
            }
        });

        jbMenu3.setToolTipText("Serach or replace");
        jbMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMenu3ActionPerformed(evt);
            }
        });

        jbMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMenu5ActionPerformed(evt);
            }
        });

        jbMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMenu4ActionPerformed(evt);
            }
        });

        jbMenu6.setToolTipText("Run and debug");
        jbMenu6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMenu6ActionPerformed(evt);
            }
        });

        tgg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tggActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sidebarLayout = new javax.swing.GroupLayout(sidebar);
        sidebar.setLayout(sidebarLayout);
        sidebarLayout.setHorizontalGroup(
            sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jbMenu5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jbMenu4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jbMenu6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jbMenu3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jbMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jbMenu1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(tgg, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        sidebarLayout.setVerticalGroup(
            sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbMenu3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbMenu6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tgg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbMenu4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbMenu5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        output.setColumns(20);
        output.setRows(5);
        output.setText("CONSOLE:");
        jScrollPane4.setViewportView(output);

        jButton1.setText("Info.");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Terminal");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1068, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(sidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sidebar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("New Proyect");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setText("New file");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);
        jMenu1.add(jSeparator1);

        closefile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        closefile.setText("Close File");
        closefile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closefileActionPerformed(evt);
            }
        });
        jMenu1.add(closefile);

        openfile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        openfile.setText("Open File");
        openfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openfileActionPerformed(evt);
            }
        });
        jMenu1.add(openfile);

        closepro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        closepro.setText("Close Proyect");
        closepro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeproActionPerformed(evt);
            }
        });
        jMenu1.add(closepro);
        jMenu1.add(jSeparator2);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem5.setText("Save");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem6.setText("Save All");
        jMenu1.add(jMenuItem6);
        jMenu1.add(jSeparator3);

        copyfile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        copyfile.setText("Copy File");
        jMenu1.add(copyfile);

        delfile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        delfile.setText("Delete File");
        jMenu1.add(delfile);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        undo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        undo.setText("Undo");
        undo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoActionPerformed(evt);
            }
        });
        jMenu2.add(undo);

        redo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        redo.setText("Redo");
        jMenu2.add(redo);
        jMenu2.add(jSeparator4);

        cut.setText("Cut");
        jMenu2.add(cut);

        copy.setText("Copy");
        jMenu2.add(copy);

        paste.setText("Paste");
        paste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteActionPerformed(evt);
            }
        });
        jMenu2.add(paste);
        jMenu2.add(jSeparator5);

        find.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        find.setText("Find");
        find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findActionPerformed(evt);
            }
        });
        jMenu2.add(find);

        replace.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        replace.setText("Replace");
        replace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                replaceActionPerformed(evt);
            }
        });
        jMenu2.add(replace);

        jMenuBar1.add(jMenu2);

        jMenu8.setText("Selection");

        all.setText("Select All");
        jMenu8.add(all);
        jMenu8.add(jSeparator6);

        up.setText("Move Line Up");
        jMenu8.add(up);

        down.setText("Move Line Dow");
        jMenu8.add(down);
        jMenu8.add(jSeparator7);

        duplicate.setText("Duplicate Selected");
        duplicate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duplicateActionPerformed(evt);
            }
        });
        jMenu8.add(duplicate);

        jMenuBar1.add(jMenu8);

        jMenu3.setText("View");

        terminal.setText("Terminal");
        jMenu3.add(terminal);

        outputItem.setText("Output");
        jMenu3.add(outputItem);

        debcon.setText("Debbug Console");
        debcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                debconActionPerformed(evt);
            }
        });
        jMenu3.add(debcon);

        problem.setText("Problem");
        jMenu3.add(problem);
        jMenu3.add(jSeparator8);

        appa.setText("Apparence");
        jMenu3.add(appa);

        zoom.setText("Zoom");
        jMenu3.add(zoom);
        jMenu3.add(jSeparator9);

        ww.setText("Word Wrap");
        ww.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wwActionPerformed(evt);
            }
        });
        jMenu3.add(ww);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Run");

        run.setText("Run");
        jMenu4.add(run);

        rundebug.setText("Run Whitout Debbug");
        rundebug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rundebugActionPerformed(evt);
            }
        });
        jMenu4.add(rundebug);

        stoprun.setText("Stop Run");
        jMenu4.add(stoprun);
        jMenu4.add(jSeparator10);

        debug.setText("Debbuging");
        jMenu4.add(debug);

        stopdebug.setText("Stop Debbuging");
        jMenu4.add(stopdebug);
        jMenu4.add(jSeparator11);

        jMenuBar1.add(jMenu4);

        jMenu7.setText("Terminal");

        jMenuItem32.setText("View Problem");
        jMenu7.add(jMenuItem32);

        jMenuBar1.add(jMenu7);

        jMenu6.setText("Help");

        jMenuItem34.setText("Edit ShortCut");
        jMenu6.add(jMenuItem34);

        usm.setText("User Manual");
        jMenu6.add(usm);
        jMenu6.add(jSeparator13);

        jav.setText("Java Library");
        jMenu6.add(jav);

        kot.setText("Kotlin Library");
        kot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kotActionPerformed(evt);
            }
        });
        jMenu6.add(kot);

        ht.setText("HTML Library");
        jMenu6.add(ht);
        jMenu6.add(jSeparator14);

        about.setText("About");
        jMenu6.add(about);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1135, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void closeproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeproActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_closeproActionPerformed

    private void findActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findActionPerformed
        int tabIndex = tabbedPane.getSelectedIndex(); // Obtén el índice de la pestaña activa

        if (tabIndex != -1) {
            Component tabComponent = tabbedPane.getComponentAt(tabIndex);

            if (tabComponent instanceof TextAreaWithLineNumber) {
                TextAreaWithLineNumber tx = (TextAreaWithLineNumber) tabComponent;
                String palabraBuscar = JOptionPane.showInputDialog(this, "Ingrese la palabra que desea buscar:", "Buscar Palabra", JOptionPane.QUESTION_MESSAGE);

                if (palabraBuscar != null && !palabraBuscar.isEmpty()) {
                    tx.buscar(palabraBuscar); // Llama al método buscar con la palabra a buscar
                }
            }
        }
    }//GEN-LAST:event_findActionPerformed

    private void debconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_debconActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_debconActionPerformed

    private void wwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wwActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wwActionPerformed

    private void kotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kotActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kotActionPerformed

    private void jbMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMenu4ActionPerformed
        menuEmergente.show(jbMenu4, 0, jbMenu4.getHeight());
    }//GEN-LAST:event_jbMenu4ActionPerformed

    private void jbMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMenu5ActionPerformed
        // TODO add your handling code here:
        cf.setVisible(true);
        cf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }//GEN-LAST:event_jbMenu5ActionPerformed

    private void jbMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMenu3ActionPerformed
        int tabIndex = tabbedPane.getSelectedIndex();
        if (tabIndex != -1) {
            Component tabComponent = tabbedPane.getComponentAt(tabIndex);
            if (tabComponent instanceof TextAreaWithLineNumber) {
                TextAreaWithLineNumber tx = (TextAreaWithLineNumber) tabComponent;
                String palabraBuscar = JOptionPane.showInputDialog(this, "Ingrese la palabra que desea buscar:", "Buscar Palabra", JOptionPane.QUESTION_MESSAGE);
                if (palabraBuscar != null && !palabraBuscar.isEmpty()) {
                    String palabraReemplazar = JOptionPane.showInputDialog(this, "Ingrese la palabra con la que desea reemplazar:", "Reemplazar Palabra", JOptionPane.QUESTION_MESSAGE);
                    if (palabraReemplazar != null) {
                        tx.buscarYReemplazarTexto(palabraBuscar, palabraReemplazar);
                    }
                }
            }
        }
    }//GEN-LAST:event_jbMenu3ActionPerformed

    private void jbMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMenu2ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            metodo_barraMenu.openFile(tabbedPane, selectedFile);
        }
    }//GEN-LAST:event_jbMenu2ActionPerformed

    private void jbMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMenu1ActionPerformed
        if (sp.getIsOpen()) {
            sp.closeMenu();
            jbMenu1.setText("");
            jbMenu2.setText("");
            jbMenu3.setText("");
            jbMenu4.setText("");
            jbMenu5.setText("");
            jbMenu6.setText("");
        } else {
            sp.openMenu();
            jbMenu1.setText(" Menu                               ");
            jbMenu2.setText(" Open Directory               ");
            jbMenu3.setText(" Search/replace               ");
            jbMenu4.setText(" Account                            ");
            jbMenu5.setText(" Configuration                 ");
            jbMenu6.setText(" Run&Debug                    ");
        }
    }//GEN-LAST:event_jbMenu1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        output.setText("Name: configuracion.java	"
                + "Type: File Extension: java Can (R/W): R|W \nPath:"
                + "C:\\Users\\haojie.li\\Desktop\\TextEditor\\src\\ide\\configuracion.java \n"
                + "Last modified: Fri Nov 03 10:15:10 CET 2023	\n"
                + "Hidden: false	\n"
                + "Size: 9802 bytes ");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        output.setText("Microsoft Windows [Versión 10.0.22621.2428]\n"
                + "(c) Microsoft Corporation. Todos los derechos reservados.\n"
                + "\n"
                + "C:\\Users\\Administrator>");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        metodo_barraMenu.newFile(tabbedPane);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jbMenu6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMenu6ActionPerformed
        output.setText("Debugging...");

        try {
            Timer timer1 = new Timer(1000, (ActionEvent e) -> {
                output.setText("Starting...");

                // Inicia el segundo temporizador después de mostrar "Starting"
                Timer timer2 = new Timer(500, (ActionEvent e2) -> {
                    output.setText("Finished compiling..."
                            + "\nRunning");
                    executeCmd();
                });
                timer2.setRepeats(false);
                timer2.start();
            });
            timer1.setRepeats(false);
            timer1.start();
        } catch (Exception ex) {
            // Manejo de excepciones, por ejemplo, mostrar un mensaje de error
            output.setText("Error al iniciar el temporizador: " + ex.getMessage());
        }
    }//GEN-LAST:event_jbMenu6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JOptionPane.showMessageDialog(null, "No hay notificaciones recientes", "Notification", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void undoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_undoActionPerformed

    private void pasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pasteActionPerformed

    private void rundebugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rundebugActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rundebugActionPerformed

    private void duplicateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duplicateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_duplicateActionPerformed

    private void tggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tggActionPerformed
        boolean bol = tgg.isSelected();
        String themeName = bol ? "DarkLaf" : "LightLaf";

        if (bol) {
            setDarkLafTheme();
            metodo_menu.svgIcon(tgg, "src/svg/dark.svg", 25, 25);

        } else {
            setLightLafTheme();
            metodo_menu.svgIcon(tgg, "src/svg/light.svg", 25, 25);

        }

        // Guardar la configuración del tema en el archivo JSON
        themeConfig.setThemeName(themeName);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("src/json/config.json")) {
            gson.toJson(themeConfig, writer);
        } catch (IOException e) {
            System.out.println("Error saving theme configuration.");
        }
    }//GEN-LAST:event_tggActionPerformed

    private void openfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openfileActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            metodo_barraMenu.openFile(tabbedPane, selectedFile);
        }
    }//GEN-LAST:event_openfileActionPerformed

    private void closefileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closefileActionPerformed
        // TODO add your handling code here:
        metodo_barraMenu.closeFile(jPanel2);
    }//GEN-LAST:event_closefileActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        int tabIndex = tabbedPane.getSelectedIndex(); // Obtén el índice de la pestaña activa

        if (tabIndex != -1) {
            Component tabComponent = tabbedPane.getComponentAt(tabIndex);

            if (tabComponent instanceof TextAreaWithLineNumber) {
                TextAreaWithLineNumber tx = (TextAreaWithLineNumber) tabComponent;

                // Llama al método de guardarArchivo en la pestaña activa
                tx.guardarArchivo();
            }
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void replaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_replaceActionPerformed
        int tabIndex = tabbedPane.getSelectedIndex(); // Obtén el índice de la pestaña activa

        if (tabIndex != -1) {
            Component tabComponent = tabbedPane.getComponentAt(tabIndex);

            if (tabComponent instanceof TextAreaWithLineNumber) {
                TextAreaWithLineNumber tx = (TextAreaWithLineNumber) tabComponent;
                String palabraBuscar = JOptionPane.showInputDialog(this, "Ingrese la palabra que desea buscar:", "Buscar Palabra", JOptionPane.QUESTION_MESSAGE);

                if (palabraBuscar != null && !palabraBuscar.isEmpty()) {
                    String palabraReemplazar = JOptionPane.showInputDialog(this, "Ingrese la palabra con la que desea reemplazar:", "Reemplazar Palabra", JOptionPane.QUESTION_MESSAGE);

                    if (palabraReemplazar != null) {
                        tx.buscarYReemplazarTexto(palabraBuscar, palabraReemplazar); // Llama al método buscarYReemplazar con las palabras
                    }
                }
            }
        }

    }//GEN-LAST:event_replaceActionPerformed

    //Metodos
    public void setIcons() {
        metodo_menu.svgIcon(jbMenu1, "src/svg/bookmarkGroup.svg", 25, 25);
        metodo_menu.svgIcon(jbMenu2, "src/svg/copy.svg", 30, 30);
        metodo_menu.svgIcon(jbMenu3, "src/svg/search.svg", 30, 30);
        metodo_menu.svgIcon(jbMenu4, "src/svg/user.svg", 25, 25);
        metodo_menu.svgIcon(jbMenu5, "src/svg/settings.svg", 25, 25);
        metodo_menu.svgIcon(jbMenu6, "src/svg/debug.svg", 30, 30);

        metodo_menu.svgIcon(jButton3, "src/svg/notificacion.svg", 30, 30);
        jButton3.setBorderPainted(false);

        metodo_menu.svgIcon(jMenuItem1, "src/svg/proyecto.svg", 18, 18);
        metodo_menu.svgIcon(jMenuItem2, "src/svg/newfile.svg", 22, 22);
        metodo_menu.svgIcon(jMenuItem5, "src/svg/savefile.svg", 22, 22);
        metodo_menu.svgIcon(jMenuItem6, "src/svg/saveall.svg", 18, 18);

        metodo_menu.svgIcon(undo, "src/svg/undo.svg", 18, 18);
        metodo_menu.svgIcon(redo, "src/svg/redo.svg", 18, 18);

        metodo_menu.svgIcon(copy, "src/svg/copy2.svg", 18, 18);
        metodo_menu.svgIcon(cut, "src/svg/menu-cut.svg", 18, 18);
        metodo_menu.svgIcon(paste, "src/svg/menu-paste.svg", 18, 18);

        metodo_menu.svgIcon(closefile, "src/svg/closefile.svg", 18, 18);
        metodo_menu.svgIcon(openfile, "src/svg/openfile.svg", 15, 16);

        metodo_menu.svgIcon(copyfile, "src/svg/copyfile.svg", 18, 18);
        metodo_menu.svgIcon(delfile, "src/svg/deletefile.svg", 18, 18);

        metodo_menu.svgIcon(find, "src/svg/finding.svg", 18, 18);
        metodo_menu.svgIcon(replace, "src/svg/replacing.svg", 18, 18);

        metodo_menu.svgIcon(up, "src/svg/up.svg", 18, 18);
        metodo_menu.svgIcon(down, "src/svg/down.svg", 18, 18);
        metodo_menu.svgIcon(all, "src/svg/all.svg", 18, 18);
        metodo_menu.svgIcon(duplicate, "src/svg/duplicate.svg", 18, 18);

        metodo_menu.svgIcon(terminal, "src/svg/terminal.svg", 18, 18);
        metodo_menu.svgIcon(outputItem, "src/svg/output.svg", 15, 15);
        metodo_menu.svgIcon(debcon, "src/svg/debcon.svg", 20, 20);
        metodo_menu.svgIcon(appa, "src/svg/apa.svg", 20, 20);
        metodo_menu.svgIcon(zoom, "src/svg/zoom.svg", 15, 15);
        metodo_menu.svgIcon(ww, "src/svg/ww.svg", 20, 20);

        metodo_menu.svgIcon(run, "src/svg/run.svg", 20, 20);
        metodo_menu.svgIcon(rundebug, "src/svg/rundeb.svg", 20, 20);

        metodo_menu.svgIcon(stoprun, "src/svg/stop.svg", 20, 20);
        metodo_menu.svgIcon(debug, "src/svg/debug2.svg", 20, 20);
        metodo_menu.svgIcon(stopdebug, "src/svg/stop.svg", 20, 20);

        metodo_menu.svgIcon(jMenuItem34, "src/svg/keyb.svg", 20, 20);
        metodo_menu.svgIcon(usm, "src/svg/usm.svg", 23, 23);

        metodo_menu.svgIcon(jav, "src/svg/java.svg", 25, 25);
        metodo_menu.svgIcon(kot, "src/svg/kotlin.svg", 20, 20);
        metodo_menu.svgIcon(ht, "src/svg/html.svg", 25, 25);
        metodo_menu.svgIcon(about, "src/svg/about.svg", 25, 25);

        metodo_menu.svgIcon(tgg, "src/svg/light.svg", 25, 25);
        tgg.setFocusPainted(true);
        tgg.setBorderPainted(true);
        tgg.setContentAreaFilled(false);
    }

    private JTextComponent getCurrentTextComponent(int index) {
        if (index >= 0 && index < tabbedPane.getTabCount()) {
            Component selectedComponent = tabbedPane.getComponentAt(index);
            if (selectedComponent instanceof JScrollPane) {
                JScrollPane scrollPane = (JScrollPane) selectedComponent;
                JViewport viewport = scrollPane.getViewport();
                Component view = viewport.getView();
                if (view instanceof JTextComponent) {
                    return (JTextComponent) view;
                }
            }
        }
        return null;
    }

    //llamar cmd
    public static void executeCmd() {
        Runtime r = Runtime.getRuntime();
        String comando = "cmd.exe /c start";
        Process p;
        try {
            p = r.exec(comando);
        } catch (IOException e) {
            System.out.println("Error al ejecutar el símbolo del sistema (cmd)");
        }
    }

    /*json temas*/
    private void loadThemeConfig() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("src/json/config.json")) {
            themeConfig = gson.fromJson(reader, themes.class);

            if (themeConfig == null) {
                themeConfig = new themes();
            }

            String themeName = themeConfig.getThemeName();
            if ("DarkLaf".equals(themeName)) {
                setDarkLafTheme();
            } else {
                setLightLafTheme(); // Default to LightLaf
            }
        } catch (IOException e) {
            System.out.println("Error loading theme configuration.");
            themeConfig = new themes();
            setLightLafTheme(); // Default to LightLaf
        }
    }

    //set temas
    private void setDarkLafTheme() {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (UnsupportedLookAndFeelException e) {
            System.out.println("Failed to set DarkLaf theme");
        }
    }

    private void setLightLafTheme() {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (UnsupportedLookAndFeelException e) {
            System.out.println("Failed to set LightLaf theme");
        }
    }

    public static void main(String args[]) {
        FlatLightLaf.setup();
        new interfaz().setVisible(true);

        SwingUtilities.invokeLater(() -> {
            //PantallaCarga pantallaCarga = new PantallaCarga(null); // Pasa null como JFrame principal
            //pantallaCarga.setVisible(true);
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem about;
    private javax.swing.JMenuItem all;
    private javax.swing.JMenuItem appa;
    private javax.swing.JMenuItem closefile;
    private javax.swing.JMenuItem closepro;
    private javax.swing.JMenuItem copy;
    private javax.swing.JMenuItem copyfile;
    private javax.swing.JMenuItem cut;
    private javax.swing.JMenuItem debcon;
    private javax.swing.JMenuItem debug;
    private javax.swing.JMenuItem delfile;
    private javax.swing.JMenuItem down;
    private javax.swing.JMenuItem duplicate;
    private javax.swing.JMenuItem find;
    private javax.swing.JMenuItem ht;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem32;
    private javax.swing.JMenuItem jMenuItem34;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator14;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JMenuItem jav;
    private javax.swing.JButton jbMenu1;
    private javax.swing.JButton jbMenu2;
    private javax.swing.JButton jbMenu3;
    private javax.swing.JButton jbMenu4;
    private javax.swing.JButton jbMenu5;
    private javax.swing.JButton jbMenu6;
    private javax.swing.JMenuItem kot;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuItem openfile;
    private javax.swing.JTextArea output;
    private javax.swing.JMenuItem outputItem;
    private javax.swing.JMenuItem paste;
    private javax.swing.JMenuItem problem;
    private javax.swing.JMenuItem redo;
    private javax.swing.JMenuItem replace;
    private javax.swing.JMenuItem run;
    private javax.swing.JMenuItem rundebug;
    private javax.swing.JPanel sidebar;
    private javax.swing.JMenuItem stopdebug;
    private javax.swing.JMenuItem stoprun;
    private javax.swing.JMenuItem terminal;
    private javax.swing.JToggleButton tgg;
    private javax.swing.JMenuItem undo;
    private javax.swing.JMenuItem up;
    private javax.swing.JMenuItem usm;
    private javax.swing.JMenuItem ww;
    private javax.swing.JMenuItem zoom;
    // End of variables declaration//GEN-END:variables
}
