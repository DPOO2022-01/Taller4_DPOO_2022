package uniandes.dpoo.taller4.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelInformacion extends JPanel{
	
	private JTextField txtEjemplo2,txtEjemplo4;
	
	public PanelInformacion() {
		setSize(700,20);
		setLayout( new BorderLayout( ) );
	    
	    setLayout( new GridLayout( 1 , 4 ) );
	    
	    //elemento1
	    JLabel lblEjemplo1= new JLabel( " Jugadas: " );
        add( lblEjemplo1 );
	    //elemento2
        txtEjemplo2= new JTextField( " 0 " );
        txtEjemplo2.setEditable( false );
        add( txtEjemplo2 );
	    //elemento3
        JLabel lblEjemplo2= new JLabel( " Jugador: " );
        add( lblEjemplo2 );
	    //elemento4
        txtEjemplo4= new JTextField();
        txtEjemplo4.setEditable( false );
        add( txtEjemplo4 );
	}
	public void setJugadas(String numJugadas) {
		txtEjemplo2.setText(numJugadas);
	}
	public void setJugador(String nombre) {
		txtEjemplo4.setText(nombre);
	}
	public String getJugador() {
		return txtEjemplo4.getText();
	}
}
