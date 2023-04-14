package mundo;

public class CalamarCreator extends InvasorCreator {
        
    @Override
    public Enemigo createInvasor(double velocidad, int posX, int posY, int vida, int ancho, int alto, int direccion, String rutaImage, String ruta){
        return new InvasorCalamar(velocidad, posX, posY, vida, ancho, alto, direccion, rutaImage, ruta);
    }
}