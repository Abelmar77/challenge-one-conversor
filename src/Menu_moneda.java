import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu_moneda extends JFrame implements ActionListener {
	
	private JComboBox comboBox, comboBox2;
	private JTextField editTexto;
	private JButton button,button2,button3;
	private String eleccion="", eleccion2="";
	private double cantidadIngresada=0.00,moneda1=0.0;
	private double monedaConvertida=0.00;
	
	Menu_moneda(){
		
		
	 combo();
	 editText();
	 botones();
	 cuadro();
		
	}
	
	public void editText() {
		
		editTexto=new  JTextField();
		editTexto.setText("0.0");
		editTexto.setBounds(100, 140, 180, 25);
		
	}
	
	public void botones() {
		button=new JButton("Convertir");
		button2=new JButton("Menú");
		button3=new JButton("Salir");
		button.setBounds(80,190,100,30);
		button2.setBounds(220,190,100,30);
		button3.setBounds(150,240,100,30);
		button.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		
	}
	
         public void cuadro() {
		
		this.setTitle("Conversor Moneda");
	    this.setLocationRelativeTo(null);
		this.setSize(400,350);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/res/logo.png")));
		this.getContentPane().setBackground(Color.black);
		this.add(comboBox);
		this.add(comboBox2);
		this.add(button);
		this.add(button2);
		this.add(button3);
		this.add(editTexto);
		
	}
         
         public void combo() {
     		
         	String[] opciones= {"Seleccione Moneda -->",
         			"Moneda Mexicana","Moneda Argentina",
         	"Moneda Colombiana","Moneda Brazileña", "Moneda Estadounidense"};
     		
     		comboBox=new JComboBox(opciones);
     		comboBox.addActionListener(this);
     		comboBox.setBounds(80, 30, 240, 30);
   
     		
     		comboBox2=new JComboBox(opciones);
     		comboBox2.addActionListener(this);
     		comboBox2.setBounds(80, 85, 240, 30);
     	   
     		this.pack();
     		
 	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==comboBox) {
			
		switch(comboBox.getSelectedIndex()) {
		
		case 1:
			moneda1=1;
			eleccion2="MXN";
			break;
		case 2:
			moneda1=11.072036;
			eleccion2="ARG";
			break;
		case 3:
			moneda1=261.22017;
			eleccion2="COP";
			break;
		case 4:
			moneda1=0.28625768;
			eleccion2="BRL";
			break;
		case 5:
			moneda1=0.055543552;
			eleccion2="USD";
			break;
			
		default:
			eleccion2="Elige una opción";       
			}
		
               }
		
		if(e.getSource()==comboBox2) {
			
			switch(comboBox2.getSelectedIndex()) {
			
			case 1:
				eleccion="Moneda Mexicana";			
				break;
			case 2:
				eleccion="Moneda Argentina";				
				break;
			case 3:
				eleccion="Moneda Colombiana";				
				break;
			case 4:
				eleccion="Moneda Brazileña";				
				break;
				
			case 5:
				eleccion="Moneda Estaunidense";				
				break;
				
			default:
				eleccion="Elige una opción";       
				}
			
	               }
      
      
		if(e.getSource()==button) {
			
		
			 
			cantidadIngresada=Double.parseDouble(editTexto.getText());
			
				if(eleccion==""||eleccion2=="") {
				
				JOptionPane.showMessageDialog(null,"Elige opción válida");
				
				}else
			
			if(eleccion=="Moneda Mexicana") {
				
				monedaConvertida=cantidadIngresada*(1/moneda1);
				JOptionPane.showMessageDialog(null,String.format( "$"+cantidadIngresada+" "+eleccion2+" son: %.3f pesos mexicanos",monedaConvertida));
				
				}
			
			if(eleccion=="Moneda Argentina") {
				
				monedaConvertida=(cantidadIngresada)*(11.072036/moneda1);
				JOptionPane.showMessageDialog(null, String.format("$"+cantidadIngresada+" "+eleccion2+" son: %.3f pesos argentino",monedaConvertida));
				
			
				}
			
			if(eleccion=="Moneda Colombiana") {
				monedaConvertida=cantidadIngresada*(261.22017/moneda1);
				JOptionPane.showMessageDialog(null,String.format( "$"+cantidadIngresada+" "+eleccion2+" son: %.3f pesos colombianos",monedaConvertida));
				
				
				}
			
			if(eleccion=="Moneda Brazileña") {
				
				monedaConvertida=cantidadIngresada*(0.28625768/moneda1);
				JOptionPane.showMessageDialog(null, String.format("$"+cantidadIngresada+" "+eleccion2+" son: %.3f Reales",monedaConvertida));
							
			}
			
           if(eleccion=="Moneda Estaunidense") {
				
				monedaConvertida=cantidadIngresada*(0.055543552/moneda1);
				JOptionPane.showMessageDialog(null, String.format(cantidadIngresada+" "+eleccion2+" son: %.3f Dolares",monedaConvertida));
							
			}
           
           
                
			}
		
		 if(e.getSource()==button2) {
       	  
	        	MyFrame menu =new  MyFrame();
	       		setVisible(false); //you can't see me!
	       		dispose(); //Destroy the JFrame object
	       	
	       		}
	           
	           if(e.getSource()==button3) {
	         	  
	        	setVisible(false); //you can't see me!
	       		dispose(); //Destroy the JFrame object
	          	
	          		}
		
	}
	
	
	
}
