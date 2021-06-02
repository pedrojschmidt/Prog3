package Archivos;

public class Producto {
    private int codigo;
    private String descripcion;
    private double precio;
    private char tipo;
    private boolean activo;

    public Producto() {
    }

    public Producto(int codigo, String descripcion, double precio,  char tipo, boolean activo) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipo = tipo;
        this.activo = activo;
    }


    public int getCodigo() {
        return codigo;
    }


    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Producto [codigo=" + codigo + ", precio=" + precio
                +   ", tipo=" + tipo + ", activo="
                + activo + "]";
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
