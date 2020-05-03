package es.upm.dit.prog.practica3;

public class Lectura {
  // TODO	
	private WiFi red;
	private double potencia;
	Lectura (WiFi _red, double _potencia)
	{ 	red= _red; 
		potencia= _potencia;}
WiFi getRed() {return red;}
double getPotencia() {return potencia;}
void setRed(WiFi red) {
	this.red = red;
}
void setPotencia(double potencia) {
	this.potencia = potencia;
}
@Override
public String toString() {
	return "Lectura [red=" + red + ", potencia=" + potencia + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	long temp;
	temp = Double.doubleToLongBits(potencia);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + ((red == null) ? 0 : red.hashCode());
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
	Lectura other = (Lectura) obj;
	if (Double.doubleToLongBits(potencia) != Double.doubleToLongBits(other.potencia))
		return false;
	if (red == null) {
		if (other.red != null)
			return false;
	} else if (!red.equals(other.red))
		return false;
	return true;
}
}
