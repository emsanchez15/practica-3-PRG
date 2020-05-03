package es.upm.dit.prog.practica3;

public class WiFi {
  // TODO
	private String nombre;
	private Seguridad seguridad;

	WiFi (String _nombre, Seguridad _seguridad)
		{ 	nombre= _nombre; 
			seguridad= _seguridad;}
	String getNombre() {return nombre;}
	Seguridad getSeguridad() {return seguridad;}
	void setNombre(String nombre) {
		this.nombre = nombre;
	}
	void setSeguridad(Seguridad s) {
		this.seguridad = s;
	}
	@Override
	public String toString() {
		return "WiFi [nombre=" + nombre + ", seguridad=" + seguridad + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((seguridad == null) ? 0 : seguridad.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WiFi other = (WiFi) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (seguridad != other.seguridad)
			return false;
		return true;
	}
	
}
