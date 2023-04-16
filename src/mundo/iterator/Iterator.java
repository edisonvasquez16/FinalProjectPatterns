package mundo.iterator;

import excepciones.PartidaYaExisteException;
import mundo.Partida;

public interface Iterator {
    public void agregarPartida(Partida partida) throws PartidaYaExisteException;

    public Partida buscarPartida(String partida);
}
