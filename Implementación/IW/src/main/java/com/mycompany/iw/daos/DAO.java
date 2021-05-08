
package com.mycompany.iw.daos;


import java.util.List;

/**
 *
 * @author LuisAneri
 */
public interface DAO<T, K >{
    
    void insertar(T j);
    
    void modificar(T j);
    
    void eliminar(T j);
    
    List<T> obtenerTodos();
    
    T obtener(K id);
}
