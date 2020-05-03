package es.upm.dit.prog.practica3;

public class PruebaRegistro {
	public static void main(String[] args) {
		WiFi[] wifis = new WiFi[10];
		for (int i = 0; i < wifis.length; i++) {
			wifis[i] = new WiFi("WiFi" + i, Seguridad.ABIERTA);
		}

		Lectura[] lecturas = new Lectura[10];
		for (int i = 0; i < lecturas.length; i++) {
			lecturas[i] = new Lectura(wifis[i], i * 100);
		}

		Localizacion[] locs = new Localizacion[10];
		for (int i = 0; i < locs.length; i++) {
			locs[i] = new Localizacion(new Coordenada(i * 10, i * 10), lecturas.length);
			for (int j = 0; j < lecturas.length; j++) {
				locs[i].addLectura(lecturas[j]);
			}
		}
		
		Registro r = new Registro(10);
		System.out.println("New Registro=" + r);

		for (int i = 0; i < locs.length; i++){
			boolean anade= r.add(locs[i]);
			System.out.println("add " + i  + "=" + anade);				
		}
		System.out.println("add 10 locs=" + r);
		r.add(locs[0]);
		System.out.println("add 11 locs=" + r);

		System.out.println("r.getLocalizacion(0)=" + r.getLocalizacion(0));
		System.out.println("r.getLocalizacion(9)=" + r.getLocalizacion(9));

		Localizacion [] locs2 = r.getLocalizacionesCercanas(new Coordenada(0, 0), 0);
		System.out.println("getLocalizacionesCercanas (0,0), 0=");
		for (int i = 0; i < locs2.length; i++)
			System.out.println(locs2[i]);

		locs2 = r.getLocalizacionesCercanas(new Coordenada(0, 0), 100);
		System.out.println("getLocalizacionesCercanas (0,0), 100=");
		for (int i = 0; i < locs2.length; i++)
			System.out.println(locs2[i]);

		locs2 = r.getLocalizacionesCercanas(new Coordenada(0, 0), 1000000);
		System.out.println("getLocalizacionesCercanas (0,0), 1000000=");
		for (int i = 0; i < locs2.length; i++)
			System.out.println(locs2[i]);

	}
}
