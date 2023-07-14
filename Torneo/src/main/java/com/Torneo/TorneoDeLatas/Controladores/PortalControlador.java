
package com.Torneo.TorneoDeLatas.Controladores;

import com.Torneo.TorneoDeLatas.Excepciones.Miexception;
import com.Torneo.TorneoDeLatas.Servicios.usuarioServicio;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class PortalControlador {
    @Autowired
    private usuarioServicio usuarioservicio;
   @GetMapping("/")
    public String index(){
      
        return "index.html";
    }
   @GetMapping("/login") 
     public String login(){
      
        return "Iniciosesion.html";
    }
      @GetMapping("/registro") 
     public String registro(){
      
        return "usuario-form.html";
    }
      @PostMapping("/registrar") 
      
     public String registrar(@RequestParam String email,@RequestParam(required=false) Integer dni,@RequestParam  String nombre,@RequestParam String apellido, String password,String password2,ModelMap modelo) {
     
   
        try {
            usuarioservicio.crearUsuario(email, dni, nombre, apellido, password);
            modelo.put("exito","se a cargado exitosamente");
        } catch (Miexception ex) {
            modelo.put("error", ex.getMessage());
            return "usuario-form.html";
        }
          
        return "Index.html";
     
         
         
     
     
     
     }
       @GetMapping("/Basesycondiciones") 
     public String Basesycondicones(){
      
        return "Basesycondiciones.html";
    }
      @GetMapping("/Central") 
     public String Central(){
      
        return "Central.html";
    }
}
