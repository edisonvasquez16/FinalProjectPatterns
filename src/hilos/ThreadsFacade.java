package hilos;

import interfaz.InterfazSpaceInvaders;
import mundo.SpaceInvaders;

public class ThreadsFacade {

    private Threads thread;
    private InterfazSpaceInvaders interfaz;
    private SpaceInvaders mundo;

    public ThreadsFacade(InterfazSpaceInvaders interfazSpaceInvaders, SpaceInvaders mundo) {
        this.interfaz = interfazSpaceInvaders;
        this.mundo = mundo;
    }

    private void startEnemyThread() {
        for (int i = 0; i < mundo.getPartidaActual().getEnemigos().length; i++) {
            for (int j = 0; j < mundo.getPartidaActual().getEnemigos()[0].length; j++) {
                if (mundo.getPartidaActual().getEnemigos()[i][j] != null) {
                    thread = new ThreadsEnemy(mundo.getPartidaActual().getEnemigos()[i][j], interfaz);
                    thread.start();
                }
            }
        }
    }

    private void startAuxShootThread() {
        thread = new ThreadAuxShootCreate(mundo.getPartidaActual(), interfaz);
        thread.start();
    }

    private void startAnimationEnemyThread() {
        for (int i = 0; i < mundo.getPartidaActual().getEnemigos().length; i++) {
            for (int j = 0; j < mundo.getPartidaActual().getEnemigos()[0].length; j++) {
                if (mundo.getPartidaActual().getEnemigos()[i][j] != null) {
                    thread = new ThreadEnemyAnimation(mundo.getPartidaActual().getEnemigos()[i][j], interfaz);
                    thread.start();
                }
            }
        }
    }

    private void startShootEnemyThread() {
        thread = new ThreadEnemyShoot(mundo.getPartidaActual(), interfaz, mundo);
        thread.start();
    }

    public void startShootPlayerThread() {
        thread = new ThreadPlayerShoot(mundo.getJugadorActual(), interfaz, mundo.getPartidaActual().getEnemigos(), mundo.getPartidaActual());
        thread.start();
    }

    public void startThreads() {
        startEnemyThread();
        startAnimationEnemyThread();
        startAuxShootThread();
        startShootEnemyThread();
    }

    public void stopThreads() {
        thread = null;
    }

}
