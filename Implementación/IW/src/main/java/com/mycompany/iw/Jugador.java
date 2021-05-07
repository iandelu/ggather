/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iw;
import java.sql.Date;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;


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
    private int telefono;
    private String contraseña;

    private Date fechaNacimiento;
    private long edad;
    
    //Nivel de cada deporte asociada a un jugador
    private Map<String, Integer> nivelesJugador = new HashMap();
    
    //Valoración del resto de Jugadores
    private ArrayList<Valoracion> valoracionesJugador = new ArrayList<Valoracion>();
    
    //Historial de partidos del jugador
    private ArrayList<Partido> historialPartidos = new ArrayList<Partido>();
    
    //
    private ArrayList<Tarjeta> historialTarjetas = new ArrayList<Tarjeta>();
    
    
    
    
    //Constructor completo de la clase Jugador

    public Jugador(String usuario, String nombre, String apellidos, String email,int telefono, Date fechaNacimiento, ArrayList<Tarjeta> historialTarjetas
                     ,ArrayList<Partido> historalPartidos, ArrayList<Valoracion> valoracionesJugador, Map<String,Integer> nivelesJugador, String contraseña) {
        
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = calcularEdad();
        this.nivelesJugador = nivelesJugador;
        this.historialPartidos = historialPartidos;
        this.valoracionesJugador = valoracionesJugador;
        this.historialTarjetas = historialTarjetas;
        this.contraseña = contraseña;
        
    }

    public Jugador(String usuario, String nombre, String apellidos, String email, int telefono, int nivel, String deporte) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        
    }
   
    
    
    
//Constructor vacio de la clase Jugador
    
    public Jugador(){}
    
    
    
//getters de la clase Jugador
    
    
    public String getEmail(){
        
        return email;
    }

    public String getContraseña() {
        return contraseña;
    }

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

    public int getTelefono() {
        return telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public long getEdad() {
        return edad;
    }

    public Map<String, Integer> getNivelesJugador() {
        return nivelesJugador;
    }

    public ArrayList<Valoracion> getValoracionesJugador() {
        return valoracionesJugador;
    }

    public ArrayList<Partido> getHistorialPartidos() {
        return historialPartidos;
    }
    
    public Integer getNivelJugador(String deporte) {
        return nivelesJugador.get(deporte);
    }
    
//setters de la clase Jugador
    public void setId(Long id) {
        this.id = id;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setEdad(long edad) {
        this.edad = edad;
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

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setNivelesJugador(Map<String, Integer> nivelesJugador) {
        this.nivelesJugador = nivelesJugador;
    }

    public void setValoracionesJugador(ArrayList<Valoracion> valoracionesJugador) {
        this.valoracionesJugador = valoracionesJugador;
    }

    public void setHistorialPartidos(ArrayList<Partido> historialPartidos) {
        this.historialPartidos = historialPartidos;
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
    
    public void actualizarNivel(String deporte, Integer nivelNuevo){
        
        this.nivelesJugador.put(deporte, nivelNuevo);
        
    }
    
    //Calcula las estrellas en funcion de las valoraciones
    public double calcularEstrellas(){
        
        int suma = 0;
        
        for(int i = 0; i < valoracionesJugador.size();i++)
            
            suma = suma + this.valoracionesJugador(i).getValoracion();
        }
    
        suma = Math.round((suma/this.valoracionesJugador.size())%5);
        
        return suma;
        
    }
}
