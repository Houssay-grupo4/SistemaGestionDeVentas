import java.util.Scanner;

public class Cobros {

    public Cobros() {
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú de Cobros:");
            System.out.println("1. Consultar saldo de Cliente");
            System.out.println("2. Gestionar Cobro");
            System.out.println("3. Emitir Comprobante");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    consultarSaldo();
                    break;
                case 2:
                    gestionarCobro();
                    break;
                case 3:
                    emitirComprobante();
                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
                    break;
            }
        } while (opcion != 4);

        scanner.close();
    }

    public void consultarSaldo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Has seleccionado la opción de consultar saldo.");
        System.out.print("Ingresa el nombre o ID del cliente: ");
        String cliente = scanner.nextLine();
        // Aquí puedes agregar la lógica para consultar el saldo del cliente usando el nombre o ID ingresado.
    }

    public void gestionarCobro() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("Has seleccionado la opción de gestionar un cobro.");
        do {
            System.out.println("Opciones de Gestión de Cobro:");
            System.out.println("1. Contactar telefónicamente");
            System.out.println("2. Enviar correo electrónico");
            System.out.println("3. Enviar gestión a legales");
            System.out.println("4. Volver al menú principal");
            System.out.print("Selecciona una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Has seleccionado Contactar telefónicamente.");
                    // Aquí puedes agregar la lógica para contactar telefónicamente.
                    break;
                case 2:
                    System.out.println("Has seleccionado Enviar correo electrónico.");
                    // Aquí puedes agregar la lógica para enviar un correo electrónico.
                    break;
                case 3:
                    System.out.println("Has seleccionado Enviar gestión a legales.");
                    // Aquí puedes agregar la lógica para enviar la gestión a legales.
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
                    break;
            }
        } while (opcion != 4);
    }

    public void emitirComprobante() {

        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("Has seleccionado la opción de emitir un comprobante.");
        do {
            System.out.println("Opciones para Emitir Comprobante:");
            System.out.println("1. Imprimir factura");
            System.out.println("2. Imprimir nota de crédito");
            System.out.println("3. Volver al menú principal");
            System.out.print("Selecciona una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Has seleccionado Imprimir factura.");
                    // Aquí puedes agregar la lógica para imprimir una factura.
                    break;
                case 2:
                    System.out.println("Has seleccionado Imprimir nota de crédito.");
                    // Aquí puedes agregar la lógica para imprimir una nota de crédito.
                    break;
                case 3:
                    System.out.println("Volviendo al menú principal.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
                    break;
            }
        } while (opcion != 3);
    }


} 