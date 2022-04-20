package uniandes.dpoo.taller4.interfaz;
import java.awt.BorderLayout;
import java.util.Collection;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;

@SuppressWarnings("serial")
public class InterfazTaller4 extends JFrame{
	
	private PanelMenu panelMenu;
	private PanelTabla panelTabla;
	private PanelOpciones panelOpciones;
	private PanelInformacion panelInformacion;
	private Tablero tablero;
	private Top10 top10;
	String name;
	
	public InterfazTaller4() 
	{
		//"traer el mundo"
		top10= new Top10();
		name = new JOptionPane().showInputDialog("Ingresen nombre jugador: ");
		
		//caracteristicas generales
		setSize(700,500);
		setTitle("TALLER 4 DPOO");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle( "Lights Out Game " );
		setLayout(new BorderLayout());
		
		//inicializar paneles
		panelMenu= new PanelMenu();
		add(panelMenu, BorderLayout.NORTH);
		panelInformacion= new PanelInformacion();
		add(panelInformacion, BorderLayout.SOUTH);
		panelOpciones= new PanelOpciones(this);
		add(panelOpciones, BorderLayout.EAST);
		
		//agregar datos iniciales
		setNewJugador();
		
		JPanel panelCentro = new JPanel();
		panelCentro.setSize(300, 210);
        panelCentro.setLayout(new BorderLayout());
        panelCentro.setVisible(false);
        add(panelCentro, BorderLayout.CENTER );
        
		/*
		addWindowListener(new WindowAdapter());
		{
		public void windowClosing(WindowEvent e)
		{
		salvarTop10();
		}
		});*/
	}
	public static void main(String[] args) 
	{
		InterfazTaller4 interfaz= new InterfazTaller4();
		interfaz.setVisible(true);
	}
	public void newJuego() {
		/*if (panelTabla!=null) {
			this.remove(panelTabla);
		}*/
		int tamano= panelMenu.getDimension();
		tablero= new Tablero(tamano);
		//añadir tablero de Java2d
		panelTabla= new PanelTabla(tablero,this);
		add(panelTabla, BorderLayout.WEST);
		panelTabla.paintComponent(getGraphics());
		panelTabla.setVisible(true);
		//desordenar tablero para primer jugada
		int level=Integer.parseInt(panelMenu.getSelected());
		tablero.desordenar(level);
	}
	public void reiniciarJuego() {
		int puntaje= tablero.calcularPuntaje();
		top10.agregarRegistro(panelInformacion.getJugador(), puntaje);
		tablero.reiniciar();
		panelInformacion.setJugadas("0");
		panelTabla.paintComponent(getGraphics());
		
	}
	public void setJugadas() {
		int numero= tablero.darJugadas();
		panelInformacion.setJugadas(Integer.toString(numero));
	}
	public void setNewJugador() {
		panelInformacion.setJugador(this.name);
	}
	public void setJugador() {
		String names = new JOptionPane().showInputDialog("Ingresen nombre jugador: ");
		panelInformacion.setJugador(names);
	}
	public void showTop10() {
		JTextArea texto = new JTextArea();
		Collection<RegistroTop10> lista = top10.darRegistros();
		int i= 0;
		//for each para cada registro
		for (RegistroTop10 elemento: lista) {
			String contenido = texto.getText()+ (i+1)+ elemento.toString()+ "\n";
			texto.setText(contenido);
			i++;
		}
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		add(texto, BorderLayout.CENTER);
        setVisible(true);
		/*
		addWindowListener(new WindowAdapter());
		{
		public void windowClosing(WindowEvent e)
		{
		salvarTop10();
		}
		});*/
	}
}
