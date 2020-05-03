package es.upm.dit.prog.practica3;

import java.util.Arrays;

public class Localizacion{
	
	private Coordenada c;
	private Lectura [] lecturas;
	
	
	public Localizacion(Coordenada c, int i) {
		this.c = c;
		this.lecturas = new Lectura[i];
		
	}
	
	@Override
	public String toString() {
		return "Localizacion [c=" + c + ", lecturas=" + Arrays.toString(lecturas) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((c == null) ? 0 : c.hashCode());
		result = prime * result + Arrays.hashCode(lecturas);
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
		Localizacion other = (Localizacion) obj;
		if (c == null) {
			if (other.c != null)
				return false;
		} else if (!c.equals(other.c))
			return false;
		if (!Arrays.equals(lecturas, other.lecturas))
			return false;
		return true;
	}

	public Coordenada getC() {
		return c;
	}

	public void setC(Coordenada c) {
		this.c = c;
	}
	
	public void setLectura (Lectura l, int n) {
		if (n >= 0 && n<= (lecturas.length -1)) {
			lecturas [n] = l;
		}
	}
	
	public Lectura getLectura(int n) {
		if (n >= 0 && n <= (lecturas.length -1))	{
			return lecturas [n] ;
		}
		return null;
	}

	public void intercambia (int n1, int n2) {
		if (n1>=0 && n1 <= (lecturas.length-1))				
			if (n2>=0 && n2 <= (lecturas.length-1)) {
				Lectura aux = lecturas [n2];
				lecturas [n2] = lecturas [n1];
				lecturas [n1] = aux;
			}
	}
	
	public boolean addLectura(Lectura l){
		if(l!= null) {
			for (int i=0; i< lecturas.length; i++) {
				if (lecturas[i] == null) {
					lecturas[i] = l;
					return true;
					}
			}
		}
		return false;	
	}
	
	private int getPosicionLectura(WiFi w) {
		for (int i=0; i<lecturas.length; i++){
			if (lecturas[i] != null && w.equals(lecturas[i].getRed())) {
				return i;
			}
		}
		return -1;
	}
	
	Lectura getLectura(WiFi w) {
		if (w!=null) {
			int position = this.getPosicionLectura(w);
			if (position !=-1)
				return this.lecturas[position];
		}
		return null;
	}
	
	//[null, 1, 13,52, null]
	
	Lectura masPotente() {
		if (lecturas.length > 0){		
			int m=0;
			boolean not_null = false;
			double maximo = 0;
			
			for (int i=0; i<lecturas.length; i++) {
				if (lecturas[i]!=null) {
					
					if (!not_null) {
						maximo = lecturas[i].getPotencia();
						m=i;
						not_null = true;
					}
								
					if (lecturas[i].getPotencia() > maximo) {
						maximo = lecturas[i].getPotencia();
						m=i;
					}	
				}
			}
			if (not_null)
				return lecturas[m];
		}
		return null;
	}
	
	Lectura [] copiaDeLecturas() {
		int n=0;
		for(int i=0; i<lecturas.length;i++) {
			if(lecturas[i] != null) {
				n++;
			}
		}
		if (n==0) {
			return new Lectura[0];}
		Lectura[] lec2 = new Lectura [n];
		int o=0;
		for(int i=0; i<lecturas.length && i<lec2.length; i++) {
			if(lecturas[i] != null) {
				lec2[o] = lecturas[i];
				o++;
			}
		}return lec2;
		
	}
	void borraLectura(WiFi w) {
		for (int i = getPosicionLectura(w); i<lecturas.length-1; i++) {
			lecturas[i]= lecturas[i+1];
		}
		lecturas[lecturas.length-1]=null;
	}
}



	
	

