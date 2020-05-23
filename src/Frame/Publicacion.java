
package Frame;

import Repositorios.Control;
import TextPrompt.TextPrompt;
import com.mongodb.client.MongoDatabase;
import entity.Comentario;
import entity.Post;
import entity.Usuario;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BoundedRangeModel;
import static javax.swing.text.StyleConstants.Orientation;

/**
 *
 * @author Estefanía Aguilar
 */
public class Publicacion extends javax.swing.JPanel {
    public static final String newline = "\n";
    Post post; 
    Usuario usuario;
    Control control;
    MongoDatabase basedatos;
    
    /**
     * Método contructor que se encarga de inicializar el Panel de Publicación.
     * @param basedatos Base de datos de Faceboot.
     * @param post Publicación.
     * @param usuario Usuario que inicio sesión.
     */
    public Publicacion(MongoDatabase basedatos, Post post, Usuario usuario) {
        initComponents();         
        this.post = post;        
        this.usuario = usuario;
        control = new Control();
        this.basedatos = basedatos;
        mensajeCamposTexto();
        mostrarDatos();   
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        lblPublicacion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAComentarios = new javax.swing.JTextArea();
        lblNombre = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblIcono = new javax.swing.JLabel();
        txtComentario = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPublicacion.setEditable(false);
        lblPublicacion.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        lblPublicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblPublicacionActionPerformed(evt);
            }
        });
        jScrollPane2.setViewportView(lblPublicacion);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 530, 70));

        txtAComentarios.setEditable(false);
        txtAComentarios.setColumns(20);
        txtAComentarios.setFont(new java.awt.Font("Calibri Light", 0, 15)); // NOI18N
        txtAComentarios.setRows(5);
        jScrollPane1.setViewportView(txtAComentarios);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 530, 120));

        lblNombre.setBackground(new java.awt.Color(0, 0, 0));
        lblNombre.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(51, 51, 51));
        add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 210, 22));

        lblFecha.setBackground(new java.awt.Color(0, 0, 0));
        lblFecha.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 240, 20));

        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/avatar.png"))); // NOI18N
        add(lblIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, 40));

        txtComentario.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        txtComentario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComentarioActionPerformed(evt);
            }
        });
        txtComentario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtComentarioKeyPressed(evt);
            }
        });
        add(txtComentario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 470, 40));

        btnEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/send.png"))); // NOI18N
        btnEnviar.setToolTipText("Comentar");
        btnEnviar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, 50, 40));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/blancosolido.jpg"))); // NOI18N
        add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 360));
    }// </editor-fold>//GEN-END:initComponents

    private void txtComentarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComentarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtComentarioActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        //Valida si el comentario es correcto
        if(validarComentario()){
            //Crea un nuevo comentario con sus nuevos valores.
            Comentario comentario = new Comentario (txtComentario.getText(), this.usuario, new Date());
            //Le da un formato a la fecha para mostrarla.
            SimpleDateFormat formater = new SimpleDateFormat("hh:mm:ss a dd-MMMM-yyyy");
            //Muestra el comentario en pantalla
            txtAComentarios.append(comentario.getUsuario().getNombre() + ": " + comentario.getTexto() + newline 
                    + "     " +formater.format(comentario.getFechaHora())+ newline);
            txtComentario.selectAll();
            txtAComentarios.setCaretPosition(txtAComentarios.getDocument().getLength());
            //Guarda el comentario en la base de datos
            post.getComentarios().add(comentario);
            control.getPostRepository().actualizar(control.getPostRepository().crearCollection(basedatos), 
                    post);
            //Limpia el campo para ingresar un nuevo comentario.
            txtComentario.setText("");
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void txtComentarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComentarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            //Valida si el comentario es correcto
            if (validarComentario()) {
                //Crea un nuevo comentario con sus nuevos valores.
                Comentario comentario = new Comentario(txtComentario.getText(), this.usuario, new Date());
                //Le da un formato a la fecha para mostrarla.
                SimpleDateFormat formater = new SimpleDateFormat("hh:mm:ss a dd-MMMM-yyyy");
                //Muestra el comentario en pantalla
                txtAComentarios.append(comentario.getUsuario().getNombre() + ": " + comentario.getTexto() + newline
                        + "     " + formater.format(comentario.getFechaHora()) + newline);
                txtComentario.selectAll();
                txtAComentarios.setCaretPosition(txtAComentarios.getDocument().getLength());
                //Guarda el comentario en la base de datos
                post.getComentarios().add(comentario);
                control.getPostRepository().actualizar(control.getPostRepository().crearCollection(basedatos),
                        post);
                 //Limpia el campo para ingresar un nuevo comentario.
                txtComentario.setText("");
            }
        }
    }//GEN-LAST:event_txtComentarioKeyPressed

    private void lblPublicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblPublicacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblPublicacionActionPerformed
    /**
     * Método que se encarga de validar la estructura del comentario agregado.
     * @return Confirma si el comentario indicado es correcto.
     */
    public boolean validarComentario() {
        if (!txtComentario.getText().isEmpty()){
            for(int i =0; i<txtComentario.getText().length(); i++){
                 if(txtComentario.getText().charAt(i) != ' '){
                     return true;
                 }
            }            
        }
        return false;        
    }
    
    /**
     * Método que se encarga de mostrar la información del post en los campos.
     */
    public void mostrarDatos() {
        //Muestra el nombre del usuario que creo la publicación.
        lblNombre.setText(post.getUsuario().getNombre());
        
        //Muestra la fecha y hora de la publicación y le da un formato.
        SimpleDateFormat formater = new SimpleDateFormat("hh: mm: ss a dd-MMMM-yyyy");       
        String fechaTexto = formater.format(post.getFechaHora());
        lblFecha.setText(fechaTexto);
        
        //Inhabilita el campo de comentarios para que no sea editable
        txtAComentarios.setEditable(false);
        
        //Muestra el mensaje de la publicación.
        lblPublicacion.setText(post.toString());
        
        //Muestra los mensaje de la publicación.
        if (post.getComentarios() != null) {
            for (Comentario comentario : post.getComentarios()) {                                
                SimpleDateFormat formater2 = new SimpleDateFormat("hh: mm: ss a dd-MMMM-yyyy");      
                txtAComentarios.append(comentario.getUsuario().getNombre() + ": " + comentario.getTexto() + newline 
                        + "     " + formater2.format(comentario.getFechaHora())
                        +newline);
                txtAComentarios.selectAll();
                txtAComentarios.setCaretPosition(txtAComentarios.getDocument().getLength());
            }
        }
    }
    /**
     * Método que se encarga de mostrar un mensaje en los campos de textos.
     */
    public void mensajeCamposTexto(){
        //Campo de nombre
        TextPrompt mensaje = new TextPrompt("Escribe un mensaje", txtComentario);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblIcono;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTextField lblPublicacion;
    private javax.swing.JTextArea txtAComentarios;
    private javax.swing.JTextField txtComentario;
    // End of variables declaration//GEN-END:variables
}
