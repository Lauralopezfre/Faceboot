/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import Enum.GenerosMusicales;
import Enum.Sexo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author laura
 */
public class Usuario {
    
    private ObjectId id;
    private String nombre;
    private String correo, contrasenia;
    private int edad;
    private Sexo sexo;
    private List<GenerosMusicales> generosMusicales;
    private Date fechaNacimiento;
    private List<String> peliculas;

    public Usuario() {
    }

    public Usuario(String nombre, String correo, String contrasenia, int edad, Sexo sexo, List<GenerosMusicales> generosMusicales, Date fechaNacimiento, List<String> peliculas) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.edad = edad;
        this.sexo = sexo;
        this.generosMusicales = generosMusicales;
        this.fechaNacimiento = fechaNacimiento;
        this.peliculas = peliculas;
    }

    public Usuario(ObjectId id, String nombre, String correo, String contrasenia, int edad, Sexo sexo, List<GenerosMusicales> generosMusicales, Date fechaNacimiento, List<String> peliculas) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.edad = edad;
        this.sexo = sexo;
        this.generosMusicales = generosMusicales;
        this.fechaNacimiento = fechaNacimiento;
        this.peliculas = peliculas;
    }


    public Usuario(ObjectId id) {
        this.id = id;
    }    

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public List<GenerosMusicales> getGenerosMusicales() {
        return generosMusicales;
    }

    public void setGenerosMusicales(List<GenerosMusicales> generosMusicales) {
        this.generosMusicales = generosMusicales;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<String> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<String> peliculas) {
        this.peliculas = peliculas;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", sexo=" + sexo + ", generosMusicales=" + generosMusicales + ", fechaNacimiento=" + fechaNacimiento + ", peliculas=" + peliculas + '}';
    }
    
    
    
}
