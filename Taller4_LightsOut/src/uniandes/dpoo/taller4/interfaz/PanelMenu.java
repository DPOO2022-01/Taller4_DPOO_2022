package uniandes.dpoo.taller4.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class PanelMenu extends JPanel{
	
	private JRadioButton rbtn1;
	private JRadioButton rbtn2;
	private JRadioButton rbtn3;
	private JComboBox<String> jcbEjemplo;
	
	public PanelMenu() {
		setSize(700,20);
		setLayout( new BorderLayout( ) );
	    
	    setLayout( new GridLayout( 1 , 4 ) );
	    
	    //elemento1
	    JTextField txtEjemplo= new JTextField( " Tamaño " );
        txtEjemplo.setEditable( false );
        add( txtEjemplo );
	    //elemento2
        jcbEjemplo= new JComboBox<String>();
        jcbEjemplo.addItem("4x4");
        jcbEjemplo.addItem("5x5");
        jcbEjemplo.addItem("6x6");
        add(jcbEjemplo);
	    
        //elemento3
        JTextField txtEjemplo1= new JTextField( " Dificultad " );
        txtEjemplo1.setEditable( false );
        add( txtEjemplo1 );
	    
        //elemento4
        rbtn1= new JRadioButton("Fácil",true);
        rbtn2= new JRadioButton("Medio",false);
        rbtn3= new JRadioButton("Díficil",false);
        ButtonGroup gruporbtn= new ButtonGroup();
        gruporbtn.add(rbtn1);
        gruporbtn.add(rbtn2);
        gruporbtn.add(rbtn3);
        add(rbtn1);
        add(rbtn2);
        add(rbtn3);
	}
	
	public String getSelected() {
		if (rbtn1.isSelected()) {
			return "facil";
		}
		else if (rbtn2.isSelected()) {
			return "medio";
		}
		else if (rbtn3.isSelected()) {
			return "dificil";
		}
		return "facil";
	}
	
	public int getDimension() {
		int numero=0;
		if (jcbEjemplo.getSelectedItem().equals("4x4")){
			numero=4;
		}
		else if (jcbEjemplo.getSelectedItem().equals("5x5")){
			numero=5;
		}
		else if (jcbEjemplo.getSelectedItem().equals("6x6")){
			numero=6;
		}
		return numero;
		
	}
}
