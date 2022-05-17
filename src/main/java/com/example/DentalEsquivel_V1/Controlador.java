
package com.example.DentalEsquivel_V1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author sbams
 */
@Controller
public class Controlador {
    
    
    String usuario="sebas";
    String contra="lima";//jean modifique aquí 
    
    @GetMapping("/")
    public String login(){
        return "login"; //login.html
    }
    
    @RequestMapping(value="/menu", method=RequestMethod.POST)
    public String datos(@RequestParam("usuario") String usu,
                        @RequestParam("contra") String contr,
                        Model model){
        
            if((usu.equals(usuario)) && (contr.equals(contra))){
                return "menu"; //
            } 
            else return "login";
    }
    
    @GetMapping("/cambiarContraseña")
    public String cambiarContraseña(){
        return "cambiarContraseña"; //
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String datosCambiar(@RequestParam("usuario") String usu,
                        @RequestParam("contra") String contr,
                        @RequestParam("contraN1") String contrN1,
                        @RequestParam("contraN2") String contrN2,
                        Model model){
        if((usu.equals(usuario)) && (contr.equals(contra))){
            if(contrN1.equals(contrN2)){
                contra=contrN1;
                return "login";
            }
            else return "cambiarContraseña";
        }
        else return "cambiarContraseña";
    }
}
