/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Enum.GenerosMusicales;
import Enum.Sexo;
import Repositorios.Control;
import TextPrompt.TextPrompt;
import com.mongodb.client.MongoDatabase;
import entity.Usuario;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author laura
 */
public class FrmUsuario extends javax.swing.JFrame {

    Control control;
    Usuario usuario;
    MongoDatabase database;
    List<String> peliculas;

    /**
     * Método contructor que se encarga de inicializar el frame.
     *
     * @param padre Frame donde es llamado.
     * @param database Base de datos de Faceboot
     * @param usuario Usuario que ingreso al sistema o si se va a registrar es
     * null.
     */
    public FrmUsuario(Frame padre, MongoDatabase database, Usuario usuario) {
        initComponents();
        this.setTitle("Faceboot");
        this.setLocationRelativeTo(null);
        control = new Control();
        this.usuario = usuario;
        this.database = database;
                
        /*
        Si el frame es utilizado para editar entonces todos los campos
        se inhabilitan para que se muestren solamente los valores del usuario y
        el boton se cambia a editar que despues se encarga de habilitar los campos.
         */
        if (usuario != null) {
            mostrarInformacion();
            txtNombre.setEditable(false);
            txtCorreo.setEditable(false);
            txtEdad.setEditable(false);
            txtFechaNacimiento.setEditable(false);
            cbSexo.setEditable(false);
            txtContrasenia.setEditable(false);
            txtContrasenia2.setEditable(false);
            txtPelicula.setEditable(false);
            jlGenerosMusicales.setEnabled(false);
            jlPeliculas.setEnabled(false);            
            btnAceptar.setText("Editar");
            peliculas = usuario.getPeliculas();

        } else {
            /*
            El frame es utilizado para registrar entonces el boton se nombra a Guardar
            y se llenan los campos de generos de peliculas y el sexo.
             */
            btnAceptar.setText("Guardar");
            llenarCampos();
            peliculas = new ArrayList<>();
            mensajeCamposTexto();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateTimePicker1 = new com.github.lgooddatepicker.components.DateTimePicker();
        jPanel1 = new javax.swing.JPanel();
        lblRegistroUsuario = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        lblNombre1 = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtFechaNacimiento = new javax.swing.JTextField();
        lblFechaNacimiento = new javax.swing.JLabel();
        cbSexo = new javax.swing.JComboBox<>();
        txtEdad = new javax.swing.JTextField();
        lblSexo = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        lblGenerosMusicales = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlPeliculas = new javax.swing.JList<>();
        lblPeliculas = new javax.swing.JLabel();
        txtPelicula = new javax.swing.JTextField();
        lblContrasenia = new javax.swing.JLabel();
        btnAgregarPelicula = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblIconoPeliculas = new javax.swing.JLabel();
        lblIconoMusica = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlGenerosMusicales = new javax.swing.JList<>();
        txtContrasenia = new javax.swing.JPasswordField();
        txtContrasenia2 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registrar usuario");
        setIconImage(getIconImage());

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblRegistroUsuario.setText("Usuario");
        lblRegistroUsuario.setFont(new java.awt.Font("Calibri Light", 0, 28)); // NOI18N
        lblRegistroUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lblRegistroUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, 40));

        lblUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/avatar user.png"))); // NOI18N
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, 50));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 214, -1));

        lblNombre1.setText("Nombre completo:");
        lblNombre1.setBackground(new java.awt.Color(51, 51, 51));
        lblNombre1.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jPanel2.add(lblNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        lblCorreo.setText("Correo electronico:");
        lblCorreo.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jPanel2.add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        txtCorreo.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        jPanel2.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 214, -1));

        txtFechaNacimiento.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        txtFechaNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaNacimientoActionPerformed(evt);
            }
        });
        txtFechaNacimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFechaNacimientoKeyReleased(evt);
            }
        });
        jPanel2.add(txtFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 214, -1));

        lblFechaNacimiento.setText("Fecha de nacimiento:");
        lblFechaNacimiento.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jPanel2.add(lblFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        cbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cbSexo.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jPanel2.add(cbSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, 151, -1));

        txtEdad.setEditable(false);
        txtEdad.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        txtEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadActionPerformed(evt);
            }
        });
        jPanel2.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 150, -1));

        lblSexo.setText("Sexo:");
        lblSexo.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jPanel2.add(lblSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, -1, -1));

        lblEdad.setText("Edad:");
        lblEdad.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jPanel2.add(lblEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, -1, -1));

        lblGenerosMusicales.setText("Generos Musicales:");
        lblGenerosMusicales.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jPanel2.add(lblGenerosMusicales, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jlPeliculas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlPeliculasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jlPeliculas);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 210, 80));

        lblPeliculas.setText("Peliculas:");
        lblPeliculas.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jPanel2.add(lblPeliculas, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, -1, -1));

        txtPelicula.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        txtPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPeliculaActionPerformed(evt);
            }
        });
        jPanel2.add(txtPelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 214, 30));

        lblContrasenia.setText("Contraseña:");
        lblContrasenia.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jPanel2.add(lblContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 480, -1, -1));

        btnAgregarPelicula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add.png"))); // NOI18N
        btnAgregarPelicula.setText("Agregar película");
        btnAgregarPelicula.setActionCommand("Agregar pelicula");
        btnAgregarPelicula.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregarPelicula.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        btnAgregarPelicula.setToolTipText("Agregar película");
        btnAgregarPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPeliculaActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregarPelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 190, 50));

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/si.png"))); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAceptar.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        btnAceptar.setToolTipText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 460, 190, 40));

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/prohibido.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelar.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        btnCancelar.setToolTipText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(421, 520, 190, 40));

        lblIconoPeliculas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/pelicula.png"))); // NOI18N
        jPanel2.add(lblIconoPeliculas, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 40, 30));

        lblIconoMusica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/pista.png"))); // NOI18N
        jPanel2.add(lblIconoMusica, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, -1, -1));

        jScrollPane2.setViewportView(jlGenerosMusicales);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 214, 117));
        jPanel2.add(txtContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 480, 210, 30));
        jPanel2.add(txtContrasenia2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 530, 210, 30));

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel1.setText("Confirmar contraseña:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 160, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bloq-mayus.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 500, 40, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtFechaNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaNacimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaNacimientoActionPerformed

    private void txtEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        /*
        Si el boton dice "Editar" entonces lo que hara es habilitar todos los campos
        para que el usuario pueda editar sus datos entonces el nombre del boton cambia 
        a Actualizar, para actualizar todos sus valores.
         */
        if (btnAceptar.getText().equalsIgnoreCase("Editar")) {
            txtNombre.setEditable(true);
            txtCorreo.setEditable(true);
            txtEdad.setEditable(true);
            txtFechaNacimiento.setEditable(true);
            cbSexo.setEditable(true);
            txtContrasenia.setEditable(true);
            txtContrasenia2.setEditable(true);
            jlGenerosMusicales.setEnabled(true);
            jlPeliculas.setEnabled(true);
            txtPelicula.setEditable(true);
            llenarCampos();
            btnAceptar.setText("Actualizar");
        } /*
        Si el boton dice "Actualizar" entonces se actualizan los nuevos datos 
        ingresados por el usuario.
         */ else if (btnAceptar.getText().equalsIgnoreCase("Actualizar")) {
            actualizar();
        } else {
            /*
            Si el boton dice "Guardar" entonces la información se registra por primera
            vez en la base de datos.
             */
            guardar();
        }

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        FrmPantallaInicio fmPantallaInicio = new FrmPantallaInicio(this, this.database, this.usuario);
        fmPantallaInicio.show();
        setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPeliculaActionPerformed

        //Se agrega la pelicula indicada en la lista
        peliculas.add(txtPelicula.getText());

        //Se limpia el campo para ingresar otra pelicula
        txtPelicula.setText("");

        //En un medelo de List se agrega todas las peliculas de la lista
        DefaultListModel listModel = new DefaultListModel();
        for (String pelicula : peliculas) {
            listModel.addElement(pelicula);
        }

        //Se agrega el modelo a la lista visual de la peliculas.
        jlPeliculas.setModel(listModel);
    }//GEN-LAST:event_btnAgregarPeliculaActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        if (!String.valueOf(evt.getKeyChar()).matches("^[a-zA-Z ñáéíóú]$")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtFechaNacimientoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaNacimientoKeyReleased

    }//GEN-LAST:event_txtFechaNacimientoKeyReleased

    private void txtPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPeliculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPeliculaActionPerformed

    private void jlPeliculasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlPeliculasMouseClicked
        //Se obtienen las peliculas que se desean eliminar.
        DefaultListModel modelo = (DefaultListModel) jlPeliculas.getModel();
        int index = jlPeliculas.getSelectedIndex();
        modelo.remove(index);

        //Se eliminan de la lista
        peliculas.remove(index);

    }//GEN-LAST:event_jlPeliculasMouseClicked
    /**
     * Método que se encarga de mostrar la información del usuario en los campos
     */
    public void mostrarInformacion() {
        //Muestra informacion en los campos de texto
        txtNombre.setText(usuario.getNombre());
        txtCorreo.setText(usuario.getCorreo());
        txtEdad.setText(String.valueOf(usuario.getEdad()));

        //Se le da un formato a la fecha
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String fechaTexto = formatter.format(usuario.getFechaNacimiento());

        //Muestra información en los campos de texto
        txtFechaNacimiento.setText(fechaTexto);
        //Llenar sexo
        DefaultComboBoxModel sexo = new DefaultComboBoxModel();
        sexo.addElement(Sexo.femenino);
        sexo.addElement(Sexo.masculino);
        cbSexo.setModel(sexo);
        cbSexo.setSelectedItem(usuario.getSexo());
        txtContrasenia.setText(usuario.getContrasenia());
        txtContrasenia2.setText(usuario.getContrasenia());

        //Muestra las peliculas del usuario
        DefaultListModel listModel = new DefaultListModel();
        for (String pelicula : usuario.getPeliculas()) {
            listModel.addElement(pelicula);
        }
        jlPeliculas.setModel(listModel);

        //Muestra los generos musicales del usuario
        DefaultListModel gm = new DefaultListModel();
        for (GenerosMusicales generos : usuario.getGenerosMusicales()) {
            gm.addElement(generos);
        }
        jlGenerosMusicales.setModel(gm);
    }

    /**
     * Método que se encarga de actualizar los valores del usuario.
     */
    private void actualizar() {
        if (validarFecha()) {
            //Se obtiene la fecha de nacimiento
            String fecha = txtFechaNacimiento.getText();
            
            //Se le agrega un formato a la fecha
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy/MM/dd");
            Date fechaNacimiento = null;
            try {
                fechaNacimiento = formatoDelTexto.parse(txtFechaNacimiento.getText());
            } catch (java.text.ParseException ex) {
                ex.printStackTrace();
            }

            //Se obtiene la fecha de hoy.
            Date fechaHoy = new Date();

            //Se obtienen los generos musicales del usuario
            List<GenerosMusicales> gm = new ArrayList<>();
            for (int i = 0; i < jlGenerosMusicales.getSelectedValues().length; i++) {
                gm.add((GenerosMusicales) jlGenerosMusicales.getSelectedValues()[i]);
            }

            //Si el usuario no selecciono ningun genero musical, la lista sigue igual.
            if (gm.isEmpty()) {
                gm = usuario.getGenerosMusicales();
            }

            //Si los campos son correctos entonces se actualizan los datos.
            if (validarCampos() && validarCorreo() && validarContrasenia()) {
                //Se asignan los nuevos datos.
                usuario.setContrasenia(txtContrasenia.getText());                
                usuario.setCorreo(txtCorreo.getText());
                usuario.setEdad(calcularEdad(fechaNacimiento, fechaHoy));
                usuario.setFechaNacimiento(fechaNacimiento);
                usuario.setGenerosMusicales(gm);
                usuario.setNombre(txtNombre.getText());
                usuario.setPeliculas(peliculas);
                usuario.setSexo((Sexo) cbSexo.getSelectedItem());

                //Se guardan los cambios en la base de datos
                control.getUsuarioRepository().actualizar(control.getUsuarioRepository().crearCollection(database), usuario);
                txtEdad.setText(String.valueOf(calcularEdad(fechaNacimiento, fechaHoy)));

                //Se muestra un mensaje indicando que la operacion fue exitosa
                JOptionPane.showMessageDialog(this, "Se ha actualizado con exito el usuario.",
                        "Alerta", JOptionPane.INFORMATION_MESSAGE);

                //Regresa a la pantalla de inicio
                FrmPantallaInicio frmPantallaInicio = new FrmPantallaInicio(this, database, usuario);
                frmPantallaInicio.setVisible(true);
                this.setVisible(false);
            }
        }
    }

    /**
     * Método que se encarga de llenar los campos de generos musicales y sexo.
     */
    private void llenarCampos() {

        //Llenar lista de generos
        DefaultListModel listModel = new DefaultListModel();
        listModel.addElement(GenerosMusicales.Bachata);
        listModel.addElement(GenerosMusicales.Banda);
        listModel.addElement(GenerosMusicales.Norteño);
        listModel.addElement(GenerosMusicales.Pop);
        listModel.addElement(GenerosMusicales.Reggaeton);
        listModel.addElement(GenerosMusicales.Jazz);
        listModel.addElement(GenerosMusicales.Rock);
        listModel.addElement(GenerosMusicales.Country);
        listModel.addElement(GenerosMusicales.Electronica);
        jlGenerosMusicales.setModel(listModel);

        //Llenar sexo
        DefaultComboBoxModel sexo = new DefaultComboBoxModel();
        sexo.addElement(Sexo.femenino);
        sexo.addElement(Sexo.masculino);
        cbSexo.setModel(sexo);

    }

    /**
     * Método que se encarga de guardar por primera vez en la base de datos la
     * información registrada por el usuario.
     */
    private void guardar() {
        if (validarFecha()) {
            //Se obtiene la fecha de nacimiento
            String fecha = txtFechaNacimiento.getText();

            //Se le agrega un formato a la fecha
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy/MM/dd");
            Date fechaNacimiento = null;
            try {
                fechaNacimiento = formatoDelTexto.parse(txtFechaNacimiento.getText());
            } catch (java.text.ParseException ex) {
                ex.printStackTrace();
            }

            //Se obtiene la fecha de hoy.
            Date fechaHoy = new Date();

            //Se obtienen los generos musicales del usuario
            List<GenerosMusicales> gm = new ArrayList<>();
            for (int i = 0; i < jlGenerosMusicales.getSelectedValues().length; i++) {
                gm.add((GenerosMusicales) jlGenerosMusicales.getSelectedValues()[i]);
            }

            //Se validan los campos ingresados por el usuario.
            if (validarCampos() && validarCorreo() && validarContrasenia()) {

                //Crea un nuevo usuario con los valores indicados por el usuario.
                Usuario usuarioNuevo = new Usuario(txtNombre.getText(), txtCorreo.getText(), txtContrasenia.getText(), calcularEdad(fechaNacimiento, fechaHoy),
                        (Sexo) cbSexo.getSelectedItem(), gm, fechaNacimiento, peliculas);

                //Se guarda en la base de datos
                control.getUsuarioRepository().crearDocument(control.getUsuarioRepository().crearCollection(database), usuarioNuevo);
                txtEdad.setText(String.valueOf(calcularEdad(fechaNacimiento, fechaHoy)));

                //Se muestra un mensaje de operación exitosa
                JOptionPane.showMessageDialog(this, "Se ha registrado con exito el usuario.",
                        "Alerta", JOptionPane.INFORMATION_MESSAGE);

                //Regresa al frame de iniciar sesión
                FrmInicioSesion frmInicioSesión = new FrmInicioSesion();
                frmInicioSesión.setVisible(true);
                this.setVisible(false);
            }
        }
    }

    /**
     * Método que se encarga de calcular la edad del usuario en base a su fecha
     * de nacimiento.
     *
     * @param fechaNacimiento Fecha de nacimiento del usuario.
     * @param fechaActual Fecha actual.
     * @return Edad del usuario
     */
    public int calcularEdad(Date fechaNacimiento, Date fechaActual) {
        long diferencia = fechaActual.getTime() - fechaNacimiento.getTime();
        double dias = Math.floor(diferencia / (86400000));
        return (int) dias / 365;
    }

    /**
     * Método que se encarga de mostrar un mensaje en los campos de textos.
     */
    public void mensajeCamposTexto() {
        //Campo de nombre
        TextPrompt nombre = new TextPrompt("Obligatorio", txtNombre);
        //Correo electronico
        TextPrompt correo = new TextPrompt("Obligatorio", txtCorreo);
        //Fecha de nacimiento
        TextPrompt fecha = new TextPrompt("yyyy/MM/dd", txtFechaNacimiento);
        //Contraseña
        TextPrompt contrasenia = new TextPrompt("Obligatorio", txtContrasenia);
    }

    /**
     * Método que se encarga de validar los campos despues llenados por el
     * usuario.
     *
     * @return Confirma si los campos son correctos.
     */
    private boolean validarCampos() {

        //Valida si los campos estan llenos.
        if (!txtNombre.getText().isEmpty()
                && !txtFechaNacimiento.getText().isEmpty()
                && !txtCorreo.getText().isEmpty()
                && !txtContrasenia.getText().isEmpty()
                && !txtContrasenia2.getText().isEmpty()) {
            return true;
        }

        //Muestra un mensaje indicando si los campos estan llenos.
        JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios",
                "Alerta", JOptionPane.WARNING_MESSAGE);
        return false;
    }

    /**
     * Método que se encarga de validar si el correo ingresado fue en el formato
     * correcto
     *
     * @return Confirma si el correo ingresado es valido.
     */
    public boolean validarCorreo() {

        //Formato del correo electronico
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(txtCorreo.getText());
        if (mather.find() == true) {
            return true;
        } else {
            //Si el correo no esta en formato correcto se muestra un mensaje indicandolo.
            JOptionPane.showMessageDialog(this, "El correo ingresado es inválido.",
                    "Alerta", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    /**
     * Método que se encarga de validar si la fecha ingresada fue en el formato
     * correcto
     *
     * @return Confirma si la fecha ingresada es valido.
     */
    public boolean validarFecha() {
        //Formato de la fecha       
        Pattern pattern = Pattern
                .compile("^\\d{4}\\/(0[1-9]|1[012])\\/(0[1-9]|[12][0-9]|3[01])$");

        Matcher mather = pattern.matcher(txtFechaNacimiento.getText());
        if (mather.find() == true) {
            return true;
        } else {
            //Si la fecha no esta en formato correcto se muestra un mensaje indicandolo.
            JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto.",
                    "Alerta", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    
    public boolean validarContrasenia(){
        if(txtContrasenia.getText().equals(txtContrasenia2.getText())){
            return true;            
        }else{
            //Si las contraseñas ingresadas no son iguales se muestra un mensaje indicandolo.
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.",
                    "Alerta", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Iconos/marcas-y-logotipos.png"));
        return retValue;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregarPelicula;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> cbSexo;
    private com.github.lgooddatepicker.components.DateTimePicker dateTimePicker1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> jlGenerosMusicales;
    private javax.swing.JList<String> jlPeliculas;
    private javax.swing.JLabel lblContrasenia;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblGenerosMusicales;
    private javax.swing.JLabel lblIconoMusica;
    private javax.swing.JLabel lblIconoPeliculas;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblPeliculas;
    private javax.swing.JLabel lblRegistroUsuario;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField txtContrasenia;
    private javax.swing.JPasswordField txtContrasenia2;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPelicula;
    // End of variables declaration//GEN-END:variables
}
