package com.example.login;

public class Usuario {
    int id;
    String Nombre,Apellidos,Usuarios,Password;

    public Usuario(){
    }

    public Usuario(String nombre, String apellidos, String usuarios, String password) {
        Nombre = nombre;
        Apellidos = apellidos;
        Usuarios = usuarios;
        Password = password;
    }

    public boolean isNull(){
        if(Nombre.equals("")&&Apellidos.equals("")&&Password.equals("")) {
            return false;
        }else {
            return true;
        }
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", Nombre='" + Nombre + '\'' +
                ", Apellidos='" + Apellidos + '\'' +
                ", Usuarios='" + Usuarios + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getUsuario() {
        return Usuarios;
    }

    public void setUsuario(String usuarios) {
        Usuarios = usuarios;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
