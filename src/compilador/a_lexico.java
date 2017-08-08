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
    tabla t=new tabla();
    n_tabla inicio;
    
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
            System.out.print(token+" ");
            if(p_reservada(token))
            {
                t.agregar(token, "Reservada", "", "", 4);
            }
            else
            {
                if(as.analizar(token))
                {
                    t.agregar(token, "Constante", "Cadena", "", token.length()*2);
                }
                else
                {
                    if(ai.analizar(token))
                    {
                        t.agregar(token, "Identificador", "", "", token.length()*2);
                    }
                    else
                    {
                        if(an.analizar(token))
                        {
                            t.agregar(token, "Constante", "Entero", "", token.length()*2);
                        }
                        else 
                        {
                            if("(".equals(token) || ")".equals(token))
                            {
                                t.agregar(token, "Parentesis", "", "", 2);
                            }
                            else
                            {
                               if("=".equals(token))
                               {
                                   t.agregar(token, "Igualdad", "", "", 2);
                               }
                               else
                               {
                                   if("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token))
                                   {
                                       t.agregar(token, "Op_aritmeticos", "", "", 2);
                                   }
                                   else
                                   {
                                       if(token.equals(">") || token.equals(">=") || token.equals("<") || token.equals("<=") ||
                                          token.equals("><") || token.equals("=="))
                                       {
                                           t.agregar(token, "Op_Logico", "", "", 2);
                                       }
                                       else
                                       {
                                           if(token.equals("{") || token.equals("}"))
                                           {
                                               t.agregar(token, "Corchete", "", "", 2);
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
            }
        }
        
        
    this.inicio=t.inicio;    
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