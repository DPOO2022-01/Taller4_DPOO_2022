package uniandes.dpoo.taller4.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelOpciones extends JPanel implements ActionListener{
	
	private JButton btn1,btn2,btn3,btn4;
	private InterfazTaller4 interfaz;
	
	public PanelOpciones(InterfazTaller4 interfaz) {
		//importar interfaz para usar sus métodos
		this.interfaz=interfaz;
		
		setSize(250,600);
		setLayout( new BorderLayout( ) );
	    
	    setLayout( new GridLayout( 9 , 1 ) );
	    
	   //elemento add
	    JTextField txtEjemplo1= new JTextField( );
        txtEjemplo1.setEditable( false );
        add( txtEjemplo1 );
	    //elemento1
	    btn1= new JButton(" Nuevo ");
	    btn1.setSize(100, 50);
	    btn1.addActionListener(this);
	    add(btn1);
	  //elemento add
	    JTextField txtEjemplo2= new JTextField( );
        txtEjemplo2.setEditable( false );
        add( txtEjemplo2 );
		//elemento2
	    btn2= new JButton(" Reiniciar ");
	    btn2.setSize(100, 50);
	    btn2.addActionListener(this);
	    add(btn2);
	  //elemento add
	    JTextField txtEjemplo3= new JTextField( );
        txtEjemplo3.setEditable( false );
        add( txtEjemplo3 );
		//elemento3
	    btn3= new JButton(" Top-10 ");
	    btn3.setSize(100, 50);
	    btn3.addActionListener(this);
	    add(btn3);
	  //elemento add
	    JTextField txtEjemplo4= new JTextField();
        txtEjemplo4.setEditable( false );
        add( txtEjemplo4 );
		//elemento4
	    btn4= new JButton(" Cambiar Jugador ");
	    btn4.setSize(100, 50);
	    btn4.addActionListener(this);
	    add(btn4);
	  //elemento add
	    JTextField txtEjemplo5= new JTextField( );
        txtEjemplo5.setEditable( false );
        add( txtEjemplo5 );
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1) {
			interfaz.newJuego();
		}
		else if(e.getSource()==btn2) {
			interfaz.reiniciarJuego();
		}
		else if(e.getSource()==btn3) {
			interfaz.showTop10();
		}
		else if(e.getSource()==btn4){
			interfaz.setJugador();
		}
	}
}
