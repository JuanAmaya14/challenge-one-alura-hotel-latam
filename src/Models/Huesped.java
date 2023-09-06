package Models;

import java.util.Date;

public class Huesped {

	private long id;
	private String nombre;
	private String apellido;
	private Date fechaDeNacimiento;
	private String nacionalidad;
	private String telefono;
	private long idReserva;

	public Huesped() {
	}

	public Huesped(long id, String nombre, String apellido, Date fechaDeNacimiento2, String nacionalidad,
			String telefono, long idReserva) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento2;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.idReserva = idReserva;
	}

	public Huesped(long id) {
		this.id = id;
	}

	public Huesped(String nombre, String apellido, Date fechaDeNacimiento, String nacionalidad, String telefono,
			long idReserva) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.idReserva = idReserva;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public long getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(long idReserva) {
		this.idReserva = idReserva;
	}

	@Override
	public String toString() {
		return "Huesped [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaDeNacimiento="
				+ fechaDeNacimiento + ", nacionalidad=" + nacionalidad + ", telefono=" + telefono + ", idReserva="
				+ idReserva + "]";
	}

}
