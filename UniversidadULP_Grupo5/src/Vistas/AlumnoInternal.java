/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import manipuladoresDAO.AlumnoDAO;
import universidadulp_grupo5.Alumno;

/**
 *
 * @author Enzo_2
 */
public class AlumnoInternal extends javax.swing.JInternalFrame {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    int selecId = 0;
//    Alumno alumno1;
//    boolean estado1;
    private AlumnoDAO maniAlum = new AlumnoDAO();
    static String[] columnas = {"id_alumno", "DNI", "Nombre", "Apellido", "Fecha Nacimiento", "Email", "Password", "Estado"};
    static DefaultTableModel modelo = new DefaultTableModel(null, columnas) {
        @Override
        public boolean isCellEditable(int a, int b) {
            return false;
        }
    };

    /**
     * Creates new form AlumnoInternal
     */
    public AlumnoInternal() {
        initComponents();
        this.setResizable(false);//para q no lo puedan expandir! :)
        this.setSize(1048, 660);
        armarCabecerayLlenar(tablaAlumno);
        placeholderTxtFBuscarDNI();
        habilitarModificacion(cbHabilitarM);
    }

    //Método Clear
    private void clear() {
        txtDNI.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        jDFechaN.setDate(null);
        txtEmail.setText("");
        txtPassword.setText("");
    }

    //método refresh, vuelve a llamar a la base de datos y la carga en la tabla nuevamente.
    private void refreshTabla() {
        modelo.setRowCount(0);

        ArrayList<Alumno> lista = maniAlum.listar();
        String fecha = "";

        if (!lista.isEmpty()) {
            for (Alumno alum : lista) {
                fecha = alum.getFecha_nacimiento().format(dtf);
                Object[] fila = {
                    alum.getId_alumno(),
                    alum.getDni(),
                    alum.getNombre(),
                    alum.getApellido(),
                    fecha,
                    alum.getEmail(),
                    alum.getPassword(),
                    alum.isEstado()
                };
                modelo.addRow(fila);
            }
        }
    }

    //Arma la cabecera y carga con el método refresh 
    private void armarCabecerayLlenar(JTable tabla) {
        //Cabecera
        tabla.setModel(modelo);
        tabla.setModel(modelo);
        TableColumnModel modeloColumnas = tabla.getColumnModel();
        TableColumn columnID = modeloColumnas.getColumn(0);
        columnID.setMinWidth(0);
        columnID.setPreferredWidth(0);
        columnID.setMaxWidth(0);
        columnID.setResizable(false);

        //Relleno        
        refreshTabla();
    }

    //Placeholder en txt buscar por DNI
    private void placeholderTxtFBuscarDNI() {
        txtFBuscarDNI.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (txtFBuscarDNI.getText().equals("Ingrese DNI sin puntos")) {
                    txtFBuscarDNI.setText("");
                    txtFBuscarDNI.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (txtFBuscarDNI.getText().equals("")) {
                    txtFBuscarDNI.setText("Ingrese DNI sin puntos");
                    txtFBuscarDNI.setForeground(Color.GRAY);
                }
            }
        });
    }

    //Habilitar Modificación
    private void habilitarModificacion(JCheckBox jcb) {

        jcb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                boolean selec = jcb.isSelected();
                if (selec != false) {
                    txtDNI.setEditable(true);
                    txtNombre.setEnabled(true);
                    txtApellido.setEnabled(true);
                    jDFechaN.setEnabled(true);
                    txtEmail.setEnabled(true);
                    txtPassword.setEnabled(true);
                    btnDarAlta.setEnabled(true);
                    btnDarBaja.setEnabled(true);
                    btnEliminar.setEnabled(true);
                    btnModificar.setEnabled(true);
                } else {
                    txtDNI.setEnabled(false);
                    txtNombre.setEnabled(false);
                    txtApellido.setEnabled(false);
                    jDFechaN.setEnabled(false);
                    txtEmail.setEnabled(false);
                    txtPassword.setEnabled(false);
                    btnDarAlta.setEnabled(false);
                    btnDarBaja.setEnabled(false);
                    btnEliminar.setEnabled(false);
                    btnModificar.setEnabled(false);
                }
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        txtFBuscarDNI = new javax.swing.JTextField();
        lblBuscarDNI = new javax.swing.JLabel();
        PanelTabla = new javax.swing.JScrollPane();
        tablaAlumno = new javax.swing.JTable();
        imgULP = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblFechaNacimiento = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblDNI = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        jDFechaN = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        cbHabilitarM = new javax.swing.JCheckBox();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnDarAlta = new javax.swing.JButton();
        btnDarBaja = new javax.swing.JButton();

        setResizable(true);

        Panel.setBackground(new java.awt.Color(47, 96, 131));
        Panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblTitulo.setFont(new java.awt.Font("URW Gothic", 1, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("GESTION DE ALUMNOS");
        lblTitulo.setToolTipText("");

        txtFBuscarDNI.setForeground(new java.awt.Color(161, 154, 147));
        txtFBuscarDNI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFBuscarDNI.setText("Ingrese DNI sin puntos");
        txtFBuscarDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFBuscarDNIActionPerformed(evt);
            }
        });

        lblBuscarDNI.setFont(new java.awt.Font("URW Gothic", 1, 14)); // NOI18N
        lblBuscarDNI.setForeground(new java.awt.Color(255, 255, 255));
        lblBuscarDNI.setText("Buscar por DNI:");

        tablaAlumno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaAlumnoMouseClicked(evt);
            }
        });
        PanelTabla.setViewportView(tablaAlumno);

        imgULP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgULP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logoULP.png"))); // NOI18N

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(47, 96, 131));

        lblNombre.setFont(new java.awt.Font("URW Gothic", 1, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre:");

        lblApellido.setFont(new java.awt.Font("URW Gothic", 1, 18)); // NOI18N
        lblApellido.setForeground(new java.awt.Color(255, 255, 255));
        lblApellido.setText("Apellido:");

        lblFechaNacimiento.setFont(new java.awt.Font("URW Gothic", 1, 18)); // NOI18N
        lblFechaNacimiento.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaNacimiento.setText("Fecha N. :");

        lblEmail.setFont(new java.awt.Font("URW Gothic", 1, 18)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("Email:");

        lblPassword.setFont(new java.awt.Font("URW Gothic", 1, 18)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword.setText("Password:");

        lblDNI.setFont(new java.awt.Font("URW Gothic", 1, 18)); // NOI18N
        lblDNI.setForeground(new java.awt.Color(255, 255, 255));
        lblDNI.setText("DNI:");

        txtDNI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDNI.setEnabled(false);

        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombre.setEnabled(false);

        txtApellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtApellido.setEnabled(false);

        txtEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmail.setEnabled(false);

        txtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPassword.setEnabled(false);

        jDFechaN.setBackground(new java.awt.Color(47, 96, 131));
        jDFechaN.setEnabled(false);

        jPanel2.setBackground(new java.awt.Color(47, 96, 131));
        jPanel2.setPreferredSize(new java.awt.Dimension(266, 208));

        cbHabilitarM.setForeground(new java.awt.Color(255, 255, 255));
        cbHabilitarM.setText("Habilitar modificación");

        btnAgregar.setFont(new java.awt.Font("URW Gothic", 0, 12)); // NOI18N
        btnAgregar.setText("Agregar Alumno");
        btnAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("URW Gothic", 0, 12)); // NOI18N
        btnEliminar.setText("Eliminar Alumno");
        btnEliminar.setEnabled(false);
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("URW Gothic", 0, 12)); // NOI18N
        btnModificar.setText("Modificar Alumno");
        btnModificar.setEnabled(false);
        btnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnDarAlta.setFont(new java.awt.Font("URW Gothic", 0, 12)); // NOI18N
        btnDarAlta.setText("Dar de Alta");
        btnDarAlta.setEnabled(false);
        btnDarAlta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDarAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDarAltaActionPerformed(evt);
            }
        });

        btnDarBaja.setFont(new java.awt.Font("URW Gothic", 0, 12)); // NOI18N
        btnDarBaja.setText("Dar de Baja");
        btnDarBaja.setEnabled(false);
        btnDarBaja.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDarBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDarBajaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbHabilitarM)
                .addGap(58, 58, 58))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 45, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDarBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDarAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbHabilitarM)
                .addGap(17, 17, 17)
                .addComponent(btnAgregar)
                .addGap(11, 11, 11)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModificar)
                .addGap(11, 11, 11)
                .addComponent(btnDarAlta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDarBaja)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblDNI)
                            .addComponent(lblNombre)
                            .addComponent(lblApellido)
                            .addComponent(lblFechaNacimiento)
                            .addComponent(lblEmail)
                            .addComponent(lblPassword))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDNI)
                            .addComponent(txtNombre)
                            .addComponent(txtApellido)
                            .addComponent(txtEmail)
                            .addComponent(txtPassword)
                            .addComponent(jDFechaN, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDNI)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellido)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblFechaNacimiento)
                    .addComponent(jDFechaN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblApellido, lblDNI, lblEmail, lblFechaNacimiento, lblNombre, lblPassword, txtApellido, txtDNI, txtEmail, txtNombre, txtPassword});

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgULP)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(81, 81, 81))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblBuscarDNI)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFBuscarDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PanelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(25, Short.MAX_VALUE))))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imgULP))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBuscarDNI)
                            .addComponent(txtFBuscarDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        JFrame padre = (JFrame) SwingUtilities.getWindowAncestor(this);
        DialogAlumno ventana = new DialogAlumno(padre);
        ventana.setVisible(true);
        refreshTabla();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tablaAlumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAlumnoMouseClicked
        int filaSelec = tablaAlumno.getSelectedRow();
        if (filaSelec != -1) {
            selecId = (int) tablaAlumno.getValueAt(filaSelec, 0);
            int dni = (int) tablaAlumno.getValueAt(filaSelec, 1);
            String nombre = (String) tablaAlumno.getValueAt(filaSelec, 2);
            String apellido = (String) tablaAlumno.getValueAt(filaSelec, 3);
            String fecha = (String) tablaAlumno.getValueAt(filaSelec, 4);
            String email = (String) tablaAlumno.getValueAt(filaSelec, 5);
            String pass = (String) tablaAlumno.getValueAt(filaSelec, 6);

            LocalDate fecha1 = LocalDate.parse(fecha, dtf);
            Date fechaD = java.sql.Date.valueOf(fecha1);

            txtDNI.setText(dni + "");
            txtNombre.setText(nombre);
            txtApellido.setText(apellido);
            jDFechaN.setDate(fechaD);
            txtEmail.setText(email);
            txtPassword.setText(pass);
        }
    }//GEN-LAST:event_tablaAlumnoMouseClicked

    private void txtFBuscarDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFBuscarDNIActionPerformed
        // TODO add your handling code here:
        int dni = Integer.parseInt(txtFBuscarDNI.getText());
        modelo.setRowCount(0);

        Alumno alum = maniAlum.buscarPorDNI(dni);

        String fecha = "";
        boolean estado = true;
        fecha = alum.getFecha_nacimiento().format(dtf);

        Object[] fila = {
            alum.getId_alumno(),
            alum.getDni(),
            alum.getNombre(),
            alum.getApellido(),
            fecha,
            alum.getEmail(),
            alum.getPassword(),
            estado
        };
        modelo.addRow(fila);

        txtFBuscarDNI.setText("");
    }//GEN-LAST:event_txtFBuscarDNIActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        maniAlum.eliminar(selecId);
        clear();
        refreshTabla();
        JOptionPane.showMessageDialog(this, "Alumno eliminado con éxito.");
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        
        try {            
            txtDNI.setEditable(false);
            if (txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || jDFechaN.getDate() == null
                    || txtEmail.getText().isEmpty() || txtPassword.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos deben llenarse.");

            } else {
                
                String nombre = txtNombre.getText();
                String apellido = txtApellido.getText();
                LocalDate fn = jDFechaN.getDate().toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate();
                String email = txtEmail.getText();
                String pass = txtPassword.getText();
                
                Alumno alum = maniAlum.buscarPorId(selecId);
                
                alum.setNombre(nombre);
                alum.setApellido(apellido);
                alum.setFecha_nacimiento(fn);
                alum.setEmail(email);
                alum.setPassword(pass);

                maniAlum.actualizar(alum);
                clear();
                refreshTabla();
                JOptionPane.showMessageDialog(this, "Alumno modificado con éxito.");

            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Dato Incorrecto, se espera un DNI");
        }
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnDarAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDarAltaActionPerformed

        Alumno alum = maniAlum.buscarPorId(selecId);

        alum.setEstado(true);

        maniAlum.actualizar(alum);

        refreshTabla();

        JOptionPane.showMessageDialog(this, "Se ha dado de alta al alumno: \n" + alum.getApellido() + alum.getNombre());
    }//GEN-LAST:event_btnDarAltaActionPerformed

    private void btnDarBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDarBajaActionPerformed

        Alumno alum = maniAlum.buscarPorId(selecId);

        boolean estado = false;

        alum.setEstado(estado);

        maniAlum.actualizar(alum);

        refreshTabla();

        JOptionPane.showMessageDialog(this, "Se ha dado de baja al alumno: \n" + alum.getApellido() + alum.getNombre());
    }//GEN-LAST:event_btnDarBajaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private javax.swing.JScrollPane PanelTabla;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnDarAlta;
    private javax.swing.JButton btnDarBaja;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JCheckBox cbHabilitarM;
    private javax.swing.JLabel imgULP;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDFechaN;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblBuscarDNI;
    private javax.swing.JLabel lblDNI;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tablaAlumno;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFBuscarDNI;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPassword;
    // End of variables declaration//GEN-END:variables
}
