package com.example.carelibroapp;

public class User {

    private String nombre;
    private String genero;
    private String telefono;
    private String email;
    private String fechaNac;
    private String id;
    private String ciudad;

    public User() {
        this.nombre = "";
        this.genero = "";
        this.telefono = "";
        this.email = "";
        this.fechaNac = "";
        this.id = "";
        this.ciudad = "";
    }

    public User(String nombre, String genero, String telefono, String email, String fechaNac,String id,String ciudad) {
        this.nombre = nombre;
        this.genero = genero;
        this.telefono = telefono;
        this.email = email;
        this.fechaNac = fechaNac;
        this.id = id;
        this.ciudad = ciudad;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
