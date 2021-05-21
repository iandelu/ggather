/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iw.mysql;


import com.mycompany.iw.Club;
import com.mycompany.iw.Jugador;
import com.mycompany.iw.Partido;
import com.mycompany.iw.Pista;
import com.mycompany.iw.Precio;
import com.mycompany.iw.Puntuacion;
import com.mycompany.iw.Reserva;
import com.mycompany.iw.Resultado;
import com.mycompany.iw.Tarjeta;
import com.mycompany.iw.Valoracion;
import com.mycompany.iw.daos.DAOException;
import com.mycompany.iw.daos.JugadorDao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


/**
 *
 * @author LuisAneri
 */
public class MySQLDaoManager  {
    
    private Connection conn;
    
    private MySQLClubDAO clubs =  null;
    private MySQLJugadorDAO jugadores =  null;
    private MySQLPartidoDAO partidos=  null;
    private MySQLPistaDAO pistas =  null;
    private MySQLPrecioDAO precios =  null;
    private MySQLPuntuacionDAO puntuaciones =  null;
    private MySQLReservaDAO reservas =  null;
    private MySQLResultadoDAO resultados =  null;
    private MySQLTarjetaDAO tarjetas =  null;
    private MySQLValoracionDAO valoraciones =  null;
    
    public MySQLDaoManager(String host, String username, String password , String database) throws SQLException{
        
        String url = "jdbc:mysql://" + host + "/" + database;
        conn = DriverManager.getConnection(url , username, password);
        
    }    
 
    
    public MySQLClubDAO getClubDAO(){
        
        if(clubs == null){
            clubs = new MySQLClubDAO(conn);
        }
        return clubs;
    }
    
    public MySQLJugadorDAO getJugadorDAO(){
        
        if(jugadores == null){
            jugadores = new MySQLJugadorDAO(conn);
        }
        return jugadores;
    }
    
    
    public MySQLPartidoDAO getPartidoDAO(){
        
        if(partidos == null){
            partidos = new MySQLPartidoDAO(conn);
        }
        return partidos;
    }
    
    
    public MySQLPistaDAO getPistaDAO(){
        
        if(pistas == null){
            pistas = new MySQLPistaDAO(conn);
        }
        return pistas;
    }
    
    public MySQLPrecioDAO getPrecioDAO(){
        
        if(precios == null){
            precios = new MySQLPrecioDAO(conn);
        }
        return precios;
    }
    
    public MySQLPuntuacionDAO getPuntuacionDAO(){
        
        if(puntuaciones == null){
            puntuaciones = new MySQLPuntuacionDAO(conn);
        }
        return puntuaciones;
    }
    
    public MySQLReservaDAO getReservaDAO(){
        
        if(reservas == null){
            reservas = new MySQLReservaDAO(conn);
        }
        return reservas;
    }
    
    public MySQLResultadoDAO getResultadoDAO(){
        
        if(resultados == null){
            resultados = new MySQLResultadoDAO(conn);
        }
        return resultados;
    }
    
    public MySQLTarjetaDAO getTarjetaDAO(){
        
        if(tarjetas == null){
            tarjetas = new MySQLTarjetaDAO(conn);
        }
        return tarjetas;
    }
    
    public MySQLValoracionDAO getValoracionDAO(){
        
        if(valoraciones == null){
            valoraciones = new MySQLValoracionDAO(conn);
        }
        return valoraciones;
    }
    
    
    
    
    
    public static void main(String[] args) throws SQLException, DAOException, ClassNotFoundException{
        
        Connection conn = null;
        try{
            //
            Class.forName("com.mysql.jdbc.Driver");
            MySQLDaoManager man = new MySQLDaoManager("ggather.zapto.org", "java", "1234", "aplicacion");
            
            
            //TEST JUGADOR - OK!
           
            //Constructor -> ok
            Jugador j = new Jugador( "elepepe",  "antonio",  "raso",  "antonioraso@uco.es", 635062813, "asdafdf",  new Date(2000,9,13), 0);
            
            //Insertar -> ok
            man.getJugadorDAO().insertar(j);
            
            //Obtener todos -> ok
            List<Jugador> jugadores = man.getJugadorDAO().obtenerTodos();
            
            
            for(Jugador a: jugadores){
                System.out.println(a.toString());
            }
            
            //Obtener y modificar -> ok
            j = man.getJugadorDAO().obtener((long)8);
           j.setUsuario("Hola");

           man.getJugadorDAO().modificar(j);
           
           j = man.getJugadorDAO().obtener((long)8);
            
            //Eliminar -> ok
            man.getJugadorDAO().eliminar(j);
  
           
           
           
           //TEST PISTA - OK!
           /*
           //Constructor -> ok
           Pista p = new Pista((long)1, LocalTime.of(16,00), LocalTime.of(18,00), 1, (long)12 );
           
           //Insertar -> ok
            man.getPistaDAO().insertar(p);
           
           //Obtener todos -> ok
            List<Pista> pistas = man.getPistaDAO().obtenerTodos();
            
            
            for(Pista a: pistas){
                System.out.println(a.toString());
            }
            

           //Obtener y modificar -> ok
           p = man.getPistaDAO().obtener((long)4);
           p.setHorarioInicio(LocalTime.of(15, 45));
           man.getPistaDAO().modificar(p);
           
           //Eliminar -> ok
          man.getPistaDAO().eliminar(p);*/
           
           
           
           
            //TEST PARTIDO - OK!
            /*
            //Constructor -> ok
            Partido p = new Partido( (long)2, (long) 3, (long) 4,  "PENDIENTE",  1600);
   
             //Insertar -> ok
            man.getPartidoDAO().insertar(p);
            
            //Obtener y modificar -> ok
            p = man.getPartidoDAO().obtener((long)2);
            p.setNivelPartido(1000);

            man.getPartidoDAO().modificar(p);
            
            //Obtener todos -> ok
            List<Partido> partidos = man.getPartidoDAO().obtenerTodos();
            
            for(Partido a: partidos){
                System.out.println(a.toString());
            }
            
            //Eliminar -> ok
            man.getPartidoDAO().eliminar(p);*/
          
           
            
            
           //TEST CLUB - OK!
           /*
           //Constructor -> ok
           Club c = new Club( "Club", "localizacion", "email", "1234", (long) 123, "Propietario", true );
           
           //Insertar -> ok
           man.getClubDAO().insertar(c);
           
           //Obtener y modificar -> ok
           c = man.getClubDAO().obtener((long)13);
           c.setNombreClub("Hola");
           c.setLocalizacion("Localizacion");

           man.getClubDAO().modificar(c);
           
           //Obtener todos -> ok
           List<Club> clubs = man.getClubDAO().obtenerTodos();
           for(Club a: clubs){
                System.out.println(a.toString());
            }
           
           //Eliminar -> ok
           man.getClubDAO().eliminar(c);
           
            */
           
           
           //TEST RESERVA - OK!
           /*
           //Constructor -> ok
           Reserva r = new Reserva(LocalTime.of(01, 00), LocalTime.of(02, 00), LocalDate.of(2021, 01, 01), (long)4);
           
           //Insertar -> ok
           man.getReservaDAO().insertar(r);
           
           //Obtener y modificar -> ok
           r = man.getReservaDAO().obtener((long)1);
           r.setPista((long)5);

           man.getReservaDAO().modificar(r);
           
           
           //Obtener todos -> ok
           List<Reserva> reservas = man.getReservaDAO().obtenerTodos();
           for(Reserva a: reservas){
                System.out.println(a.toString());
            }
           
           //Eliminar -> ok
           man.getReservaDAO().eliminar(r);*/
           
           
           
           
           
           //TEST PRECIO - OK!
           /*
           //Constructor -> ok
           Precio p = new Precio((long)12, (long)1, "MAÑANA", (float)15);
           
           //Insertar -> ok
           man.getPrecioDAO().insertar(p);
           
           //Obtener y modificar -> ok
           p = man.getPrecioDAO().obtener((long)1);
           p.setMañanaTarde("TARDE");

           man.getPrecioDAO().modificar(p);
           
           
           //Obtener todos -> ok
           List<Precio> precios = man.getPrecioDAO().obtenerTodos();
           for(Precio a: precios){
                System.out.println(a.toString());
            }
           
           //Eliminar -> ok
          man.getPrecioDAO().eliminar(p);*/
           
           
           
           //TEST PUNTUACION - OK!
           /*
           //Constructor -> ok
           Puntuacion p = new Puntuacion(1, "comentario", (long)4, (long)1);
           
           //Insertar -> ok
           man.getPuntuacionDAO().insertar(p);
           
           //Obtener y modificar -> ok
           p = man.getPuntuacionDAO().obtener((long)1);
           p.setComentario("Hola");

           man.getPuntuacionDAO().modificar(p);
           
           //Obtener todos -> ok
           List<Puntuacion> puntuaciones = man.getPuntuacionDAO().obtenerTodos();
           for(Puntuacion a: puntuaciones){
                System.out.println(a.toString());
            }
          
           //Eliminar -> ok
          man.getPuntuacionDAO().eliminar(p);*/
           
           
           
           
           //TEST RESULTADO - OK!
           /*
           //Constructor -> ok
           Resultado r = new Resultado((long)1, (long)3, "resultado", (long)1);
           
           //Insertar -> ok
           man.getResultadoDAO().insertar(r);
           
           //Obtener y modificar -> ok
           r = man.getResultadoDAO().obtener((long)1);
           r.setMVP((long)3);

           man.getResultadoDAO().modificar(r);
           
           //Obtener todos -> ok
           List<Resultado> resultados = man.getResultadoDAO().obtenerTodos();
           for(Resultado a: resultados){
                System.out.println(a.toString());
            }
           
           //Eliminar -> ok
          man.getResultadoDAO().eliminar(r);*/
           
           
           
           //TEST TARJETA - OK!
          /* 
           //Constructor -> ok
           Tarjeta t = new Tarjeta((long)1, (long)1, "tipo", "motivo", "comentario");
           
           //Insertar -> ok
           man.getTarjetaDAO().insertar(t);
           
           //Obtener y modificar -> ok
           t = man.getTarjetaDAO().obtener((long)1);
           t.setComentario("Hola");

           man.getTarjetaDAO().modificar(t);
           
           //Obtener todos -> ok
           List<Tarjeta> tarjetas = man.getTarjetaDAO().obtenerTodos();
           for(Tarjeta a: tarjetas){
                System.out.println(a.toString());
            }
           
           //Eliminar -> ok
          man.getTarjetaDAO().eliminar(t);*/
           
           
           
            //TEST VALORACION - OK!
          /*
            //Constructor -> ok
            Valoracion v = new Valoracion((long)1, (long)3, 3, "comentario");
            
            //Insertar -> ok
           man.getValoracionDAO().insertar(v);
            
            //Obtener y modificar -> ok
           v = man.getValoracionDAO().obtener((long)1);
           v.setComentario("Hola");

           man.getValoracionDAO().modificar(v);
           
            //Obtener todos -> ok
           List<Valoracion> valoraciones = man.getValoracionDAO().obtenerTodos();
           for(Valoracion a: valoraciones){
                System.out.println(a.toString());
            }
           
            //Eliminar -> ok
          man.getValoracionDAO().eliminar(v);*/
           
           
           
           
           
        }finally{
            if(conn != null){
                conn.close();
            }
        }
        
    }
    
}
