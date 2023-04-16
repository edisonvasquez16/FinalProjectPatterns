package mundo.partida;

import java.io.Serializable;

public class PartidasCollection implements IterableCollection, Serializable {
    
    private Partida izquierda;
    private Partida derecha;
    private Partida centro;

    public PartidasCollection (Partida partida){
        this.centro = partida;
    }

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

    public Iterator createPartidasIterator(){
        Iterator iterator = new PartidasIterator();

        return iterator;
    }
}
