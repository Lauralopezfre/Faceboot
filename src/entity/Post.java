/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author laura
 */
public class Post {
    
    private ObjectId id;
    private Date fechaHora;
    private String mensaje;
    private List<String> tags;
    private Usuario usuario;
    private List<Comentario> comentarios;

    public Post(Date fechaHora, String mensaje, List<String> tags, Usuario usuario) {
        this.fechaHora = fechaHora;
        this.mensaje = mensaje;
        this.tags = tags;
        this.usuario = usuario;
        comentarios = new ArrayList<>();
    }

    public Post(Date fechaHora, String mensaje, List<String> tags, Usuario usuario, List<Comentario> comentarios) {
        this.fechaHora = fechaHora;
        this.mensaje = mensaje;
        this.tags = tags;
        this.usuario = usuario;
        this.comentarios = comentarios;
        
    }

    public Post(ObjectId id, Date fechaHora, String mensaje, List<String> tags, Usuario usuario, List<Comentario> comentarios) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.mensaje = mensaje;
        this.tags = tags;
        this.usuario = usuario;
        this.comentarios = comentarios;
    }

    public Post() {
        comentarios = new ArrayList<>();
        
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
    
    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        String mensaje = getMensaje();
        for (String tag : getTags()) {
            mensaje = mensaje + tag;
        }
        return mensaje;
    }
    
    
    
    
}
