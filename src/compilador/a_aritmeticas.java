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
public class a_aritmeticas {
    
    nodo inicio, a;
    relacion b;
    
    public a_aritmeticas (){
    
        //creacion del nodo q0
        a= new nodo();
        a.nombre="q0";
        a.terminal=true;
        this.inicio=a;
        
        //creacion de la relacion q0 y q6
        b= new relacion();
        b.valor="345";
        a.sig4=b;
        
        //creacion del nodo q6
        a= new nodo();
        a.nombre="q6";
        a.terminal=false;
        inicio.sig4.sig=a;
        
        //creacion de la relacion q6 y q6
        b=new relacion();
        b.valor="12345";
        inicio.sig4.sig.sig2=b;
        b.sig=inicio.sig4.sig;
        
        //creacion de la relacion q0 y q1
        b=new relacion();
        b.valor="12";
        inicio.sig1=b;
        
        //creacion del nodo q1
        a=new nodo();
        a.nombre="q1";
        a.terminal=true;
        inicio.sig1.sig=a;
        
        //creacion de la relacion q1 y q6
        b=new relacion();
        b.valor="5";
        inicio.sig1.sig.sig4=b;
        b.sig=inicio.sig4.sig;
        
        //creacion de la relacion q1 y q2
        b=new relacion();
        b.valor="4";
        a.sig1=b;
        
        //creacion de la relacion q1 y q1
        b=new relacion();
        b.valor="2";
        a.sig2=b;
        b.sig=a;
        
        //creacion de la relacion q1 y q4
        b=new relacion();
        b.valor="13";
        a.sig3=b;
        
        //creacion del nodo q2
        a=new nodo();
        a.nombre="q2";
        a.terminal=true;
        inicio.sig1.sig.sig1.sig=a;
        
        //creacion de la relacion q2 y q4
        b=new relacion();
        b.valor="13";
        a.sig1=b;
        
        //creacion de la relacion q2 y q2
        b=new relacion();
        b.valor="2";
        a.sig2=b;
        b.sig=a;
        
        //creacion de la relacion q2 y q6
        b=new relacion();
        b.valor="45";
        a.sig4=b;
        b.sig=inicio.sig4.sig;
        
        //creacion del nodo q4
        a=new nodo();
        a.nombre="q4";
        a.terminal=true;
        inicio.sig1.sig.sig3.sig=a;
        inicio.sig1.sig.sig1.sig.sig1.sig=a;
        
        //creacion relacion q4 y q3
        b=new relacion();
        b.valor="4";
        a.sig1=b;
        
        //creacion relacion q4 y q4
        b=new relacion();
        b.valor="2";
        a.sig2=b;
        b.sig=a;
        
        //creacion relacion q4 y q1
        b=new relacion();
        b.valor="13";
        a.sig3=b;
        b.sig=inicio.sig1.sig;
        
        //creacion relacion q4 y q6
        b=new relacion();
        b.valor="5";
        a.sig4=b;
        b.sig=inicio.sig4.sig;
        
        //creacion del nodo q3
        a=new nodo();
        a.nombre="q3";
        a.terminal=true;
        inicio.sig1.sig.sig3.sig.sig1.sig=a;
        
        //creacion de la relacion q3 y q1
        b=new relacion();
        b.valor="13";
        a.sig1=b;
        b.sig=inicio.sig1.sig;
        
        //creacion relacion de q3 y q3
        b=new relacion();
        b.valor="2";
        a.sig2=b;
        b.sig=a;
        
        //creacion de la relacion entre q3 y q6
        b=new relacion();
        b.valor="45";
        a.sig4=b;
        b.sig=inicio.sig4.sig;
    }
    
    public boolean analizar(String token)
    {
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
                    if(Integer.parseInt(a.sig2.valor.charAt(x)+"")==tipo)
                    {
//                        System.out.println("se fue por sig 2");
                        x=a.sig2.valor.length();
                        a=a.sig2.sig;
                        resultado=a.terminal;
                    }
                }
            }
            
            if(a.sig3!=null)
            {
                tam=a.sig3.valor.length();
                for(int x=0; x<tam; x++)
                {
                    if(Integer.parseInt(a.sig3.valor.charAt(x)+"")==tipo)
                    {
//                        System.out.println("Se fue por sig 3");
                        x=a.sig3.valor.length();
                        a=a.sig3.sig;
                        resultado=a.terminal;
                    }
                }
            }
            
            if(a.sig4!=null)
            {
                tam=a.sig4.valor.length();
                for(int x=0; x<tam; x++)
                {
                    if(Integer.parseInt(a.sig4.valor.charAt(x)+"")==tipo)
                    {
//                        System.out.println("se fue por sig 4");
                        x=a.sig4.valor.length();
                        a=a.sig4.sig;
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
        
        if(x==43 || x==45)
        {
            resultado=1;
        }
        else 
        {
            if(x>=48 && x<=57)
            {
                resultado=2;
            }
            else
            {
                if(x==42 || x==47)
                {
                    resultado=3;
                }
                else
                {
                    if(x==46)
                    {
                        resultado=4;
                    }
                    else
                    {
                        resultado=5;
                    }
                }
            }
        }
        
        return resultado;
    }
    
}
