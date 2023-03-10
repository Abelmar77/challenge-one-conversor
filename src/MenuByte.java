import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuByte extends JFrame implements ActionListener {
	
	
	private JComboBox comboBox, comboBox2;
	private JTextField editTexto;
	private JButton button,button2,button3;
	private String eleccion="", eleccion2="";
	private double cantidadIngresada=0.00,dato1=0.0;
	private double datoConvertido=0.00;
	
	
	MenuByte(){
		
    	 combo();
		 editText();
		 botones();
		 cuadro();
			
	}

	

	public void editText() {
		
		editTexto=new  JTextField();
		editTexto.setText("0");
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
		
		this.setTitle("Conversor datos");
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
     		
         	String[] opciones= {"Seleccione unidad -->",
         			"bit","Kilobit",
         	"Megabit","Gigabit", "Terabite","Byte","Kilobyte",
         	"Megabyte","Gigabyte", "Terabyte"};
     		
     		comboBox=new JComboBox(opciones);
     		comboBox.addActionListener(this);
     		comboBox.setBounds(80, 30, 240, 30);
   
     		
     		comboBox2=new JComboBox(opciones);
     		comboBox2.addActionListener(this);
     		comboBox2.setBounds(80, 85, 240, 30);
     	   
     		this.pack();
     		
 	}
         
    public Boolean validarNumero(String numero) {
        	 
        	 char array[] = numero.toCharArray();
 
        	 System.out.println("paso "+numero.length());
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
			dato1=8388608;
			eleccion="bit";
			break;
		case 2:
			dato1=8192;
			eleccion="Kilobit";	
			break;
		case 3:
			dato1=8;
			eleccion="Megabit";	
			break;
		case 4:
			dato1=0.0078125;
			eleccion="Gigabit";
			break;
		case 5:
			dato1=0.00000762939453125;
			eleccion="Terabit";
			break;
		case 6:
			dato1=1048576;
			eleccion="Byte";
			break;
		case 7:
			dato1=1024;
			eleccion="Kilobyte";
			break;
		case 8:
			dato1=1.00;
			eleccion="Megabyte";
			break;
		case 9:
			dato1=.0009765625;
			eleccion="Gigabyte";
			break;
		case 10:
			dato1=0.00000095367431640625;
			eleccion="Terabyte";
			break;
			
		default:
			eleccion="Elige una opción";       
			}
		
               }
		
		if(e.getSource()==comboBox2) {
			
			switch(comboBox2.getSelectedIndex()) {
			
			case 1:
				eleccion2="bit";			
				break;
			case 2:
				eleccion2="Kilobit";				
				break;
			case 3:
				eleccion2="Megabit";				
				break;
			case 4:
				eleccion2="Gigabit";				
				break;
				
			case 5:
				eleccion2="Terabit";				
				break;
			case 6:
				eleccion2="Byte";				
				break;
			case 7:
				eleccion2="Kilobyte";				
				break;
			case 8:
				eleccion2="Megabyte";				
				break;
			case 9:
				eleccion2="Gigabyte";				
				break;
			case 10:
				eleccion2="Terabyte";				
				break;
				
			default:
				eleccion2="Elige una opción";       
				}
			
	               }
      
      
		if(e.getSource()==button) {
						 
			
			 if (validarNumero(editTexto.getText())) {
	        	 
				 cantidadIngresada=Double.parseDouble(editTexto.getText());
				 
	        	 logicaConversion(cantidadIngresada);		        	 
	                            
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

	
	
	public void logicaConversion( Double cantidadIngresada) {
		
		if(eleccion2=="bit") {
            
			 datoConvertido=(cantidadIngresada*((1048576/dato1)*8));
			
			}
		
		if(eleccion2=="Kilobit") {
			       
			 datoConvertido=(cantidadIngresada*((1024/dato1)*8));
			
		
			}
		
		if(eleccion2=="Megabit") {
			 datoConvertido=(cantidadIngresada*((1/dato1)*8));
			
			}
		
		if(eleccion2=="Gigabit") {
			
			  datoConvertido=(cantidadIngresada*((0.0009765625/dato1)*8));
						
		}
		
      if(eleccion2=="Terabit") {
			
   	   datoConvertido=(cantidadIngresada*((0.00000095367431640625/dato1)*8));
						
		}
      
      if(eleccion2=="Byte") {
			
			datoConvertido=cantidadIngresada*(1048576/dato1);
			
			}
		
		if(eleccion2=="Kilobyte") {
			
			datoConvertido=(cantidadIngresada)*(1024/dato1);
			
		
			}
		
		if(eleccion2=="Megabyte") {
			datoConvertido=cantidadIngresada*(1/dato1);
			
			
			}
		
		if(eleccion2=="Gigabyte") {
			 
			 datoConvertido=cantidadIngresada*(0.0009765625/dato1);
						
		}
		
     if(eleccion2=="Terabyte") {
   	  
   	    datoConvertido=cantidadIngresada*(0.00000095367431640625/dato1);
							
		}
      
      if(eleccion==""||eleccion2=="") {
			
			JOptionPane.showMessageDialog(null,"Elige opción válida");
			
			}
      
      else {
    	  JOptionPane.showMessageDialog(null, String.format(cantidadIngresada+" "+eleccion+"  son: %.6f "+eleccion2,datoConvertido));
  		
      }
      
      
		
		
	}
	
	
	
	
}