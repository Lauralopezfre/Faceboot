/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Enum.GenerosMusicales;
import Repositorios.Control;
import com.mongodb.client.MongoDatabase;
import entity.Post;
import entity.Usuario;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author laura
 */
public class EliminacionPost extends javax.swing.JFrame {

    MongoDatabase mongo;
    Control control;
    Usuario usuario;
    public EliminacionPost(Usuario usuario, MongoDatabase mongo) {
        initComponents();
        this.setTitle("Faceboot");
        this.setLocationRelativeTo(null);
        control = new Control();
        this.mongo = mongo;
        this.usuario = usuario;
        mostrarPublicaciones();
    }
    
    public void mostrarPublicaciones(){
        DefaultListModel listModel = new DefaultListModel();
        for (Post post : control.getPostRepository().buscarTodas(control.getPostRepository().crearCollection(mongo))) {
            if(post.getUsuario().getId().toString()
                    .equals(usuario.getId().toString())){
                listModel.addElement(post);
            }
        }
        jlPublicaciones.setModel(listModel);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlPublicaciones = new javax.swing.JList<>();
        btnEliminar = new javax.swing.JButton();
        btnCancekar = new javax.swing.JButton();
        btnComentarios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(102, 153, 255));

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Faceboot");

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/marcas-y-logotipos.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLogo)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlPublicaciones.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(jlPublicaciones);

        btnEliminar.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/seo-social-web-network-internet_262_icon-icons.com_61518.png"))); // NOI18N
        btnEliminar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCancekar.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnCancekar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancel_stop_exit_1583.png"))); // NOI18N
        btnCancekar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancekar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancekarActionPerformed(evt);
            }
        });

        btnComentarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/comments_alt_icon_125319.png"))); // NOI18N
        btnComentarios.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnComentarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComentariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCancekar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(btnComentarios, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnCancekar, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                        .addComponent(btnComentarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        ArrayList<Post> publicaciones = new ArrayList<>();
        for (int i = 0; i < jlPublicaciones.getSelectedValues().length; i++) {
            publicaciones.add((Post)jlPublicaciones.getSelectedValues()[i]);
        }
        
        for (Post publicacione : publicaciones) {
            control.getPostRepository().eliminar(control.getPostRepository().crearCollection(mongo), publicacione.getId());
        }
        
        JOptionPane.showMessageDialog(this, "Operacion exitosa",
                "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        mostrarPublicaciones();
        FrmPantallaInicio frmpi = new FrmPantallaInicio(this, mongo, usuario);
        frmpi.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancekarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancekarActionPerformed
        FrmPantallaInicio frmpi = new FrmPantallaInicio(this, mongo, usuario);
        frmpi.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCancekarActionPerformed

    private void btnComentariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComentariosActionPerformed
        EliminacionComentario frmec = new EliminacionComentario(usuario, mongo);
        frmec.setVisible(true);        
    }//GEN-LAST:event_btnComentariosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancekar;
    private javax.swing.JButton btnComentarios;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> jlPublicaciones;
    private javax.swing.JLabel lblLogo;
    // End of variables declaration//GEN-END:variables
}
