package sistemagestionventascompras;

import java.time.LocalDate;

public class Pago {
    private int id;
    private LocalDate fecha;
    private double monto;

    public Pago(int id, LocalDate localDate, double monto) {
        this.id = id;
        this.fecha = LocalDate.now(); 
        this.monto = monto;
    }

    public int getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public double getMonto() {
        return monto;
    }

    @Override
    public String toString() {
        return "\nPago{" + "id = " + id + ", fecha = " + fecha + ", monto = " + monto + '}';
    }
}

