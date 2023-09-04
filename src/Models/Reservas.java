package Models;

import java.util.Date;

public class Reservas {
	
	private long id;
	private Date fechaEntrada;
	private Date fechaSalida;
	private double valor;
	private String formaPago;
	
	public Reservas() {}
	
	public Reservas(long id, Date fechaEntrada, Date fechaSalida, double valor, String formaPago) {
		this.id = id;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaPago = formaPago;
	}
	
	public Reservas(Date fechaEntrada, Date fechaSalida, double valor, String formaPago) {
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaPago = formaPago;
	}
	
	public Reservas(long id) {
		this.id = id;
	}
	
	
	

}
