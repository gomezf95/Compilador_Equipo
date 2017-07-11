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
public class a_numeros {
    
    nodo inicio, a;
    relacion c;
    
    public a_numeros()
    {
        //creacion del nodo q0
        a=new nodo();
        a.nombre="q0";
        a.terminal=false;
        inicio=a;
        
        //creacion de la realcion q0 y q1
        c= new relacion ();
        c.valor="1";
        inicio.sig1=c;
        
        //creacion de la relacion q0 y q4
        c=new relacion();
        c.valor="23";
        inicio.sig3=c;
        
        //creacion del nodo q1
        a=new nodo();
        a.nombre="q1";
        a.terminal=true;
        inicio.sig1.sig=a;
        
        //creacion de la relacion q1 y q1
        c=new relacion();
        c.valor="1";
        a.sig2=c;
        c.sig=a;
        
        //creacion de la relacion q1 y q2
        c=new relacion();
        c.valor="2";
        a.sig1=c;
        
        //creacion de la relacion q1 y q4
        c=new relacion ();
        c.valor="3";
        a.sig3=c;
        
        //creacion del nodo q2
        a=new nodo();
        a.nombre="q2";
        a.terminal=false;
        inicio.sig1.sig.sig1.sig=a;
        
        //creacion de la relacion q2 y q3
        c=new relacion();
        c.valor="1";
        a.sig1=c;
        
        //creacion de la relacion q2 y q4
        c= new relacion();
        c.valor="23";
        a.sig3=c;
        
        //creacion del nodo q3
        a=new nodo();
        a.nombre="q3";
        a.terminal=true;
        inicio.sig1.sig.sig1.sig.sig1.sig=a;
        
        //creacion de la relacion q3 y q4
        c=new relacion();
        c.valor="23";
        a.sig3=c;
        
        //creacion de la relacion q3 y q3
        c=new relacion();
        c.valor="1";
        a.sig2=c;
        c.sig=a;
        
        //creacion del nodo q4
        a=new nodo();
        a.nombre="q4";
        a.terminal=false;
        inicio.sig3.sig=a;
        inicio.sig1.sig.sig3.sig=a;
        inicio.sig1.sig.sig1.sig.sig3.sig=a;
        inicio.sig1.sig.sig1.sig.sig1.sig.sig3.sig=a;
        
        //creacion dek nodo q4 y q4
        c=new relacion();
        c.valor="123";
        a.sig2=c;
        c.sig=a;
    }
    
    public boolean analizar(String token)
    {
        System.out.println("Inicio del automata numeros con la cadena "+token);
        boolean resultado=false;
        int tipo, tam;
        a=inicio;
        for(int i=0;i<token.length();i++)
        {
            boolean bug=true;
            tipo=traducir(token.charAt(i));
            System.out.println(tipo+" "+token.charAt(i));
            if(a.sig1!=null && bug)
            {
                tam=a.sig1.valor.length();
                for(int x=0; x<tam; x++)
                {
                    if(Integer.parseInt(a.sig1.valor.charAt(x)+"")==tipo)
                    {
                        bug=false;
                        x=tam;
                        a=a.sig1.sig;
                        resultado=a.terminal;
                        System.out.println(a.nombre);
                    }
                }
            }
                if(a.sig2!=null && bug)
                {
                    tam=a.sig2.valor.length();
                    for(int x=0; x<tam; x++)
                    {
                        if(Integer.parseInt(a.sig2.valor.charAt(x)+"")==tipo)
                        {
                            bug=false;
                            x=a.sig2.valor.length();
                            a=a.sig2.sig;
                            resultado=a.terminal;
                            System.out.println(a.nombre);
                        }
                    }
                }
                    if(a.sig3!=null && bug)
                    {
                        tam=a.sig3.valor.length();
                        for(int x=0; x<tam; x++)
                        {
                            if(Integer.parseInt(a.sig3.valor.charAt(x)+"")==tipo)
                            {
                                bug=false;
                                x=a.sig3.valor.length();
                                a=a.sig3.sig;
                                resultado=a.terminal;
                                System.out.println(a.nombre);
                            }
                        }
                    }
                    if(bug)
                    {
                        System.out.println("Error en el automata de los numeros");
                    }
        }
        return resultado;
    }
    
    public int traducir(char x)
    {
        int resultado=0;
        
        switch (x)
        {
            case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9': case '0': 
                resultado=1;
            break;
                
            case '.':
                resultado=2;
            break;
                
            default:
                resultado=3;
            break;
        }
        
        return resultado;
    }
}
