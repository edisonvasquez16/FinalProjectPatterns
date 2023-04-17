package mundo;

import excepciones.PartidaYaExisteException;
import mundo.partida.Partida;

/**
 * 
 * @author Manuel Alejandro Coral Lozano - Juan Sebasti�n Quintero Yoshioka
 *         Proyecto final - Algoritmos y programaci�n II.
 */
public class NaveJugador extends Nave {

	// -----------------------------------------------------------------
	// ---------------------------Constantes----------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// -----------------------------------------------------------------
	// ----------------------------Atributos----------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 */
	private Partida partidaRaiz;

	/**
	 * 
	 */
	private int posInicialX;

	/**
	 * 
	 */
	private int posIncialY;
	
	/**
	 * 
	 */
	private String nickname;

	/**
	 * 
	 */
	private String nombre;

	/**
	 * 
	 */
	private int cantidadDisparos;

	// -----------------------------------------------------------------
	// ---------------------------Constructor---------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 * @param pNombre
	 * @param pDirectorio
	 */
	public NaveJugador(String nombre, String nickname) {
		super();
		partidaRaiz = null;
		this.posInicialX = 320;
		this.posIncialY = 410;
		this.setVida(3);
		this.nombre = nombre;
		this.nickname = nickname;
	}

	// -----------------------------------------------------------------
	// -----------------------------M�todos-----------------------------
	// -----------------------------------------------------------------

	/**
	 * 
	 * @param partidaNueva
	 * @throws PartidaYaExisteException
	 */
	public void agregarPartida(Partida partidaNueva) throws PartidaYaExisteException {

		if (partidaRaiz == null) {
			partidaRaiz = partidaNueva;
		} else {
			partidaRaiz.partidas.createPartidasIterator().agregarPartida(partidaNueva);
		}

	}

	/**
	 * 
	 * @param nombre
	 * @throws PartidaYaExisteException
	 */
	public Partida crearPartida(String nombre) throws PartidaYaExisteException {

		Partida partidaNueva = new Partida(nombre);
		agregarPartida(partidaNueva);

		return partidaNueva;

	}

	/**
	 * 
	 * @return
	 */
	public int getPosInicialX() {
		return this.posInicialX;
	}

	/**
	 * 
	 * @param posInicialX
	 */
	public void setPosInicialX(int posInicialX) {
		this.posInicialX = posInicialX;
	}

	/**
	 * 
	 * @return
	 */
	public int getPosIncialY() {
		return this.posIncialY;
	}

	/**
	 * 
	 * @param posIncialY
	 */
	public void setPosIncialY(int posIncialY) {
		this.posIncialY = posIncialY;
	}
	
	/**
	 * 
	 * @return
	 */
	public Partida getPartidaRaiz() {
		return partidaRaiz;
	}

	/**
	 * 
	 * @param partidaRaiz
	 */
	public void setPartidaRaiz(Partida partidaRaiz) {
		this.partidaRaiz = partidaRaiz;
	}

	/**
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
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
	public String getNickname() {
		return nickname;
	}

	/**
	 * 
	 * @param nickname
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getCantidadDisparos() {
		return cantidadDisparos;
	}

	public void setCantidadDisparos(int cantidadDisparos) {
		this.cantidadDisparos = cantidadDisparos;
	}

	public boolean perdio () {
		return getVida() == 0;
	}

	/**
	 * 
	 */
	public void iniciarPartida() {

	}

	@Override
	public void mover(int dir) {
		super.mover(dir);
		posInicialX += dir * 10.0d;
	}

	@Override
	public String toString() {
		return nickname;
	}

	public void disparar (int posX, int posY) {

		if (disparoUno == null) {
			cantidadDisparos++;
			disparoUno = new Disparo(posX, posY);
		}
	}

}