package sistemagestionventascompras;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class sistemaPagos {
    private static List<Pago> pagos;
    private static List<Cliente> clientes;

    public sistemaPagos() {
        pagos = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    public static void registrarPago(Cliente cliente, double monto) {
        Pago pago = new Pago(pagos.size() + 1, LocalDate.now(), monto);
        pagos.add(pago);
        clientes.add(cliente);
    }

    public static void generarReporte() {
        System.out.println("************** REPORTE DE PAGOS **************");
        
        System.out.println("IDs de Pagos Disponibles:");
        for (int i = 0; i < pagos.size(); i++) {
            Pago pago = pagos.get(i);
            System.out.println(pago.getId() + ": " + pago.getFecha() + " - " + pago.getMonto());
        }
        
        try (Scanner leer = new Scanner(System.in)) {
            System.out.print("Ingrese el ID del pago para generar el reporte (0 para cancelar): ");
            int idSeleccionado = leer.nextInt();
            
            if (idSeleccionado == 0) {
                System.out.println("Cancelando generación de reporte.");
            } else {
                boolean encontrado = false;
                for (int i = 0; i < pagos.size(); i++) {
                    Pago pago = pagos.get(i);
                    if (pago.getId() == idSeleccionado) {
                        encontrado = true;
                        System.out.println("Generando reporte para el Pago ID: " + pago.getId() + "...");   
                        System.out.println("Reporte generado para el Pago ID: " + pago.getId());
                        break;
                    }
                }
                
                if (!encontrado) {
                    System.out.println("Pago con ID " + idSeleccionado + " no encontrado.");
                }
            }
        }
    }

    public void menuGestionPagos() {
        try (Scanner leer = new Scanner(System.in)) {
            int opcion;
            do {
                System.out.println("************** GESTIÓN DE PAGOS **************");
                System.out.println("¿Qué desea hacer?:");
                System.out.println("1) Registrar un pago.");
                System.out.println("2) Generar un reporte de pagos.");
                System.out.println("3) Volver al menú principal.");
                System.out.print("Ingrese la opción seleccionada: ");
                opcion = leer.nextInt();
                leer.nextLine(); // Consumir el salto de línea después de leer el número
   
                switch (opcion) {
                    case 1:
                        registrarPagoDesdeMenu();
                        break;
                    case 2:
                        generarReporte();
                        break;
                    case 3:
                        System.out.println("Volviendo al menú principal.");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, ingrese una de las opciones disponibles.");
                }
            } while (opcion != 3); // Continuar mientras la opción no sea volver al menú principal
        }
    }
    
    private void registrarPagoDesdeMenu() {
        try (Scanner leer = new Scanner(System.in)) {
            System.out.print("Ingrese el monto del pago: ");
            double monto = leer.nextDouble();
            leer.nextLine(); // Consumir el salto de línea después de leer el número
    
            System.out.println("\nIngrese el DNI del cliente: ");
            int dni = leer.nextInt();
            leer.nextLine(); // Consumir el salto de línea después de leer el número
            System.out.println("Ingrese el Nombre y Apellido del cliente: ");
            String nombre = leer.nextLine();
            System.out.println("Ingrese el Teléfono del cliente: ");
            String tel = leer.nextLine();
            System.out.println("Ingrese el Email del cliente: ");
            String correo = leer.nextLine();
    
            validarDatosCliente(dni, nombre, tel, correo);
            Cliente cliente = new Cliente(dni, nombre, tel, correo);
    
            registrarPago(cliente, monto);
    
            System.out.println("\n¡¡¡PAGO REGISTRADO CON ÉXITO!!!\n");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private static void validarDatosCliente(int dni, String nombreCompleto, String telefono, String email) {
        if (dni <= 0) {
            throw new IllegalArgumentException("El DNI debe ser un número positivo.");
        }
        if (nombreCompleto == null || nombreCompleto.isEmpty()) {
            throw new IllegalArgumentException("Debe indicar el nombre completo del cliente.");
        }
        if (telefono == null || telefono.isEmpty()) {
            throw new IllegalArgumentException("Debe indicar el teléfono del cliente.");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Debe indicar el email del cliente.");
        }
    }
}

