package mundo.partida;

import excepciones.PartidaYaExisteException;

public interface Iterator {
    public void agregarPartida(Partida partida) throws PartidaYaExisteException;

    public Partida buscarPartida(String partida);
}
