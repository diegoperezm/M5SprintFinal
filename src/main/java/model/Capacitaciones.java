package model;

public class Capacitaciones {
	protected int id;
	protected String nombre;
	protected String detalle;

	public Capacitaciones() {
		super();
	}

	public Capacitaciones(int id, String nombre, String detalle) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.detalle = detalle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	@Override
	public String toString() {
		return "Capacitaciones [id=" + id + ", nombre=" + nombre + ", detalle=" + detalle + "]";
	}

}
