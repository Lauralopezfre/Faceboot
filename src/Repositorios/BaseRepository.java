/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import com.mongodb.client.*;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author laura
 */
public abstract class BaseRepository<T> {

    /**
     * Método abstracto que se encarga de crear una nueva colección.
     * @param database Base de datos donde se creara la colección
     * @return Colección creada.
     */
    public abstract MongoCollection<T> crearCollection(MongoDatabase database);
    
    /**
     * Método abstracto que se encargar de crear un nuevo documento o registro.
     * @param collection Colección a la que pertenece el nuevo documento.
     * @param entidad Entidad con la información del documento.
     */
    public abstract void crearDocument(MongoCollection<T> collection, T entidad);
    
    /**
     * Método abstracto que se encarga de buscar por un identificador el documento
     * @param collection Colección donde se va a buscar el documento.
     * @param id Identificador por el que se va a buscar el documento.
     * @return Documento al que pertenece el identificador.
     */
    public abstract T buscarPorId(MongoCollection<T> collection, ObjectId id);
    
    /**
     * Método abstracto que se encarga de buscar documentos en base a un criterio dado.
     * @param collection Colección donde se va a buscar el documento
     * @param criterio Criterio por el que se va a buscar uno o varios documentos.
     * @return Documentos encontrados en base al criterio dato.
     */
    public abstract ArrayList<T> buscar(MongoCollection<T> collection, String criterio);
    
    /**
     * Método abstracto que se encarga de actualizar un documento.
     * @param collection Colección donde se encuentra el documento
     * @param entidad Entidad con los datos actualizados
     * @return Documento actualizado.
     */
    public abstract T actualizar(MongoCollection<T> collection, T entidad);
    
    /**
     * Método abstracto que se encarga de eliminar un documento por su identificador
     * unico.
     * @param collection Colección donde se va a eliminar el documento
     * @param id Identificador unico del documento que se va a eliminar.
     * @return Valida si se elimino correctamente el documento de la base de datos.
     */
    public abstract boolean eliminar(MongoCollection<T> collection, ObjectId id);
    
    /**
     * Método abstracto que se encarga de mostrar todos los documentos registrados
     * en una colección.
     * @param collection Coleccion de la que se desea obtener los documentos.
     * @return Documentos de la base de datos.
     */
    public abstract ArrayList<T> buscarTodas(MongoCollection<T> collection);
    
    
}
