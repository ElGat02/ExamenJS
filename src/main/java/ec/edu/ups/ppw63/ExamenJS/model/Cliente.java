package ec.edu.ups.ppw63.ExamenJS.model;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity //Define una clase como una entidad JPA
public class Cliente {
@Id //esto es clave primaria
	private int codigo ;
	private String dni;
	private String nombre;
	private String direccion;
	 private double saldo;
	

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	 public double getSaldo() {
	        return saldo;
	    }

	    public void setSaldo(double saldo) {
	        this.saldo = saldo;
	    }

}
