/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Enum.GenerosMusicales;
import Enum.Sexo;
import Repositorios.Control;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entity.Usuario;
import java.util.ArrayList;
import java.util.Date;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;

/**
 *
 * @author laura
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CodecRegistry pojo = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        
        MongoClient conexion = new MongoClient("localhost", MongoClientOptions.builder().codecRegistry(pojo).build());
        MongoDatabase basedatos = conexion.getDatabase("Faceboot");
        
        //Se crea la coleccion
        Control control = new Control();
        MongoCollection<Usuario> usuarios = control.getUsuarioRepository().crearCollection(basedatos);

//        
//        //Se crea usuarios
//        ArrayList<GenerosMusicales> usuarioGeneros1 = new ArrayList<>();
//        usuarioGeneros1.add(GenerosMusicales.Bachata);
//        usuarioGeneros1.add(GenerosMusicales.Banda);
//        
//        ArrayList<String> usuarioPeliculas1 = new ArrayList<>();
//        usuarioPeliculas1.add("El conjuro");
//        usuarioPeliculas1.add("Matilda");
//        usuarioPeliculas1.add("La cenicienta");
//        usuarioPeliculas1.add("El vuelo");
//        
//        Usuario usuario1 = new Usuario("Laura López", 20, Sexo.femenino, 
//                usuarioGeneros1, new Date(2000, 8, 7), usuarioPeliculas1);
//        
//        ArrayList<GenerosMusicales> usuarioGeneros2 = new ArrayList<>();
//        usuarioGeneros2.add(GenerosMusicales.Pop);
//        usuarioGeneros2.add(GenerosMusicales.Reggaeton);
//        
//        ArrayList<String> usuarioPeliculas2 = new ArrayList<>();
//        usuarioPeliculas2.add("Mulan");
//        usuarioPeliculas2.add("Dumbo");
//        usuarioPeliculas2.add("Chuky");
//        
//        Usuario usuario2 = new Usuario("Diana Estefania", 20, Sexo.femenino, 
//                usuarioGeneros2, new Date(2000, 8, 13), usuarioPeliculas2);
//        
//        //Se almacena en la base de datos.
//        control.getUsuarioRepository().crearDocument(usuarios, usuario2);
//        control.getUsuarioRepository().crearDocument(usuarios, usuario1);
//        
        
        //Eliminar
//        if(control.getUsuarioRepository().eliminar(usuarios, new ObjectId("5ebf76319d7c516db265478e"))){
//            System.out.println("Se ha eliminado correctamente");
//        }else{
//            System.out.println("Todavia existe el usuario");
//        }
//        
//        //Buscar todos
//        for (Usuario usuario : control.getUsuarioRepository().buscarTodas(usuarios)) {
//            System.out.println(usuario);
//        }
//        
    }
        
}
