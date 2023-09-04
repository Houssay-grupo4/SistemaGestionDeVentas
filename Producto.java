package sistemagestionventascompras;

import java.util.Random;
import java.util.Scanner;

public class Producto {

    private int codigo_producto;
    private String nombre;
    private int cantidad;
    private Double precio;

    public Producto() {
    }

    public Producto(int codigo_producto, String nombre, int cantidad, Double precio) {
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(int codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    private void validarDatosProducto(String nombre,int cantidad, Double precio) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("Debe indicar el nombre del producto.");
        }
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser un número positivo.");
        }
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser un número positivo.");
        }
    }

    public Producto ingresarProductoNuevo() {
        Scanner leer = new Scanner(System.in);
        try {
            Random random = new Random();
            int codigo_producto = random.nextInt(1000) + 1;
            System.out.println("\nIngrese los siguientes datos del producto:");
            System.out.print("Nombre del producto: ");
            nombre = leer.nextLine();
            //leer.nextLine();
            System.out.print("Precio del producto: ");
            precio = leer.nextDouble();
            System.out.print("Cantidad de unidades del producto: ");
            cantidad = leer.nextInt();

            validarDatosProducto(nombre, cantidad, precio);
            Producto producto = new Producto(codigo_producto, nombre, cantidad, precio);
            
            System.out.println("\n¡¡¡PRODUCTO GUARDADO CON ÉXITO!!!");
            
            return producto;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String toString() {
        return "\nProducto{" + "codigo_producto=" + codigo_producto + ", nombre=" + nombre
                + ", cantidad=" + cantidad + ", precio=" + precio + '}';
    }

}
