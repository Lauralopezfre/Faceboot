/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

/**
 *
 * @author laura
 */
public class Control {
    private PostRepository postRepository;
    private UsuarioRepository usuarioRepository;
    
    public PostRepository getPostRepository(){
        if(this.postRepository != null){
            return this.postRepository;
        }else{
            this.postRepository = new PostRepository();
            return this.postRepository;
        }
    }
    
    public UsuarioRepository getUsuarioRepository(){
        if(this.usuarioRepository != null){
            return this.usuarioRepository;
        }else{
            this.usuarioRepository = new UsuarioRepository();
            return this.usuarioRepository;
        }

    }
    
}
