package uniandes.dpoo.taller4.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import uniandes.dpoo.taller4.modelo.Tablero;

public class PanelTabla extends JPanel implements MouseListener{
	
	private Tablero tablero;
	private int lastRow,lastCol;
	private InterfazTaller4 interfaz;
	
	public PanelTabla(Tablero tablero, InterfazTaller4 interfaz) {
		
		this.tablero=tablero;
		this.interfaz=interfaz;
		setSize(500,300);
		setLayout(new BorderLayout());
		addMouseListener(this);
		setVisible(true);
	}
	@Override
	public void paintComponent(Graphics g) {
		ImageIcon imagen= new ImageIcon("data/luz.png");
		int size= tablero.darTablero().length;
		int posx= getWidth()/size;
		int posy= getHeight()/size;
		//crear tabla con Java2D
		Graphics2D g2d= (Graphics2D) g;
		for (int i = 0; i<size;i++) {
			for(int j=0; j<size;j++) {
				if (tablero.darTablero()[i][j]) {
					//true es tablero apagado
					Rectangle2D.Double base = new Rectangle2D.Double(i*posx, j*posy, posx, posy);
					//RoundRectangle2D.Double(); no se importa
                    g2d.setColor(Color.YELLOW);
                    g2d.fill(base);
                    g2d.setColor(Color.GRAY);
                    g2d.draw(base);
					g2d.drawImage(imagen.getImage(),i*posx,j*posy, posx, posy, null);
				}
				else {
					//tablero prendido
					Rectangle2D base = new Rectangle2D.Double(i*posx, j*posy, posx, posy);
                    g2d.setColor(Color.GRAY);
                    g2d.fill(base);
                    g2d.setColor(Color.GRAY);
                    g2d.draw(base);
					g2d.drawImage(imagen.getImage(),i*posx,j*posy, posx, posy, null);
				}
			}
		}
	}
	private int[] convertirCoordenadasACasilla(int x, int y)
	{
	int size = tablero.darTablero().length;
	int heightPanelTabla = getHeight();
	int widthPanelTabla = getWidth();
	int heightCasilla = heightPanelTabla / size;
	int widthCasilla = widthPanelTabla / size;
	int row = (int) (y / heightCasilla);
	int col = (int) (x / widthCasilla);
	return new int[] { row, col };
	}
	public int getLastRow() {
		return this.lastRow;
		}
	public int getLastCol() {
		return this.lastCol;
		}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int click_x = e.getX();
		int click_y = e.getY();
		int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
		tablero.jugar(casilla[1], casilla[0]);
		interfaz.setJugadas();
		this.lastRow = casilla[0];
		this.lastCol = casilla[1];
		
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
