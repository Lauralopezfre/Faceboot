/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author laura
 */
public class Comentario {

    private ObjectId id;    
    private String texto;
    private Date fechaHora;
    private Usuario usuario;

    public Comentario() {
    }
    
    public Comentario(String texto, Usuario usuario, Date fechaHora) {
        this.texto = texto;
        this.fechaHora = fechaHora;
        this.usuario = usuario;
    }

    public Comentario(ObjectId id, String texto, Date fechaHora, Usuario usuario) {
        this.id = id;
        this.texto = texto;
        this.fechaHora = fechaHora;
        this.usuario = usuario;
    }
    
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        String mensaje = getTexto();
        return mensaje;
    }
    
    
    
    
}
