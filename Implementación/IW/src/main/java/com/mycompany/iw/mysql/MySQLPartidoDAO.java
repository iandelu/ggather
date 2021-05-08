package com.mycompany.iw.mysql;

import com.mycompany.iw.Jugador;
import com.mycompany.iw.Partido;
import com.mycompany.iw.daos.DAOException;
import com.mycompany.iw.daos.JugadorDao;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LuisAneri
 */

public class MySQLPartidoDAO implements PartidoDAO{
    
    final String INSERT = "INSERT INTO Partido(idJugador, idCreador, nivelPartido, idReserva, idPista) VALUES (?,?,?,?,?)"; 
    final String UPDATE = "UPDATE jugadores usuario = ? , nombre = ?, email = ?, apellidos = ?, fechaNacimiento = ?, contraseña = ?,telefono = ? WHERE idJugador = ?";
    final String DELETE = "DELETE FROM jugadores WHERE idJugador = ?";
    final String GETALL = "SELECT idJugador, usuario, nombre, email, apellidos, fechaNacimiento, contraseña, telefono FROM jugadores";
    final String GETONE = "SELECT idJugador, usuario, nombre, email, apellidos, fechaNacimiento, contraseña, telefono FROM jugadores WHERE idJugaodr = ?";
    
    
    
    private Connection conn;
    
    public MySQLPartidoDAO(Connection conn) {
        
        this.conn = conn;
        
    }
    

    @Override
    public void insertar(Partido p) throws DAOException {
        
        PreparedStatement stat = null;
        
        try{
            
            stat = conn.prepareStatement(INSERT);
            stat.setLong(1, p.getId());
            stat.setString(2, p.getDeporte());
            stat.setLong(3, p.getReserva());
            stat.setLong(4, p.getCreador());
            stat.setLong(5, p.getPistaPartido());
            stat.setString(6, p.getEstado());
            stat.setInt(7, p.getNumeroJugadores());
            stat.setInt(8, p.getNivelPartido());
            
            if(stat.executeUpdate() == 0){
                throw new DAOException("Puede que no se haya guardado.");
            }
            
        } catch(SQLException ex){
            throw new DAOException("Error en SQL", ex);
        } finally{
            if (stat !=  null){
                
                try{
                    stat.close();
                }catch(SQLException ex){
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
    }

    
    @Override
    public void modificar(Jugador j) throws DAOException{

         PreparedStatement stat = null;
        
        try{
            
            stat = conn.prepareStatement(UPDATE);
            stat.setString(1, j.getUsuario());
            stat.setString(2, j.getNombre());
            stat.setString(3, j.getEmail());
            stat.setString(4, j.getApellidos());
            stat.setDate(5, new Date(j.getFechaNacimiento().getTime()));
            stat.setString(6, j.getContraseña());
            stat.setInt(7, j.getTelefono());
            stat.setLong(8, j.getId());
            
            if(stat.executeUpdate() == 0){
                throw new DAOException("Puede que no se haya guardado.");
            }
            
        } catch(SQLException ex){
            throw new DAOException("Error en SQL", ex);
        } finally{
            if (stat !=  null){
                
                try{
                    stat.close();
                }catch(SQLException ex){
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
        
    }


    @Override
    public void eliminar(Jugador j) throws DAOException{
        
        
        PreparedStatement stat = null;
        
        try{
            
            stat = conn.prepareStatement(DELETE);
            stat.setLong(1, j.getId());

            if(stat.executeUpdate() == 0){
                throw new DAOException("Puede que no se haya guardado.");
            }
            
        } catch(SQLException ex){
            throw new DAOException("Error en SQL", ex);
        } finally{
            if (stat !=  null){
                
                try{
                    stat.close();
                }catch(SQLException ex){
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
    }

    
    private Jugador convertir(ResultSet rs) throws SQLException{
        
        String usuario = rs.getString("usuario");
        String nombre = rs.getString("nombre");
        String apellidos = rs.getString("apellidos");
        String contraseña = rs.getString("contraseña");
        String email = rs.getString("email");
        Date fechaNacimiento = rs.getDate("fechaNacimiento");
        int telefono = rs.getInt("telefono");
        
        Jugador j = new Jugador(usuario, nombre, apellidos, email, telefono, contraseña, fechaNacimiento);
        j.setId(rs.getLong("idJujador"));
        
        return j;
        
    }
    
    @Override
    public List<Jugador> obtenerTodos() throws DAOException{

       PreparedStatement stat = null;
       ResultSet rs = null;
       List<Jugador> jugadores = new ArrayList<>();
       
       try{
           
           stat = conn.prepareStatement(GETALL);
           rs = stat.executeQuery();
           while(rs.next()){
               
               jugadores.add(convertir(rs));
               
           }
           
       }catch(SQLException ex){
            throw new DAOException("Error en SQL, ex");
       }finally{
           
           if(rs != null){
               
               try{
                   rs.close();
               }catch(SQLException ex){
                   new DAOException("Error en SQL, ex");
               }
               
           }
           if(stat != null){
               
               try{
                   stat.close();
               }catch(SQLException ex){
                   new DAOException("Error en SQL, ex");
               }
               
           }
       }
       
        return jugadores;
    }


    @Override
    public Jugador obtener(Long id) throws DAOException{
        
       PreparedStatement stat = null;
       ResultSet rs = null;
       Jugador j;
       
       try{
           
           stat = conn.prepareStatement(GETONE);
           stat.setLong(1, id);
           rs = stat.executeQuery();
           if(rs.next()){
               
               j = convertir(rs);
               
           }else{
               throw new DAOException("No se ha encontrado ese registro.");
           }
           
       }catch(SQLException ex){
            throw new DAOException("Error en SQL, ex");
       }finally{
           
           if(rs != null){
               
               try{
                   rs.close();
               }catch(SQLException ex){
                   new DAOException("Error en SQL, ex");
               }
               
           }
           if(stat != null){
               
               try{
                   stat.close();
               }catch(SQLException ex){
                   new DAOException("Error en SQL, ex");
               }
               
           }
       }
       
        return j;
    }
    
    
    public static void main(String[] args) throws SQLException, DAOException{
        
        Connection conn = null;
        try{
            //
            conn = DriverManager.getConnection("jdbc:mysql://localhost/ej", "root", "1234");
            JugadorDao alumnodao = new MySQLJugadorDAO(conn);
            List<Jugador> jugadores = alumnodao.obtenerTodos();
            for(Jugador j: jugadores){
                System.out.println(j.toString());
            }
        }finally{
            if(conn != null){
                conn.close();
            }
        }
        
    }
}
