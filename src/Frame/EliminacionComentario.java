/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Repositorios.Control;
import com.mongodb.client.MongoDatabase;
import entity.Comentario;
import entity.Post;
import entity.Usuario;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Estefanía Aguilar
 */
public class EliminacionComentario extends javax.swing.JFrame {

    /**
     * Creates new form EliminacionComentario
     */
    MongoDatabase basedatos;
    Control control;
    Usuario usuario;
    Post publicacion;

    /**
     * Método constructor que se encarga de inicializar el frame de eliminar comentarios.
     * @param usuario Usuario que inicio sesión.
     * @param publicacion Publicacion de la cual se van a mostrar los comentarios.
     * @param basedatos Base de datos Faceboot.
     */
    public EliminacionComentario(Usuario usuario, Post publicacion, MongoDatabase basedatos) {
        initComponents();
        this.setTitle("Faceboot");
        this.setLocationRelativeTo(null);
        control = new Control();
        this.basedatos = basedatos;
        this.usuario = usuario;
        this.publicacion = publicacion;
        mostrarComentarios();
    }
    /**
     * Método que se encarga de mostrar los comentarios de la publicación que solamente pertenescan
     * al usuario que inicio sesión.
     */
    public void mostrarComentarios() {
        //Se valida que todos los comentarios pertenescan al mismo usuario.
        DefaultListModel listModel = new DefaultListModel();
        for (Comentario comentario : publicacion.getComentarios()) {
            listModel.addElement(comentario);
        }
        jlComentarios.setModel(listModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlComentarios = new javax.swing.JList<>();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Comentarios");

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/marcas-y-logotipos.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jlComentarios.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(jlComentarios);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/basura.png"))); // NOI18N
        btnEliminar.setToolTipText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/prohibido.png"))); // NOI18N
        btnCancelar.setToolTipText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        //Lista con los comentarios que se van a eliminar.
        ArrayList<Comentario> comentarios = new ArrayList<>();
        //Lista con los comentarios nuevos.
        List<Comentario> comentariosNuevos = publicacion.getComentarios();
        //Recorre todas los comentarios seleccionados de la lista.
        for (int i = 0; i < jlComentarios.getSelectedValues().length; i++) {
            //Los comentarios seleccionadas se agregan a la lista.
            comentarios.add((Comentario) jlComentarios.getSelectedValues()[i]);
        }
        //Valida que se haya seleccionado al menos un comentario para eliminar.
        if (comentarios.size() > 0) {
            //Recorre la lista de publicaciones
            for (Comentario comentario : comentarios) {
                /*
                Valida que el comentario seleccionado le pertenezca al usuario o la publicacion haya sido creada
                por el usuario.
                 */
                if (comentario.getUsuario().getId().toString().equalsIgnoreCase(usuario.getId().toString()) 
                        || publicacion.getUsuario().getId().toString().equalsIgnoreCase(usuario.getId().toString())) {
                    //Se eliminan los comentarios seleccionados de la lista.
                    comentariosNuevos.removeAll(comentarios);
                    //Se actualiza en la publicación.
                    publicacion.setComentarios(comentariosNuevos);
                    //Actualiza la publicación en la base de datos.
                    control.getPostRepository().actualizar(
                            control.getPostRepository().crearCollection(basedatos), publicacion);
                    //Muestra un mensaje indicando que la operación fue exitosa
                    JOptionPane.showMessageDialog(this, "Operacion exitosa", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    //Actualiza la lista ya sin las publicaciones eliminadas.
                    mostrarComentarios();
                    //Regresa a la pantalla de inicio
                    FrmPantallaInicio frmpi = new FrmPantallaInicio(this, basedatos, usuario);
                    frmpi.setVisible(true);
                    this.setVisible(false);
                }else{
                    //Muestra un mensaje indicando que no se podra eliminar el comentario ya que no es propia del usuario
                    JOptionPane.showMessageDialog(this, "La publicación " + comentario.getTexto() + " no se puede eliminar ya que no es propia."
                            + " Vuelve a seleccionar los mensajes.", "Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
            
        } else {
            //Si no se ha seleccionado una publicación para eliminar, muestra un mensaje indicandolo.
            JOptionPane.showMessageDialog(this, "Seleccione uno o varios comentarios.",
                    "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        EliminacionPost eliminacionPost = new EliminacionPost(usuario, basedatos);
        eliminacionPost.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed
    
      @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Iconos/marcas-y-logotipos.png"));
        return retValue;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> jlComentarios;
    private javax.swing.JLabel lblLogo;
    // End of variables declaration//GEN-END:variables
}
