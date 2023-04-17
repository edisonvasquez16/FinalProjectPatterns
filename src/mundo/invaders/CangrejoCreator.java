package mundo.invaders;

public class CangrejoCreator extends InvasorCreator {

    @Override
    public Enemigo createInvasor(double velocidad, int posX, int posY, int vida, int ancho, int alto, int direccion, String rutaImage, String ruta) {
        return new InvasorCangrejo(velocidad, posX, posY, vida, ancho, alto, direccion, rutaImage, ruta);
    }
}

