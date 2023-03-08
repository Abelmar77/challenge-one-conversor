import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyFrame extends JFrame implements ActionListener {
	
	private JComboBox comboBox;
	private JButton button;
	private JButton button2;
	private String eleccion="";
	
	MyFrame(){
		
		
		botones();
		combo();
		cuadro();	
		
	}
	
	
	
	public void cuadro() {
		
		this.setTitle("Menú");
	    this.setLocationRelativeTo(null);
		this.setSize(420,200);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/res/logo.png")));
		this.getContentPane().setBackground(Color.black);
		this.add(button);
		this.add(button2);
		this.add(comboBox);
		
	}
	
	
	public void botones() {
		button=new JButton("Ok");
		button2=new JButton("Salir");
		button.setBounds(80,100,100,30);
		button2.setBounds(220,100,100,30);
		button.addActionListener(this);
		button2.addActionListener(this);
		
	}
	
        public void combo() {
		
        	String[] opciones= {"Selecciona opcion --->","Conversor de Monedas","Conversor de Bytes"};
    		
    		comboBox=new JComboBox(opciones);
    		comboBox.setBounds(80, 30, 240, 30);
    		comboBox.addActionListener(this);
    	    
    		this.pack();
	}
        
   
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==comboBox) {
			
			if(comboBox.getSelectedIndex()==1) {
				
				eleccion="moneda";
				
			}
			
			if(comboBox.getSelectedIndex()==2) {
				
				eleccion="byte";	
			}
			
			
		}
		
	if(e.getSource()==button) {
		
		
		if(eleccion=="moneda") {
			Menu_moneda moneda =new  Menu_moneda();
			setVisible(false); //you can't see me!
			dispose(); 
			}
		
		if(eleccion=="byte") {
			MenuByte moneda =new  MenuByte();
			setVisible(false); //you can't see me!
			dispose(); 
			}
		
		if(eleccion=="") {
			
			JOptionPane.showMessageDialog(null, "Ingresa opcion");
		}
		
			
		}
	
	if(e.getSource()==button2) {
		setVisible(false); //you can't see me!
		dispose(); //Destroy the JFrame object
	
		}
		
	}
	
	

}
