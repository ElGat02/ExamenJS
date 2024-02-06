package ec.edu.ups.ppw63.ExamenJS.model;

import java.util.Date;

public class RecargaMovilDTO {
    private String numeroMovil;
    private String operador;  // Nuevo campo para el operador
    private double monto;
    private int clienteId;
    private Date fecha;

    // Constructor, getters y setters

    public String getNumeroMovil() {
        return numeroMovil;
    }

    public void setNumeroMovil(String numeroMovil) {
        this.numeroMovil = numeroMovil;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public void setFechaEmision(Date fecha) {
		this.fecha = fecha;
	}
}
