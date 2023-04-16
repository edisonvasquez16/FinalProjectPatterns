package mundo.iterator;
import mundo.Partida;
import excepciones.*;
public class PartidasIterator implements Iterator {

    public PartidasCollection partidas;

    public void agregarPartida(Partida partida) throws PartidaYaExisteException {
        if (partidas.getPartida().getNombre().compareToIgnoreCase(partida.getNombre()) == 0) {
			throw new PartidaYaExisteException(partida.getNombre());
		} else if (partidas.getPartida().getNombre().compareToIgnoreCase(partida.getNombre()) > 0) {

			if (partidas.getPartidaIzquierda() == null) {
				partidas.setPartidaIzquierda(partida);
			} else {
				partidas.getPartidaIzquierda().partidas.createPartidasIterator().agregarPartida(partida);;
			}

		} else {

			if (partidas.getPartidaDerecha() == null) {
				partidas.setPartidaDerecha(partida);
			} else {
				partidas.getPartidaDerecha().partidas.createPartidasIterator().agregarPartida(partida);
			}

		}
    }

    public Partida buscarPartida(String partida){
        Partida aBuscar = null;

		if (partidas != null) {
			if (partidas.getPartida().getNombre().equals(partida)) {
				aBuscar = partidas.getPartida();
			} else {

				if (partidas.getPartida().getNombre().compareToIgnoreCase(partida) > 0) {
					if(partidas.getPartidaIzquierda() != null)
					aBuscar = partidas.getPartidaIzquierda().partidas.createPartidasIterator().buscarPartida(partida);
				} else if (partidas.getPartida().getNombre().compareToIgnoreCase(partida) < 0) {
					if(partidas.getPartidaDerecha() != null)
					aBuscar = partidas.getPartidaDerecha().partidas.createPartidasIterator().buscarPartida(partida);
				}

			}
		}

		return aBuscar;
    }
    
}
