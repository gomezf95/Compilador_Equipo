/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;


/**
 *
 * @author Edaniel
 */
public class a_lexico {
    int instruccion = 0;
    
    String []p_reservadas={"ent", "cad", "flot", "inicio", "fin",
                               "si", "entonces", "mientras", "escribe",
                               "leer", "equi"};
    a_string as=new a_string();
    a_identificador ai=new a_identificador();
    a_numeros an=new a_numeros();
    boolean comentario_dd, comentario_da;
    
    public a_lexico()
    {
        comentario_dd=true;//bandera para indicar que se inicio un comentario de doble diagonal
        comentario_da=true;//bandera para indicar que se inicio un comentario con diagonal y asterisco
    }
    
    public void comentario(String token)
    {
        if(token.equals("//"))
        {
            comentario_dd=false;
        }
        else
        {
            if(token.equals("/*"))
            {
                comentario_da=false;
            }
            else
            {
                if(token.equals("*/"))
                {
                    comentario_da=true;
                }
            }
        }
    }
    
    public String a_token(String token, int line)
    {
//        System.out.println("token a analizar: "+token);
        String salida="";
        comentario(token);
        
        if(comentario_dd && comentario_da && !token.equals("*/"))
        {
            System.out.print(token);
            if(p_reservada(token))
            {
    //            salida="El token "+token+" es una palabra reservada";
            }
            else
            {
                if(as.analizar(token))
                {
    //                salida="El token "+token+" es una cadena de String";
                }
                else
                {
                    if(ai.analizar(token))
                    {
    //                    salida="El token: "+token+" es un identificador";
                    }
                    else
                    {
                        if(an.analizar(token))
                        {
    //                        salida="El token: "+token+" es un numero";
                        }
                        else 
                        {
                            if("(".equals(token) || ")".equals(token))
                            {
    //                            salida="El token: "+token+" es un parentesis";
                            }
                            else
                            {
                               if("=".equals(token))
                               {
    //                               salida="El token: "+token+" es un igual";
                               }
                               else
                               {
                                   if("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token))
                                   {
    //                                   salida="El token: "+token+" es un signo";
                                   }
                                   else
                                   {
                                       salida="Error en la linea: "+line+" en el token: "+token;
                                   }
                               }
                            }
                        }
                    }
                }
            }
        }
        
        
        
        return salida;
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
}