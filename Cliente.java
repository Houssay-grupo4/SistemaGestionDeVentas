package sistemagestionventascompras;

import java.util.Scanner;

public class Cliente {

    private int dni_cliente;
    private String nombreCompleto;
    private String telefono;
    private String email;

    public Cliente() {
    }

    public Cliente(int dni_cliente, String nombreCompleto, String telefono, String email) {
        this.dni_cliente = dni_cliente;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.email = email;
    }

    public int getDni_cliente() {
        return dni_cliente;
    }

    public void setDni_cliente(int dni_cliente) {
        this.dni_cliente = dni_cliente;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
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

    private void validarDatosCliente(int dni, String nombreCompleto, String telefono, String email) {
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

    public Cliente crearClienteNuevo() {
        Scanner leer = new Scanner(System.in);
        try {
            System.out.println("\nIngrese los siguientes datos del cliente:");
            System.out.print("DNI: ");
            int dni = leer.nextInt();
            leer.nextLine();
            System.out.print("Nombre y Apellido: ");
            String nombre = leer.nextLine();
            System.out.print("Teléfono: ");
            String tel = leer.nextLine();
            System.out.print("Email: ");
            String correo = leer.nextLine();

            validarDatosCliente(dni, nombre, tel, correo);
            Cliente cliente = new Cliente(dni, nombre, tel, correo);

            System.out.println("\n¡¡¡CLIENTE GUARDADO CON ÉXITO!!!");
            return cliente;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public String toString() {
        return "\nCliente{" + "dni_cliente = " + dni_cliente + ", nombreCompleto = " + nombreCompleto
                + ", telefono = " + telefono + ", email = " + email + '}';
    }

}
