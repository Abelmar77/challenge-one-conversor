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
	private JButton button;
	private String eleccion="", eleccion2="";
	private double moneda1=0.0;
	private double monedaConvertida=0.00;
	
	Menu_moneda(){
		
		
	 combo();
	 botones();
	 cuadro();
		
	}
	
	
	
	public void botones() {
		button=new JButton("Ok");;
		button.setBounds(140,140,100,30);;
		button.addActionListener(this);;
		
	}
	
         public void cuadro() {
		
		this.setTitle("Conversor Moneda");
	    this.setLocationRelativeTo(null);
		this.setSize(400,230);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/res/logo.png")));
		this.getContentPane().setBackground(Color.black);
		this.add(comboBox);
		this.add(comboBox2);
		this.add(button);;
	}
         
         public void combo() {
     		
         	String[] opciones= {"Seleccione Moneda -->",
         			"Moneda Mexicana","Moneda Argentina",
         	"Moneda Colombiana","Moneda Brazileña", "Moneda Estadounidense",
         	"Moneda Española", "Moneda Inglesa", "Moneda Japonesa", "Moneda Coreana"};
     		
     		comboBox=new JComboBox(opciones);
     		comboBox.addActionListener(this);
     		comboBox.setBounds(80, 30, 240, 30);
   
     		
     		comboBox2=new JComboBox(opciones);
     		comboBox2.addActionListener(this);
     		comboBox2.setBounds(80, 85, 240, 30);
     	   
     		this.pack();
     		
 	}
         
         public void inputDialgo() {
        	 
        	 
 			
				if(eleccion==""||eleccion2=="") {
				
				JOptionPane.showMessageDialog(null,"Elige opción válida");
				
				}else {
				  
				String cantidad = JOptionPane.showInputDialog(null,"Ingresa cantidad a convertir");
				
		 
		         if (validarNumero(cantidad)) {
		        	 
		        	 double cantidadIngresada= Double.parseDouble(cantidad);
		        	 logicaConversion(cantidadIngresada);		        	 
		                             }         		        	
				}	
  	}
         
         public void  logicaConversion(Double cantidad){
        	 
 			if(eleccion=="Moneda Mexicana") {
 				
 				monedaConvertida=cantidad*(1/moneda1);
 				JOptionPane.showMessageDialog(null,String.format( "$"+cantidad+" "+eleccion2+" son: %.3f pesos mexicanos",monedaConvertida));
 				
 				}
 			
 			if(eleccion=="Moneda Argentina") {
 				
 				monedaConvertida=(cantidad)*(11.117038/moneda1);
 				JOptionPane.showMessageDialog(null, String.format("$"+cantidad+" "+eleccion2+" son: %.3f pesos argentino",monedaConvertida));
 				
 			
 				}
 			
 			if(eleccion=="Moneda Colombiana") {
 				monedaConvertida=cantidad*(265.64856/moneda1);
 				JOptionPane.showMessageDialog(null,String.format( "$"+cantidad+" "+eleccion2+" son: %.3f pesos colombianos",monedaConvertida));
 				
 				
 				}
 			
 			if(eleccion=="Moneda Brazileña") {
 				
 				monedaConvertida=cantidad*(0.2855918/moneda1);
 				JOptionPane.showMessageDialog(null, String.format("$"+cantidad+" "+eleccion2+" son: %.3f Reales",monedaConvertida));
 							
 			}
 			
         if(eleccion=="Moneda Estaunidense") {
 				
 				monedaConvertida=cantidad*(0.055591953/moneda1);
 				JOptionPane.showMessageDialog(null, String.format(cantidad+" "+eleccion2+" son: %.3f Dolares",monedaConvertida));
 							
 			}
         
         if(eleccion=="Moneda Española") {
 				
 				monedaConvertida=cantidad*(0.052712178/moneda1);
 				JOptionPane.showMessageDialog(null, String.format(cantidad+" "+eleccion2+" son: %.3f Euros",monedaConvertida));
 							
 			}
         if(eleccion=="Moneda Inglesa") {
 				
 				monedaConvertida=cantidad*(0.046949866/moneda1);
 				JOptionPane.showMessageDialog(null, String.format(cantidad+" "+eleccion2+" son: %.3f Libras",monedaConvertida));
 							
 			}
         if(eleccion=="Moneda Japonesa") {
 				
 				monedaConvertida=cantidad*(7.628158/moneda1);
 				JOptionPane.showMessageDialog(null, String.format(cantidad+" "+eleccion2+" son: %.3f Yenes",monedaConvertida));
 							
 			}
       
         
         if(eleccion=="Moneda Coreana") {
 				
 				monedaConvertida=cantidad*(73.233996/moneda1);
 				JOptionPane.showMessageDialog(null, String.format(cantidad+" "+eleccion2+" son: %.3f Souls",monedaConvertida));
 							
 			}
         
         
         ventanaContinuar();
         	 
         }
         
         
         public void ventanaContinuar() {
        	   
        	 int opcion = JOptionPane.showConfirmDialog(null, "¿Quieres realizar otra operción?", "Selecciona opción...",
      				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
              
                switch(opcion) {
      		
      		case 0:			
      			MyFrame menu =new  MyFrame();
             		setVisible(false); //you can't see me!
             		dispose(); //Destroy the JFrame object
      			break;
      		case 1:
      			setVisible(false); //you can't see me!
             		dispose(); //Destroy the JFrame object	
      			break;
      		case 2:
      			setVisible(false); //you can't see me!
             		dispose(); //Destroy the JFrame object
      			break;		
      		default:
      			   
                     }
                
         }
         
         public Boolean validarNumero(String numero) {
        	 
        	 char array[] = numero.toCharArray();
 
        	 for (int i = 0; i < numero.length(); i++) {
        		 
        		 int letra=array[i];
                
        		 if((letra<48)||(letra>57)&&(letra!=46)){
		       	  
        			 JOptionPane.showMessageDialog(null,"Ingresa sólo números");
        			
        			 return false;
                 }
        		 
             }   	 
        	
        	 return true;
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
			moneda1=11.117229;
			eleccion2="ARG";
			break;
		case 3:
			moneda1=265.5674;
			eleccion2="COP";
			break;
		case 4:
			moneda1=0.28571214;
			eleccion2="BRL";
			break;
		case 5:
			moneda1=0.055593178;
			eleccion2="USD";
			break;
		case 6:
			moneda1=0.052712918;
			eleccion2="EUR";
			break;
		case 7:
			moneda1=0.046943871;
			eleccion2="GBP";
			break;
		case 8:
			moneda1=7.6278635;
			eleccion2="JPY";
			break;
		case 9:
			moneda1=73.242927;
			eleccion2="KRW";
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
				
			case 6:
				eleccion="Moneda Española";				
				break;
				
			case 7:
				eleccion="Moneda Inglesa";				
				break;
				
			case 8:
				eleccion="Moneda Japonesa";				
				break;
				
			case 9:
				eleccion="Moneda Coreana";				
				break;
				
			default:
				eleccion="Elige una opción";       
				}
			
	               }
      
      
		if(e.getSource()==button) {
			
		
			inputDialgo();
			
           
           
                
			}
		
	           
	         
		
	}
	
	
	
}
