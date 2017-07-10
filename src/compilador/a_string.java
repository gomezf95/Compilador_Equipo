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
        c.valor="234";
        inicio.sig2=c;
        c.sig=a;
        
        //creacion del nodo q1
        a=new nodo();
        a.nombre="q1";
        a.terminal=false;
        inicio.sig1.sig=a;
        
        //creacion de la relacion q1 y q1
        c=new relacion ();
        c.valor="234";
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
        c.valor="1234";
        a.sig1=c;
        
        //creacion del nodo q4
        a=new nodo();
        a.nombre="q4";
        a.terminal=false;
        inicio.sig2.sig=a;
        c.sig=a;
        
        //creacion de la relacion q4 y q4
        c= new relacion();
        c.valor="1234";
        a.sig2=c;
        c.sig=a;
        
        
    }
    
    public boolean analizar(String token)
    {
        
        boolean resultado=false;
        int tipo, tam;
        a=inicio;
        for(int i=0;i<token.length();i++)
        {
            tipo=traducir(token.charAt(i));

            if(a.sig1!=null)
            {
                tam=a.sig1.valor.length();
                for(int x=0; x<tam; x++)
                {
                    if(Integer.parseInt(a.sig1.valor.charAt(x)+"")==tipo)
                    {
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
                    if(Integer.parseInt(a.sig2.valor.charAt(x)+"")==tipo)
                    {
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
        
        switch (x)
        {
            case '"':
                resultado=1;
            break;
            
            case 'a': case 'b': case 'c': case 'd': case 'e': case 'f': case 'g': case 'h': case 'i':
            case 'j': case 'k': case 'l': case 'm': case 'n': case 'ñ': case 'o': case 'p': case 'q': 
            case 'r': case 's': case 't': case 'u': case 'v': case 'w': case 'x': case 'y': case 'z':
            case 'A': case 'B': case 'C': case 'D': case 'E': case 'F': case 'G': case 'H': case 'I':
            case 'J': case 'K': case 'L': case 'M': case 'N': case 'Ñ': case 'O': case 'P': case 'Q': 
            case 'R': case 'S': case 'T': case 'U': case 'V': case 'W': case 'X': case 'Y': case 'Z':
                resultado=4;
            break;
                
            case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9': case '0': 
                resultado=3;
            break;
                
            default:
                resultado=2;
            break;
        }
        
        return resultado;
    }
    
}
