package hilos;

import interfaz.InterfazSpaceInvaders;
import mundo.invaders.Enemigo;

public class ThreadsEnemy extends Threads {

	InterfazSpaceInvaders interfaz;
	Enemigo enemigo;

	public ThreadsEnemy(Enemigo invasores) {
		// TODO Auto-generated constructor stub

		enemigo = invasores;
		this.interfaz = InterfazSpaceInvaders.getInstance();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (interfaz.estaEnFuncionamiento()) {

			if (enemigo.getDireccion() == Enemigo.DERECHA) {
				enemigo.mover(1);
			} else {
				enemigo.mover(-1);
			}
			
			if (enemigo.edge()) {
				enemigo.moverAbajo(2);
				if (enemigo.getDireccion() == Enemigo.DERECHA) {
					enemigo.setDireccion(Enemigo.IZQUIERDA);
				} else {
					enemigo.setDireccion(Enemigo.DERECHA);
				}
			}

			try {
				sleep(80);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			interfaz.getPanelNivel().updateUI();

			if (enemigo.getDisparoUno() != null) {
				if (enemigo.getDisparoUno().getPosY() >= 420) {
					enemigo.getDisparoUno().setImpacto(true);
					enemigo.eliminarDisparo();
				}
			}

		}

	}

}