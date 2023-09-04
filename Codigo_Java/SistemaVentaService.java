package sistemagestionventascompras;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static sistemagestionventascompras.SistemaGestionVentasCompras.main;

public class SistemaVentaService {

    Scanner leer;
    Venta venta;
    List<Venta> listaVentas;

    public SistemaVentaService() {
        this.leer = new Scanner(System.in);
        this.venta = new Venta();
        this.listaVentas = new ArrayList<>();
    }

    public void menuGestionVentas() {
        String salir = "N";
        int opcion;
        do {
            System.out.println("\n************** BIENVENIDO A LA GESTIÓN DE VENTAS **************");
            System.out.println("¿Qué es lo que desea hacer?:");
            System.out.println("1) Ingresar una venta nueva.");
            System.out.println("2) Ver listado de todas las ventas.");
            System.out.println("3) Buscar una venta por su código.");
            System.out.println("4) Volver al menú principal.");
            System.out.print("Ingrese la opción seleccionada: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    Venta ventaNueva = ingresoVenta();
                    listaVentas.add(ventaNueva);
                    break;
                case 2:
                    listarTodasLasVentas(listaVentas);
                    break;
                case 3:
                    System.out.print("\nIngrese el código de la venta a buscar: ");
                    int codigoBusqueda = leer.nextInt();
                    Venta ventaEncontrada = venta.buscarVentaPorCodigo(listaVentas, codigoBusqueda);
                    if (ventaEncontrada != null) {
                        System.out.println("\nVenta encontrada: " + ventaEncontrada);
                    } else {
                        System.out.println("\nNo se encontró ninguna venta con ese código.");
                    }
                    break;
                case 4:
                    System.out.println("\n¿Desea volver al menú principal? (S/N): ");
                    salir = leer.next();
                    break;
                default:
                    System.out.println("\nOpción no válida.");
            }

        } while (salir.equalsIgnoreCase("N"));
        if (salir.equalsIgnoreCase("S")) {
            main(new String[]{});
        }

    }

    public Venta ingresoVenta() {
        Cliente cliente = new Cliente();
        Producto producto = new Producto();
        Cliente clienteNuevo = cliente.crearClienteNuevo();
        String continuarIngreso;
        
        Venta ventaNueva = new Venta();
        List<Producto> carritoProductos = new ArrayList<>();

        do {
            Producto productoNuevo = producto.ingresarProductoNuevo();
            carritoProductos.add(productoNuevo);

            System.out.print("\nDesea agregar otro producto al carrito? (S/N): ");
            continuarIngreso = leer.next();

        } while (continuarIngreso.equalsIgnoreCase("S"));

        ventaNueva.ingresarVentaNueva(clienteNuevo, carritoProductos);

        return ventaNueva;
    }

    public void listarTodasLasVentas(List<Venta> listaVentas) {
        if (listaVentas.isEmpty()) {
            System.out.println("\nNo hay ventas registradas.");
            return;
        }

        System.out.println("\nLISTADO DE VENTAS:");
        for (Venta venta : listaVentas) {
            System.out.println(venta);
        }

    }

}
