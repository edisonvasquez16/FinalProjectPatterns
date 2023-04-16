package mundo.iterator;
import mundo.Partida;

public class PartidasCollection implements IterableCollection {
    
    public Partida izquierda;
    public Partida derecha;
    public Partida centro;
    private String nombre;


    public Partida getPartida(){
        return centro;
    }

    public void setPartida(Partida partida){
        this.centro = partida;
    }
    /**
	 * 
	 * @return
	 */
	public Partida getPartidaIzquierda() {
		return izquierda;
	}

	/**
	 * 
	 * @param partidaIzquierda
	 */
	public void setPartidaIzquierda(Partida partidaIzquierda) {
		this.izquierda = partidaIzquierda;
	}

	/**
	 * 
	 * @return
	 */
	public Partida getPartidaDerecha() {
		return derecha;
	}

	/**
	 * 
	 * @param partidaDerecha
	 */
	public void setPartidaDerecha(Partida partidaDerecha) {
		this.derecha = partidaDerecha;
	}

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

    public Iterator createPartidasIterator(){
        Iterator iterator = new PartidasIterator();
        return iterator;
    }
}
