package com.example.carelibroapp;

public class User {

    public String nombre;
    public String genero;
    public String telefono;
    public String email;
    public String fechaNac;

    public User() {
    }

    public User(String nombre, String genero, String telefono, String email, String fechaNac) {
        this.nombre = nombre;
        this.genero = genero;
        this.telefono = telefono;
        this.email = email;
        this.fechaNac = fechaNac;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }
}
