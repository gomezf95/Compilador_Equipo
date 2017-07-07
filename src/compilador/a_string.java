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
public class a_string {
    
    nodo inicio, a;
    relacion c;
    
    
    public a_string()
    {
        //creacion del nodo q0
        this.inicio = new nodo();
        inicio.nombre="q0";
        inicio.terminal=true;
        a=inicio;
        
        //creacion de la relacion entre q0 y q1
        c= new relacion();
        c.valor="1";
        inicio.sig1=c;
        
        //creacion de la relacion q0 y q4
        c=new relacion();
        c.valor="2345";
        inicio.sig2=c;
        c.sig=a;
        
        //creacion del nodo q1
        a=new nodo();
        a.nombre="q1";
        a.terminal=false;
        inicio.sig1.sig=a;
        
        //creacion de la relacion q1 y q1
        c=new relacion ();
        c.valor="2345";
        a.sig2=c;
        c.sig=a;
        
        //crecion de la relacion q1 y q2
        c=new relacion();
        c.valor="1";
        a.sig1=c;
        
        //creacion del nodo q2
        a=new nodo();
        a.nombre="q2";
        a.terminal=true;
        c.sig=a;
        
        //creacion de la relacion q2 y q4
        c= new relacion();
        c.valor="12345";
        a.sig1=c;
        
        //creacion del nodo q4
        a=new nodo();
        a.nombre="q4";
        a.terminal=false;
        inicio.sig2.sig=a;
        c.sig=a;
        
        //creacion de la relacion q4 y q4
        c= new relacion();
        c.valor="12345";
        a.sig2=c;
        c.sig=a;
        
        
    }
    
    public boolean analizar(String token)
    {
        
//        System.out.println("Inicio automata para identificar strings");
        boolean resultado=false;
        int tipo, tam;
        a=inicio;
        for(int i=0;i<token.length();i++)
        {
//            System.out.println("Char a traducir: "+token.charAt(i));
            tipo=traducir(token.charAt(i));
//            System.out.println("El char es de tipo: "+tipo);

            if(a.sig1!=null)
            {
                tam=a.sig1.valor.length();
                for(int x=0; x<tam; x++)
                {
//                    System.out.println("tipo a evaluar: "+a.sig1.valor.charAt(x) +" tipo de chars: "+tipo);
                    if(Integer.parseInt(a.sig1.valor.charAt(x)+"")==tipo)
                    {
//                        System.out.println("Se fue por sig 1");
                        x=a.sig1.valor.length();
                        a=a.sig1.sig;
                        resultado=a.terminal;
                    }
                }
            }
            
            if(a.sig2!=null)
            {
                tam=a.sig2.valor.length();
                for(int x=0; x<tam; x++)
                {
//                    System.out.println("tipo a evaluar: "+a.sig2.valor.charAt(x) +" tipo de char: "+tipo);
                    if(Integer.parseInt(a.sig2.valor.charAt(x)+"")==tipo)
                    {
//                        System.out.println("se fue por sig 2");
                        x=a.sig2.valor.length();
                        a=a.sig2.sig;
                        resultado=a.terminal;
                    }
                }
            }
        }
        return resultado;
    }
    
    public int traducir(char x)
    {
        int resultado=0;
        
        if(x==34)
        {
            resultado=1;
        }
        else
        {
            if(x>=48 && x<=57)
            {
                resultado=3;
            }
            else
            {
                if(x>=97 && x<=122)
                {
                    resultado=4;
                }
                else
                {
                    if(x>=65 && x<=90)
                    {
                        resultado=5;
                    }
                    else
                    {
                        resultado=2;
                    }
                }
            }
        }
        
        return resultado;
    }
    
}
