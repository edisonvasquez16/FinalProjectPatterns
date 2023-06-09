package hilos;

import interfaz.InterfazSpaceInvaders;
import mundo.invaders.Enemigo;
import mundo.NaveJugador;
import mundo.partida.Partida;

public class ThreadPlayerShoot extends Threads {

	private NaveJugador navesita;
	private InterfazSpaceInvaders interfaz;
	private Enemigo[][] enemigos;
	private Partida actual;

	public ThreadPlayerShoot(NaveJugador a, Enemigo[][] c, Partida d) {
		// TODO Auto-generated constructor stub

		navesita = a;
		interfaz = InterfazSpaceInvaders.getInstance();;
		enemigos = c;
		actual = d;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (navesita.getDisparoUno() != null && !navesita.getDisparoUno().getImpacto()) {

			navesita.getDisparoUno().shoot();

			for (int i = 0; i < enemigos.length && navesita.getDisparoUno() != null
					&& !navesita.getDisparoUno().getImpacto(); i++) {
				for (int j = 0; j < enemigos[0].length && navesita.getDisparoUno() != null
						&& !navesita.getDisparoUno().getImpacto(); j++) {
					if (navesita.getDisparoUno().hitsEnemigo(enemigos[i][j])) {
						navesita.getDisparoUno().setImpacto(true);
						actual.getPuntaje().setPuntuacion(enemigos[i][j].getPuntosPorMuerte());
						actual.eliminarUnEnemigo(true, enemigos[i][j]);
						
						navesita.eliminarDisparo();
						interfaz.getPanelNivel().repaint();
					}
				}
			}

			try {
				sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			interfaz.getPanelNivel().updateUI();

			if (navesita.getDisparoUno() != null) {
				if (navesita.getDisparoUno().getPosY() <= 0) {
					navesita.getDisparoUno().setImpacto(true);
					navesita.eliminarDisparo();
				}
			}
		}

	}

}
