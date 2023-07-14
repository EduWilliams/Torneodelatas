
package com.Torneo.TorneoDeLatas.Servicios;

import com.Torneo.TorneoDeLatas.Excepciones.Miexception;
import com.Torneo.TorneoDeLatas.Repositorio.UsuarioRepositorio;
import com.Torneo.TorneoDeLatas.entidades.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class usuarioServicio {
    @Autowired
    private UsuarioRepositorio usuariorepositorio;
    @Transactional
    public void crearUsuario(String email,Integer dni,String nombre,String apellido,String password)throws Miexception{
        
        
        validar( email, dni,nombre, apellido,password);
        
        
        Usuario usuario=new Usuario();
        
        usuario.setDni(dni);
        usuario.setApellido(apellido);
        usuario.setNombre(nombre);
        usuario.setEmail(email);
        usuario.setEcopuntos(0);
        usuario.setAlta(new Date());
        
        usuariorepositorio.save(usuario);
    }
    public List<Usuario> listarUsuario(){
        List<Usuario> usuarios = new ArrayList();
        
        usuarios = usuariorepositorio.findAll();
        return usuarios;
    }
    @Transactional
    public void modificarUsuario(String email,Integer dni,String nombre,String apellido, String password) throws Miexception{
        validar( email, dni,nombre, apellido,password);
        Optional<Usuario> respuesta=usuariorepositorio.findById(email);
        
        if(respuesta.isPresent()){
            
            Usuario usuario=respuesta.get();
            usuario.setApellido(apellido);
            usuario.setNombre(nombre);
            usuario.setDni(dni);
            
            usuariorepositorio.save(usuario);
        }
        
    }
     @Transactional
    public void modificarUsuario(String email, Double ecopuntos){
        
        Optional<Usuario> respuesta=usuariorepositorio.findById(email);
        
        if(respuesta.isPresent()){
            
            Usuario usuario=respuesta.get();
            
            
            usuario.setEcopuntos(0);
            
            
            
            usuariorepositorio.save(usuario);
}
}
    private void validar(String email,Integer dni,String nombre,String apellido, String password)throws Miexception{
          if(email==null|| email.isEmpty()){
            throw new Miexception("Debe ingresar su correo electronico para contacto");
             }
         
      
        if(nombre==null|| nombre.isEmpty()){
            throw new Miexception("Debe ingresar su nombre");
             }
         if(apellido==null|| apellido.isEmpty()){
            throw new Miexception("Debe ingresar su apellido");
             }
        
        if(password==null|| password.isEmpty()){
            throw new Miexception("Debe ingresar su apellido");
             }
    }
}
