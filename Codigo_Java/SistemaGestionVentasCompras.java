package sistemagestionventascompras;

import java.util.Scanner;

public class SistemaGestionVentasCompras {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        SistemaVentaService sistemaVenta = new SistemaVentaService();
        Compras compras = new Compras();
        Cobros cobros = new Cobros();
        int opcion = 0;

        while (opcion != 5) {
            System.out.println("************** BIENVENIDO A LA GESTIÓN DE LA EMPRESA **************");
            System.out.println("¿Qué es lo que desea hacer?:");
            System.out.println("1) Ingresar a gestión de ventas.");
            System.out.println("2) Ingresar a gestión de compras.");
            System.out.println("3) Ingresar a gestión de Cobranzas.");
            System.out.println("4) Ingresar a gestión de Pagos.");
            System.out.println("5) Salir.");
            System.out.print("\nIngrese la opción seleccionada: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    sistemaVenta.menuGestionVentas();
                    break;
                case 2:
                    compras.menuCompras();
                    break;
                case 3:
                    cobros.mostrarMenu();
                    break;
                case 5:
                    System.out.println("Saliendo del Sistema...\nHasta la próxima!!!!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una de las opciones que aparecen en el menú.");
            }
        }

    }

}
