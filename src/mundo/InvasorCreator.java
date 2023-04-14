package mundo;

public abstract class InvasorCreator {
    
    public abstract Enemigo createInvasor(double velocidad, int posX, int posY, int vida, int ancho, int alto, int direccion, String rutaImage, String ruta);

}
