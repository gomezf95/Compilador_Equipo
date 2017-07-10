/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.util.Hashtable;

/**
 *
 * @author Edaniel
 */
public class a_lexico {
    
    private final Hashtable<Integer, Tokens> tabla = new Hashtable<>();
    int instruccion = 0;
    
    String []p_reservadas={"ent", "cad", "flot", "inicio", "fin",
                               "si", "entonces", "mientras", "escribe",
                               "leer", "equi"};
    
    a_string as=new a_string();
    a_identificador ai=new a_identificador();
    a_numeros an=new a_numeros();
    
    
    public String a_token(String token, int line)
    {
//        System.out.println("token a analizar: "+token);
        String salida="";
        
        if(p_reservada(token))
        {
//            salida="El token "+token+" es una palabra reservada";
            agregar(token,"Reservada");
        }
        else
        {
            if(as.analizar(token))
            {
//                salida="El token "+token+" es una cadena de String";
                agregar(token,"cadena");
            }
            else
            {
                if(ai.analizar(token))
                {
//                    salida="El token: "+token+" es un identificador";
                    agregar(token,"identificador");
                }
                else
                {
                    if(an.analizar(token))
                    {
//                        salida="El token: "+token+" es una operacion aritmetica";
                        agregar(token,"Aritmetica");
                    }
                    else 
                    {
                        if("(".equals(token) || ")".equals(token))
                        {
//                            salida="El token: "+token+" es un parentesis";
                            agregar(token,"parentesis");
                        }
                        else
                        {
                           if("=".equals(token))
                           {
//                               salida="El token: "+token+" es un igual";
                               agregar(token,"igualdad");
                           }
                           else
                           {
                               salida="El token: "+token+" no se reconoce";
                           }
                        }
                    }
                }
            }
        }
        
        
        return salida;
    }
    
    private void agregar( String palabra, String descripcion) {
        tabla.put(instruccion, new Tokens( palabra,
                descripcion));
        instruccion++;
    }
    
        
    public boolean p_reservada(String token)
    {
        boolean flag=false;
        
        for (int i=0; i<p_reservadas.length;i++)
        {
            if(p_reservadas[i].equals(token))
            {
                flag=true;
                i=11;
            }
        }
        
        return flag;
    }
    
    public Hashtable tabla() {
        return tabla;
    }
    
    public class Tokens {

        int clave;
        String palabra;
        String descripcion;

        Tokens( String palabra2, String descripcion2) {
            //clave = clave2;
            palabra = palabra2;
            descripcion = descripcion2;
        }
    }
    
}


