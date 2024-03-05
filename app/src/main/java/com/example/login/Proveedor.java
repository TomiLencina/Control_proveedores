package com.example.login;


public class Proveedor {
    private int idUsuario;
    private String rubro;
    private String proyecto;
    private int cantidad;
    private String producto;
    // Constructor

    public Proveedor(int idUsuario, String rubro, String proyecto, int cantidad, String producto) {
        this.idUsuario = idUsuario;
        this.rubro = rubro;
        this.proyecto = proyecto;
        this.cantidad = cantidad;
        this.producto = producto;
    }

    // Getters y Setters (métodos para acceder y modificar los atributos)
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
}
