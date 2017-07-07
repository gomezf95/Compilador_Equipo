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
public class a_identificador {
    
    nodo inicio, a;
    relacion c;
    
    public a_identificador(){
    
        //creacion del nodo q0
        a= new nodo();
        a.nombre="q0";
        a.terminal=true;
        this.inicio=a;
        
        //creacion de la relacion q0 y q0
        c=new relacion();
        c.valor="12";
        a.sig2=c;
        c.sig=a;
        
        //creacion de la relacion q0 y q1
        c=new relacion();
        c.valor="345";
        a.sig1=c;
        
        //creacion del nodo q1
        a=new nodo();
        a.nombre="q1";
        a.terminal=false;
        inicio.sig1.sig=a;
        
        //creacion de la relacion q1 y q1 
        c=new relacion();
        c.valor="12345";
        a.sig2=c;
        c.sig=a;
    }
    
    public boolean analizar(String token)
    {
        
//        System.out.println("Inicio automata para identificar identificadores");
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
//                    System.out.println("tipo a evaluar: "+a.sig2.valor.charAt(x) +" tipo de chars: "+tipo);
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
        
        if(x>=97 && x<=122)
        {
            resultado=1;
        }
        else 
        {
            if(x>=65 && x<=90)
            {
                resultado=2;
            }
            else
            {
                if(x>=48 && x<=57)
                {
                    resultado=3;
                }
                else
                {
                    resultado=4;
                }
            }
        }
        
        return resultado;
    }
    
}
