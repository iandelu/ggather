
package com.mycompany.iw.daos;


import java.util.List;

/**
 *
 * @author LuisAneri
 */
public interface DAO<T, K >{
    
    void insertar(T j) throws DAOException;
    
    void modificar(T j)throws DAOException;
    
    void eliminar(T j)throws DAOException;
    
    List<T> obtenerTodos()throws DAOException;
    
    T obtener(K id)throws DAOException;
}
