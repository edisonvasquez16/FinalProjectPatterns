package mundo;

import excepciones.PartidaYaExisteException;
import mundo.iterator.PartidasCollection;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * 
 * @author Manuel Alejandro Coral Lozano - Juan Sebasti�n Quintero Yoshioka
 *         Proyecto final - Algoritmos y programaci�n II.
 */
public class Partida implements Serializable {

	// -----------------------------------------------------------------
	// ---------------------------Asociaciones--------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 */
	//private Partida partidaIzquierda;

	/**
	 * 
	 */
	//private Partida partidaDerecha;

	public PartidasCollection partidas;
	/**
	 * 
	 */
	private Enemigo[][] enemigos;

	/**
	 * 
	 */
	private Puntaje puntaje;

	/**
	 * 
	 */
	private Nivel nivel;

	// -----------------------------------------------------------------
	// ----------------------------Atributos----------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 */
	private String nombre;

	// -----------------------------------------------------------------
	// ---------------------------Constructor---------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 * @param nombre
	 */
	public Partida(String nombre) {
		this.nombre = nombre;
		nivel = new Nivel("1", 0, 0, 0, 0, 0, 0, 0);
		partidas = new PartidasCollection();
		//		inicializarEnemigos();
	}

	// -----------------------------------------------------------------
	// -----------------------------M�todos-----------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 * @return
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return
	 */
	/**public Partida getPartidaIzquierda() {
		return partidaIzquierda;
	}**/

	/**
	 * 
	 * @param partidaIzquierda
	 */
	/**public void setPartidaIzquierda(Partida partidaIzquierda) {
		this.partidaIzquierda = partidaIzquierda;
	}**/

	/**
	 * 
	 * @return
	 */
	/**public Partida getPartidaDerecha() {
		return partidaDerecha;
	}**/

	/**
	 * 
	 * @param partidaDerecha
	 */
	/**public void setPartidaDerecha(Partida partidaDerecha) {
		this.partidaDerecha = partidaDerecha;
	}*/

	public Enemigo[][] getEnemigos() {
		return enemigos;
	}

	public void setEnemigos(Enemigo[][] enemigos) {
		this.enemigos = enemigos;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	/**
	 * 
	 * @return
	 */
	public Puntaje getPuntaje() {
		return puntaje;
	}

	/**
	 * 
	 * @param puntaje
	 */
	public void setPuntaje(Puntaje puntaje) {
		this.puntaje = puntaje;
	}

	/**public void agregarPartida(Partida nodo) throws PartidaYaExisteException {

		if (this.nombre.compareToIgnoreCase(nodo.nombre) == 0) {
			throw new PartidaYaExisteException(nodo.nombre);
		} else if (this.nombre.compareToIgnoreCase(nodo.nombre) > 0) {

			if (partidaIzquierda == null) {
				setPartidaIzquierda(nodo);
			} else {
				partidaIzquierda.agregarPartida(nodo);
			}

		} else {

			if (partidaDerecha == null) {
				setPartidaDerecha(nodo);
			} else {
				partidaDerecha.agregarPartida(nodo);
			}

		}

	}*/

	/**public Partida buscarPartida(String nombre) {

		Partida aBuscar = null;

		if (this != null) {
			if (this.getNombre().equals(nombre)) {
				aBuscar = this;
			} else {

				if (this.getNombre().compareToIgnoreCase(nombre) > 0) {
					if(this.getPartidaIzquierda() != null)
					aBuscar = this.getPartidaIzquierda().buscarPartida(nombre);
				} else if (this.getNombre().compareToIgnoreCase(nombre) < 0) {
					if(this.getPartidaDerecha() != null)
					aBuscar = this.getPartidaDerecha().buscarPartida(nombre);
				}

			}
		}

		return aBuscar;
	}*/

	/**
	 * @throws IOException
	 * 
	 */
	public void inicializarPartida() throws IOException {
		partidas.setPartida(this);
		File archivo = new File("");

		if (nivel.getNivel().equals("1")) {
			archivo = new File("./data/nivel1.txt");
		} else if (nivel.getNivel().equals("2")) {
			archivo = new File("./data/nivel2.txt");
		}

		FileReader fr = new FileReader(archivo);
		BufferedReader br = new BufferedReader(fr);

		int cantEnemigos = 0;

		String linea = br.readLine();

		linea = br.readLine();

		String nivelActual = linea;

		linea = br.readLine();
		linea = br.readLine();
		int filas = Integer.parseInt(linea);
		linea = br.readLine();
		linea = br.readLine();
		int colums = Integer.parseInt(linea);

		enemigos = new Enemigo[filas][colums];

		linea = br.readLine();
		linea = br.readLine();

		int vidaEnemigo = Integer.parseInt(linea);

		linea = br.readLine();
		linea = br.readLine();

		cantEnemigos = Integer.parseInt(linea);

		linea = br.readLine();
		linea = br.readLine();

		int velocidad = Integer.parseInt(linea);

		linea = br.readLine();
		linea = br.readLine();
		String[] arreglo = linea.split("\t");

		this.nivel = new Nivel(nivelActual, velocidad, cantEnemigos,
				vidaEnemigo, Integer.parseInt(arreglo[0]), Integer.parseInt(arreglo[1]),
				Integer.parseInt(arreglo[2]), Integer.parseInt(arreglo[3]));

		inicializarEnemigos();

		br.close();
		fr.close();
	}

	public void inicializarEnemigos() {
		InvasorCreator invasor;
		for (int i = 0; i < enemigos.length; i++) {
			for (int j = 0; j < enemigos[i].length; j++) {

				if (i == 0) {
					invasor = new CalamarCreator(); 
					enemigos[i][j] = invasor.createInvasor(nivel.getVelocidadEnemigos(), (j * nivel.getPosXPrimerEnemigo() + nivel.getPosXPrimerEnemigo())
					, nivel.getPosYPrimerEnemigo(), nivel.getVidaEnemigos(), nivel.getAnchoEnemigos(), nivel.getAltoEnemigos(),
					Enemigo.DERECHA, "./data/imagenes/Naves/s0.png", "./data/imagenes/Naves/s1.png");
				} else if (i == 1 || i == 2) {
					invasor = new CangrejoCreator(); 
					enemigos[i][j] = invasor.createInvasor(nivel.getVelocidadEnemigos(), (j * nivel.getPosXPrimerEnemigo() + nivel.getPosXPrimerEnemigo()),
							(i *  nivel.getPosYPrimerEnemigo() +  nivel.getPosYPrimerEnemigo()), nivel.getVidaEnemigos(), nivel.getAnchoEnemigos(), nivel.getAltoEnemigos(),
							Enemigo.DERECHA, "./data/imagenes/Naves/p0.png", "./data/imagenes/Naves/p1.png");

				} else if (i == 3 || i == 4) {
					invasor = new PulpoCreator(); 
					enemigos[i][j] = invasor.createInvasor(nivel.getVelocidadEnemigos(), (j * nivel.getPosXPrimerEnemigo() + nivel.getPosXPrimerEnemigo()),
							(i * nivel.getPosYPrimerEnemigo() + nivel.getPosYPrimerEnemigo()), nivel.getVidaEnemigos(), nivel.getAnchoEnemigos(), nivel.getAltoEnemigos(),
							Enemigo.DERECHA, "./data/imagenes/Naves/r0.png", "./data/imagenes/Naves/r1.png");
				}
			}
		}

	}

	/**
	 * 
	 * @param elimino
	 * @param a
	 */
	public void eliminarUnEnemigo(boolean elimino, Enemigo a) {
		boolean salida = false;
		if (elimino) {

			for (int i = 0; i < enemigos.length && !salida; i++) {
				for (int j = 0; j < enemigos[0].length && !salida; j++) {

					if (enemigos[i][j] != null) {
						if (enemigos[i][j].equals(a)) {
							enemigos[i][j] = null;
							salida = true;
						}
					}
				}
			}
		}

	}


	/**
	 * 
	 */
	public boolean terminarNivel() {

		int contador = 0;

		for (int i = 0; i < enemigos.length; i++) {
			for (int j = 0; j < enemigos[i].length; j++) {

				if (enemigos[i][j] == null) {
					contador++;
				}
			}
		}

		return (contador == (enemigos.length*enemigos[0].length));
	}

	/**
	 * @throws IOException 
	 * 
	 */
	public boolean nivelCompleto() throws IOException {

		if (nivel.getNivel().equals("1")) {
			nivel.setNivel("2");
			inicializarPartida();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return nombre;
	}

	public void inorden(ArrayList<Partida> acumulado) {
		if (partidas.getPartidaIzquierda() != null)
			partidas.getPartidaIzquierda().partidas.getPartida().inorden(acumulado);
		acumulado.add(this);
		if (partidas.getPartidaDerecha() != null)
			partidas.getPartidaDerecha().partidas.getPartida().inorden(acumulado);
	}

	public Partida eliminar( String nombre ) {
		if (esHoja()) {
			return null;
		}

		if (this.nombre.compareToIgnoreCase(nombre) == 0) {
			if (partidas.getPartidaIzquierda() == null) {
				return partidas.getPartidaDerecha();
			}

			if (partidas.getPartidaDerecha() == null) {
				return partidas.getPartidaIzquierda();
			}


			Partida sucesor = partidas.getPartidaDerecha().partidas.getPartida().darMenor();

			partidas.getPartidaDerecha().partidas.setPartidaDerecha(partidas.getPartidaDerecha().eliminar(sucesor.getNombre()));

			sucesor.partidas.setPartidaIzquierda(partidas.getPartidaIzquierda());
			sucesor.partidas.setPartidaDerecha(partidas.getPartidaDerecha());

			return sucesor;
		} else if (this.nombre.compareToIgnoreCase(nombre) > 0) {
			partidas.setPartidaIzquierda(partidas.getPartidaIzquierda().eliminar(nombre));
		} else {
			partidas.setPartidaDerecha(partidas.getPartidaDerecha().eliminar(nombre));
		}

		return this;
	}


	public Partida darMenor( ) {
		return (partidas.getPartidaIzquierda() == null) ? this : partidas.getPartidaIzquierda().darMenor();
	}

	public boolean esHoja(){
		return (partidas.getPartidaIzquierda() == null && partidas.getPartidaDerecha() == null);
	}

}