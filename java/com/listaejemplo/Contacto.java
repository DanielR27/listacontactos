package com.listaejemplo;

import java.util.ArrayList;

/**
 * Created by soporte5 on 27/08/2016.
 */
public class Contacto {

    String nombre = "";
    ArrayList<String> telefonos = null,correos = null;
    boolean checked;

    public Contacto(String nombre,ArrayList<String> telefonos, ArrayList<String> correos, boolean checked){
        this.nombre = nombre;
        this.telefonos = telefonos;
        this.correos = correos;
        this.checked = checked;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(ArrayList<String> telefonos) {
        this.telefonos = telefonos;
    }

    public ArrayList<String> getCorreos() {
        return correos;
    }

    public void setCorreos(ArrayList<String> correos) {
        this.correos = correos;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
