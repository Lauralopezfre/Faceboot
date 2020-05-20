/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import entity.Post;
import entity.Usuario;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author laura
 */
public class PostRepository extends BaseRepository<Post>{

     /**
     * Método que se encarga de crear una nueva colección.
     * @param database Base de datos donde se creara la colección.
     * @return Colección creada.
     */
    @Override
    public MongoCollection<Post> crearCollection(MongoDatabase database) {
        MongoCollection<Post> post = database.getCollection(
                "post", Post.class);
        return post;
    }
    
    /**
     * Método que se encargar de crear un nuevo documento o registro.
     * @param collection Colección a la que pertenece el nuevo documento.
     * @param entidad Entidad con la información del documento.
     */
    @Override
    public void crearDocument(MongoCollection<Post> collection, Post entidad) {
        collection.insertOne(entidad);
    }

    /**
     * Método que se encarga de buscar por un identificador el documento
     * @param id Identificador por el que se va a buscar el documento.
     * @return Documento al que pertenece el identificador.
     */
    @Override
    public Post buscarPorId(MongoCollection<Post> collection, ObjectId id){
        return collection.find(eq("_id", id)).first();
    }
    
    /**
     * Método que se encarga de buscar publicaciones en base al tag
     * @param collection Colección donde se va a buscar el documento
     * @param criterio Tags
     * @return Documentos encontrados en base al nombre del usuario
     */
    @Override
    public ArrayList<Post> buscar(MongoCollection<Post> collection, String criterio){ 
        ArrayList<Post> publicaciones = new ArrayList<>();
        return collection.find(Filters.regex("Tags", criterio, "i")).into(publicaciones);
    }
    
    /**
     * Método que se encarga de actualizar una poblicación.
     * @param collection Colección donde se encuentra el documento.
     * @param entidad Publicación con los datos actualizados
     * @return Documento actualizado.
     */
    @Override
    public Post actualizar(MongoCollection<Post> collection, Post entidad){
        //Duda en el actualizar
        return collection.findOneAndReplace(eq("_id", entidad.getId()), entidad);
    }
    
    /**
     * Método que se encarga de eliminar una publicación por su identificador
     * unico.
     * @param collection Colección donde se va a eliminar el documento
     * @param id Identificador unico del post que se va a eliminar.
     * @return Valida si se elimino correctamente el usuario de la base de datos.
     */
    @Override
    public boolean eliminar(MongoCollection<Post> collection, ObjectId id){
        
        collection.findOneAndDelete(new Document("_id", id));
        
        //Valida si se elimino correctamente
        return buscarPorId(collection, id) == null;
    }
    
    /**
     * Método que se encarga de mostrar todas las publicaciones registradas
     * en una colección.
     * @param collection Coleccion de la que se desea obtener los documentos.
     * @return Publicaciones de la base de datos.
     */
    @Override
    public ArrayList<Post> buscarTodas(MongoCollection<Post> collection){
        ArrayList<Post> publicaciones = new ArrayList<>();
        return collection.find().into(publicaciones);
    }    
    
    
}
