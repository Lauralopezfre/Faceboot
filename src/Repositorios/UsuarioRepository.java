/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import entity.Usuario;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author laura
 */
public class UsuarioRepository extends BaseRepository<Usuario>{

    /**
     * Método que se encarga de crear una nueva colección.
     * @param database Base de datos donde se creara la colección.
     * @return Colección creada.
     */
    @Override
    public MongoCollection<Usuario> crearCollection(MongoDatabase database) {
        MongoCollection<Usuario> usuarios = database.getCollection(
                "usuarios", Usuario.class);
        return usuarios;
    }
    
    /**
     * Método que se encargar de crear un nuevo documento o registro.
     * @param collection Colección a la que pertenece el nuevo documento.
     * @param entidad Entidad con la información del documento.
     */
    @Override
    public void crearDocument(MongoCollection<Usuario> collection, Usuario entidad) {
        collection.insertOne(entidad);
    }

    /**
     * Método que se encarga de buscar por un identificador el documento
     * @param id Identificador por el que se va a buscar el documento.
     * @return Documento al que pertenece el identificador.
     */
    @Override
    public Usuario buscarPorId(MongoCollection<Usuario> collection, ObjectId id){
        return collection.find(eq("_id", id)).first();
    }
    
    /**
     * Método que se encarga de buscar documentos de usuario en base al nombre
     * @param collection Colección donde se va a buscar el documento
     * @param criterio Usuario
     * @return Documentos encontrados en base al nombre del usuario
     */
    @Override
    public ArrayList<Usuario> buscar(MongoCollection<Usuario> collection, String criterio){ 
        ArrayList<Usuario> usuario = new ArrayList<>();
        return collection.find(Filters.regex("Nombre", criterio, "i")).into(usuario);
    }
    
    /**
     * Método que se encarga de actualizar un documento.
     * @param collection Colección donde se encuentra el documento.
     * @param entidad Usuario con los datos actualizados
     * @return Documento actualizado.
     */
    @Override
    public Usuario actualizar(MongoCollection<Usuario> collection, Usuario entidad){
        //Duda en el actualizar
        return collection.updateOne(eq("_id", entidad.getId()), entidad);
    }
    
    /**
     * Método que se encarga de eliminar un usuario por su identificador
     * unico.
     * @param collection Colección donde se va a eliminar el documento
     * @param id Identificador unico del usuario que se va a eliminar.
     * @return Valida si se elimino correctamente el usuario de la base de datos.
     */
    @Override
    public boolean eliminar(MongoCollection<Usuario> collection, ObjectId id){
        
        collection.findOneAndDelete(new Document("_id", id));
        
        //Valida si se elimino correctamente
        return buscarPorId(collection, id) == null;
    }
    
    /**
     * Método que se encarga de mostrar todos los usuarios registrados
     * en una colección.
     * @param collection Coleccion de la que se desea obtener los documentos.
     * @return Documentos de la base de datos.
     */
    @Override
    public ArrayList<Usuario> buscarTodas(MongoCollection<Usuario> collection){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        return collection.find().into(usuarios);
    }
    
    /**
     * Método que se encarga de validar el correo y la contraseña al iniciar sesión.
     * @param collection Colección donde se buscara al usuario que pertenezca a esa contraseña y correo
     * @param correo Correo electronico que se va a validar.
     * @param contrasenia Contraseña que se va a validar
     * @return Usuario que ingreso al sistema.
     */
    public Usuario ingresar(MongoCollection<Usuario> collection, String correo, String contrasenia){
        //Obtiene el usuario de la base de datos con el correo dado
        ArrayList<Usuario> usuario = new ArrayList<>();
        collection.find(Filters.regex("Correo", correo, "i")).into(usuario);
        
        //Valida que la contraseña pertenezca ese usuario, si es asi regresa el usuario, sino regresa null
        for (Usuario usuario1 : usuario) {
            if(usuario1.getContrasenia().equalsIgnoreCase(contrasenia)){
                return usuario1;
            }
            break;
        }
        return null;
    }
    
}
