package interfaz.panels;

import interfaz.InterfazSpaceInvaders;
import mundo.Disparo;
import mundo.NaveJugador;
import mundo.partida.Partida;
import mundo.SpaceInvaders;

import javax.swing.*;
import java.awt.*;

public class PanelNivel extends JPanel {

    private Partida partida;
    private SpaceInvaders space;
    private InterfazSpaceInvaders interfaz;

    private int posJugadorActualX;
    private int posJugadorActualY;

    public PanelNivel(Partida actual, SpaceInvaders mundo) {
        partida = actual;
        space = mundo;
        interfaz = InterfazSpaceInvaders.getInstance();
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        ImageIcon iconFondo = new ImageIcon("./data/imagenes/fondoJuego.jpg");

        g.drawImage(iconFondo.getImage(), 0, 0, null);

        ImageIcon imagen = new ImageIcon("./data/imagenes/Naves/nave.png");

        g.drawImage(imagen.getImage(), ((NaveJugador) space.getJugadorActual()).getPosInicialX(),
                ((NaveJugador) space.getJugadorActual()).getPosIncialY(), imagen.getIconWidth(), imagen.getIconHeight(),
                null);

        posJugadorActualX = (int) ((NaveJugador) space.getJugadorActual()).getPosInicialX();
        posJugadorActualY = (int) ((NaveJugador) space.getJugadorActual()).getPosIncialY();


        //DIBUJAR INFORMACI�N DEL JUGADOR
        g.setColor(Color.WHITE);
        g.setFont(new Font("ArcadeClassic", Font.PLAIN, 20));
        g.drawString("NICKNAME", 30, 40);
        g.drawString("PUNTUACION ", 250, 40);

        g.setColor(Color.CYAN);
        g.drawString(interfaz.getJugadorActual().getNickname(), 160, 40);
        g.drawString(String.valueOf(partida.getPuntaje().getPuntuacion()), 420, 40);

        // DISPARO DE LA NAVE
        Disparo a = (Disparo) space.getJugadorActual().getDisparoUno();

        if (a != null) {
            g.setColor(Color.WHITE);
            g.fillOval(a.getPosX() + 13, a.getPosY(), 7, 7);

            if (a.getPosY() == 0 || a.getImpacto()) {
                ImageIcon choque = new ImageIcon("./data/imagenes/Naves/muereBicho.png");
                g.drawImage(choque.getImage(), a.getPosX(), a.getPosY() - 6, null);
            }

        }

        // DISPARO ENEMIGO

        for (int i = 0; i < partida.getEnemigos().length; i++) {
            for (int j = 0; j < partida.getEnemigos()[i].length; j++) {
                if (partida.getEnemigos()[i][j] != null) {
                    if (partida.getEnemigos()[i][j].getDisparoUno() != null) {
                        Disparo b = (Disparo) partida.getEnemigos()[i][j].getDisparoUno();

                        if (b != null) {
                            g.setColor(Color.RED);
                            g.fillOval(b.getPosX(), b.getPosY(), 7, 7);
                        }
                    }
                }
            }
        }

        // DIBUJAR ENEMIGOS

        for (int i = 0; i < partida.getEnemigos().length; i++) {
            for (int j = 0; j < partida.getEnemigos()[i].length; j++) {
                if (partida.getEnemigos()[i][j] != null) {
                    if (partida.getEnemigos()[i][j] != null) {
                        ImageIcon icono = new ImageIcon(partida.getEnemigos()[i][j].getRutaImage());
                        g.drawImage(icono.getImage(), partida.getEnemigos()[i][j].getPosX(),
                                partida.getEnemigos()[i][j].getPosY(), null);
                    }
                }
            }
        }

        if (space.getEnFuncionamiento() && space.getPartidaActual().terminarNivel()) {
            space.setEnFuncionamiento(false);
            interfaz.getThreadsFacade().stopThreads();

            int bonificacion = (space.puntosPorVida() - space.puntosPorDisparos());

            if (bonificacion > 0) {
                space.getPartidaActual().getPuntaje().setPuntuacion(bonificacion);
            }

            interfaz.nivelCompleto();
        }


        // PERDI�
        if (space.getJugadorActual().perdio()) {
            space.setEnFuncionamiento(false);
            interfaz.getThreadsFacade().stopThreads();
            int bonificacion = (space.puntosPorVida() - space.puntosPorDisparos());

            if (bonificacion > 0) {
                space.getPartidaActual().getPuntaje().setPuntuacion(bonificacion);
            }

            interfaz.perder();
        }

        if (interfaz.estaEnFuncionamiento()) {
            g.drawString("Vidas jugador: " + space.getJugadorActual().getVida(), 100, 470);
        }

	}

    public int getPosJugadorActualX() {
        return posJugadorActualX;
    }

    public int getPosJugadorActualY() {
        return posJugadorActualY;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

}
