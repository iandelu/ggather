/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iw;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.logging.Logger;


/**
 *
 * @author crist
 */

/**
 * Clase que permite guardar toda la informacion sobre los jugadores,
 * asi como proporcionarla a las demas clases mediante los metodos get y set
 * 
 */
public class Jugador {
    
    //Atributos basicos de la clase Jugador
    private Long id = null;
    private String usuario;
    private String nombre;
    private String apellidos;
    private String email;
    private long telefono;
    private String contraseña;
    private float valoracionMedia;

    private Date fechaNacimiento;
    private long edad;
    
    /*
    //Nivel de cada deporte asociada a un jugador
    private Map<String, Integer> nivelesJugador = new HashMap();
    
    //Valoración del resto de Jugadores
    private ArrayList<Valoracion> valoracionesJugador = new ArrayList<Valoracion>();
    
    //Historial de partidos del jugador
    private ArrayList<Partido> historialPartidos = new ArrayList<Partido>();
    
    //
    private ArrayList<Tarjeta> historialTarjetas = new ArrayList<Tarjeta>();

    */
    
    //Constructor para el login de la clase Jugador
    public Jugador(String usuario, String nombre, String apellidos, String email, long telefono, String contraseña, Date fechaNacimiento, float valoracionMedia) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.contraseña = contraseña;
        this.fechaNacimiento = fechaNacimiento;
        this.valoracionMedia = valoracionMedia;
        //this.edad = calcularEdad();
    }
    
    

    public Jugador(String usuario, String nombre, String apellidos, String email, long telefono) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
    }
   
    
    
    
//Constructor vacio de la clase Jugador
    
    public Jugador(){}
    
    
    
//getters de la clase Jugador

    public Long getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public long getTelefono() {
        return telefono;
    }

    public String getContraseña() {
        return contraseña;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public long getEdad() {
        return edad;
    }

    public float getValoracionMedia(){
        return valoracionMedia;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setValoracionMedia(float valoracionMedia){
        this.valoracionMedia = valoracionMedia;
    }
    

//setters de la clase Jugador
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        this.edad = calcularEdad();
    }

    //to string
    @Override
    public String toString() {
        return "Jugador{" + "id=" + id + ", usuario=" + usuario + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + ", edad=" + edad + '}';
    }
    
    
    
    //Método utilizado para calcular la edad y añadirla al usuario.
    public long calcularEdad() {
        LocalDate hoy = LocalDate.now();
        LocalDate nacimiento = this.getFechaNacimiento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        long edad = ChronoUnit.YEARS.between(nacimiento, hoy);
        
        return edad;
    }
    
    
    
    
    
    /*
    public void actualizarNivel(String deporte, Integer nivelNuevo){
        
        this.nivelesJugador.put(deporte, nivelNuevo);
        
    }
    
    //Calcula las estrellas en funcion de las valoraciones
    public double calcularEstrellas(){
        
        int suma = 0;
        
        for(int i = 0; i < valoracionesJugador.size();i++){
            
            suma = suma + this.valoracionesJugador(i).getValoracion();
        }
    
        suma = Math.round((suma/this.valoracionesJugador.size())%5);
        return suma;
        
    }
    */
    
    public static Date setFechaString(String fecha){

        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        Date fechaDate = null;

        try{

            fechaDate = (Date) formato.parse(fecha);
 
        }catch(ParseException ex){

            System.out.println(ex);
        }

        return fechaDate;
    }
    
}
