/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Repositorios.Control;
import TextPrompt.TextPrompt;
import com.mongodb.client.MongoDatabase;
import entity.Post;
import entity.Usuario;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Estefanía Aguilar
 */
public class BusquedaPosts extends javax.swing.JFrame {

    MongoDatabase basedatos;
    Control control;
    Usuario usuario;

    /**
     * Método constructor que se encarga de inicializar el frame de busqueda de
     * post por tags
     *
     * @param usuario Usuario que inicio sesión.
     * @param basedatos Base de datos de Faceboot.
     */
    public BusquedaPosts(Usuario usuario, MongoDatabase basedatos) {
        initComponents();
        this.setTitle("Faceboot");
        this.setLocationRelativeTo(null);
        control = new Control();
        this.basedatos = basedatos;
        this.usuario = usuario;
        mensajeCamposTexto();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        txtBusqueda = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        PanelPublicaciones = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/transparenciaC.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtBusqueda.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/regreso.png"))); // NOI18N
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        PanelPublicaciones.setBackground(new java.awt.Color(204, 204, 255));
        PanelPublicaciones.setLayout(new java.awt.GridLayout(100, 0));
        jScrollPane2.setViewportView(PanelPublicaciones);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addGap(19, 19, 19))
            .addComponent(jScrollPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Busqueda por tags");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/marcas-y-logotipos.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    /**
     * Método que se encarga de buscar los post en base al tag.
     */
    public void buscar() {
        //Lista de publicaciones en formato de panel
        ArrayList<Publicacion> formatoPost = new ArrayList<>();

        PanelPublicaciones.removeAll();
        PanelPublicaciones.updateUI();

        //Se obtienen todas la publicaciones almacenas en la base de datos.
        ArrayList<Post> publicaciones = reorganizarPublicaciones();

        //Recorre la lista buscando las publicaciones que coincidan con el tag dado.
        for (Post publicacion : publicaciones) {
            formatoPost.add(new Publicacion(basedatos, publicacion, usuario));
        }

        //Valida si se ingreso un tag.
        if (!txtBusqueda.getText().isEmpty()) {
            //Agrego los formatos al panel
            for (Publicacion publicacion : formatoPost) {
                PanelPublicaciones.add(publicacion);
                PanelPublicaciones.updateUI();
            }
        } else {
            //Si no se indico un tag para buscar, muestra un mensaje indicandolo.
            JOptionPane.showMessageDialog(this, "Ingresa TAG en la caja de texto",
                    "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        FrmPantallaInicio frmpi = new FrmPantallaInicio(this, basedatos, usuario);
        frmpi.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed

    /**
     * Método que se encarga de organizar las publicaciones del mas reciente al
     * mas viejo.
     *
     * @return Publicaciones ordenadas
     */
    public ArrayList<Post> reorganizarPublicaciones() {
        //Obtiene todas las publicaciones de la base de datos.
        ArrayList<Post> publicaciones
                = control.getPostRepository().buscarTodas(control.getPostRepository().crearCollection(basedatos));
        //Lista que almacenara las publicaciones ordenadas.
        ArrayList<Post> AuxOrganizados = new ArrayList<>();
        //Recorre la lista de publicaciones.
        for (int i = publicaciones.size() - 1; i >= 0; i--) {
            AuxOrganizados.add(publicaciones.get(i));
        }
        //Regresa la lista con las publicaciones ordenadas.
        return AuxOrganizados;
    }

    /**
     * Método que se encarga de mostrar un mensaje en los campos de textos.
     */
    public void mensajeCamposTexto() {
        //Campo de nombre
        TextPrompt tag = new TextPrompt("Ej. FelizLunes", txtBusqueda);
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Iconos/marcas-y-logotipos.png"));
        return retValue;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPublicaciones;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
