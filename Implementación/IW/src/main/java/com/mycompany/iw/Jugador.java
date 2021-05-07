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
import java.util.Iterator;


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

    private Date fechaNacimiento;
    private long edad;
    
    //Nivel de cada deporte asociada a un jugador
    private Map<String, Integer> nivelesJugador = new HashMap();
    
    
    //Valoración del resto de Jugadores
    private LinkedList<Long> valoracionesJugador = new LinkedList<Long>();
    
    //Valoración del resto de Jugadores
    private LinkedList<Long> historialPartidos = new LinkedList<Long>();
    
    
    //Constructor completo de la clase Jugador

    public Jugador(String usuario, String nombre, String apellidos, String email,int telefono, Date fechaNacimiento
                     ,LinkedList<Long> historialPartidos, LinkedList<Long> valoracionesJugador, Map<String,Integer> nivelesJugador ) {
        
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
        
    }
    
    
    
//Constructor vacio de la clase Jugador
    
    public Jugador(){}
    
    
    
//getters de la clase Jugador
    
    public Long getId(){
        
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

    public LinkedList<Long> getValoracionesJugador() {
        return valoracionesJugador;
    }

    public LinkedList<Long> getHistorialPartidos() {
        return historialPartidos;
    }

    

//setters de la clase Jugador

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

    public void setValoracionesJugador(LinkedList<Long> valoracionesJugador) {
        this.valoracionesJugador = valoracionesJugador;
    }

    public void setHistorialPartidos(LinkedList<Long> historialPartidos) {
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
    
    //
    public double calcularEstrellas(){
        
        double suma = 0;
        Iterator iterador = this.valoracionesJugador.iterator();
        
        while(iterador.hasNext()){
            
            suma = suma + iterador.next();
            
        }
    
        suma = Math.round((suma/this.valoracionesJugador.size())%5);
        
        return suma;
        
    }
}
