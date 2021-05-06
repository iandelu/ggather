/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iw;
import java.sql.Date;
import java.time.*;
import java.time.temporal.ChronoUnit;


/**
 *
 * @author crist
 */

/**
 * Clase que permite guardar toda la informacion sobre los jugadores,
 * asi como proporcionarla a las demas clases mediante los metodos get y set
 * 
 * 
 * 
 *
 */
public class Jugador {
    
    //Atributos de la clase Jugador
    private int id;
    private String usuario;
    private String contraseña;
    private String email;
    private String nombre;
    private String apellidos;
    private Date fechaNacimiento;
    
    
    
    //Constructor completo de la clase Jugador
    public Jugador(int id, String usuario, String contraseña, String email, String nombre, String apellidos, Date fechaNacimiento){
    
        this.id = id;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.email = email;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento; 
    }
    
    //Constructor vacio de la clase Jugador
    public Jugador(){}

    public int getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public long getEdad(){
        
        LocalDate hoy = LocalDate.now();
        LocalDate nacimiento = this.getFechaNacimiento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        long edad = ChronoUnit.YEARS.between(nacimiento, hoy);
        
        return edad;
    }
        
    
}
