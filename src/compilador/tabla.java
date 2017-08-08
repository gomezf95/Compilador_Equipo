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
public class tabla {
    
    n_tabla inicio;
    n_tabla a,b,c;
    int id=0;
    
    //metodo para insertar un registro en la tabla
    public void agregar(String nombre, String clasificacion, String tipo, String valor, int longitud)
    {
        if(inicio==null)
        {
            this.inicio=new n_tabla();
            a=inicio;
            a.id=id;
            a.nombre=nombre;
            a.longitud=longitud;
            a.tipo=tipo;
            a.clasificacion=clasificacion;
            a.valor=valor;
            id++;
        }
        else
        {
            if(buscar_repetidos(nombre))
            {
                b=new n_tabla();
                a.sig=b;
                a=b;
                a.id=id;
                a.nombre=nombre;
                a.longitud=longitud;
                a.tipo=tipo;
                a.clasificacion=clasificacion;
                a.valor=valor;
                id++;
            }
        }
    }
    
    //metodo para buscar en la tabla en caso de que exista algun elemento repetido dentro
    public boolean buscar_repetidos(String nombre)
    {
        boolean respuesta=false;
        c=inicio;
        while (c.sig!=null)
        {
            if(c.nombre.equals(nombre))
            {
                respuesta=true;
            }
            else
            {
                c=c.sig;
            }
        }
        
        return respuesta;
    }
    
}
