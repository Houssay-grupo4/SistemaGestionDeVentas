package sistemagestionventascompras;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Venta {

    private Integer codigo_venta;
    private LocalDate fecha_venta;
    private Double total_venta;

    private List<Producto> listaProductos;

    private Cliente cliente;

    public Venta() {
        this.listaProductos = new ArrayList<>();
    }

    public Venta(Integer codigo_venta, LocalDate fecha_venta, Double total_venta, List<Producto> listaProductos, Cliente cliente) {
        this.codigo_venta = codigo_venta;
        this.fecha_venta = fecha_venta;
        this.total_venta = total_venta;
        this.listaProductos = listaProductos;
        this.cliente = cliente;
    }

    public Integer getCodigo_venta() {
        return codigo_venta;
    }

    public void setCodigo_venta(Integer codigo_venta) {
        this.codigo_venta = codigo_venta;
    }

    public LocalDate getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(LocalDate fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public Double getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(Double total_venta) {
        this.total_venta = total_venta;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void ingresarVentaNueva(Cliente cliente, List<Producto> productos) {
        Random random = new Random();
        int codigoVentaAleatorio = random.nextInt(1000) + 1;
        LocalDate fechaVentaActual = LocalDate.now();

        if (cliente == null) {
            System.out.println("\nNo se ha especificado un cliente para la venta.");
            return;
        }

        if (productos == null || productos.isEmpty()) {
            System.out.println("\nLa lista de productos está vacía.");
            return;
        }

        this.codigo_venta = codigoVentaAleatorio;
        this.fecha_venta = fechaVentaActual;
        this.cliente = cliente;
        listaProductos.addAll(productos);
        total_venta = listaProductos.stream().mapToDouble(producto -> producto.getPrecio()).sum();

        System.out.println("\n¡¡¡VENTA REGISTRADA CON ÉXITO!!!");
    }

    public List<Venta> listarVentas(List<Venta> listaVentas, Venta ventaNueva) {
        listaVentas.add(ventaNueva);
        return listaVentas;
    }

    public Venta buscarVentaPorCodigo(List<Venta> listaVentas, Integer codigo) {
        for (Venta venta : listaVentas) {
            if (venta.getCodigo_venta() != null && venta.getCodigo_venta().equals(codigo)) {
                return venta;
            }
        }
        return null; 
    }

    @Override
    public String toString() {
        return "\nVenta{" + "codigo_venta=" + codigo_venta + ", fecha_venta=" + fecha_venta
                + ", total_venta=" + total_venta + ", listaProductos=" + listaProductos
                + ", cliente=" + cliente + '}';
    }

}
