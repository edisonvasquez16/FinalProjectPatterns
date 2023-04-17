package mundo.invaders;

public class PulpoCreator extends InvasorCreator {
    
    @Override
    public Enemigo createInvasor(double velocidad, int posX, int posY, int vida, int ancho, int alto, int direccion, String rutaImage, String ruta) {
        return new InvasorPulpo(velocidad, posX, posY, vida, ancho, alto, direccion, rutaImage, ruta);
    }
}
