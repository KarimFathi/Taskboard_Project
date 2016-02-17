package ProjetIHM;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

public class Mainwindows extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7521476166743296371L;
	private String mote;
	 GraphicsDevice device;
	 final JTabbedPane tabbedPane = new JTabbedPane();
		Dimension closeButtonSize;
	
		static GEOGraph  x = new GEOGraph ();

		public static GEOGraph  getGEOGraph (){
			return x;
		}
		
		
		

	public Mainwindows (){
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	     if (device.isFullScreenSupported()) {
	         device.setFullScreenWindow(this);
	     } else {
	         System.err.println("Le mode plein ecran n'est pas disponible");
	     }
		setTitle ("Task Board");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jmenubar men= new jmenubar() ;
		setJMenuBar(men);
		
	     jtoolbar();

	}	
		public void jtoolbar( ){
			
			JToolBar tool1= new JToolBar ();
	
			
			
		JButton ADDProjet= new JButton ("add projet",new ImageIcon("add.png"));
			
		ADDProjet.addActionListener(new ActionListener(){
			      public void actionPerformed(ActionEvent e){
			    	String  mote=JOptionPane.showInputDialog(null,"Entre le nom du projet ");
			    	   
			    //****************  Ajouter  un Projet ***********************************//	
			    	
			    	//final JPanel content = new GEOGraph(); 
			    	final JPanel content = getGEOGraph();
				  	    JPanel tab = new JPanel();
				  	    tab.setOpaque(false);
				  	    JLabel labelOnglet = new JLabel(mote);
				  	    JButton boutonFermer = new JButton(new ImageIcon("fermer.png"));
				  	    
				  		boutonFermer.setPreferredSize(closeButtonSize);
				  	    boutonFermer.addActionListener(new ActionListener() {
				  	    
				  	   public void actionPerformed(ActionEvent e) {
				         int closeTabNumber =  tabbedPane.indexOfComponent(content);
				  	   tabbedPane.removeTabAt(closeTabNumber);
				  			   
				  	      }
				  	    });
				  	 
				  	    tab.add(labelOnglet, BorderLayout.WEST);
				  	    tab.add(boutonFermer, BorderLayout.EAST);
				  	 
				  	    tabbedPane.addTab(null, content);
				  	 
				  
				  	    tabbedPane.setTabComponentAt(tabbedPane.getTabCount() - 1, tab);
				  	    
				  	  add(tabbedPane, BorderLayout.CENTER);   	    
			      }
			    });
		
		// *********** Ajouter un  sous projet **********************************************
		
		JButton newsousprojet = new JButton ("add sousProjet",new ImageIcon("add.png"));
		
		newsousprojet.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent e){
		    	  String  sousProjetName=JOptionPane.showInputDialog(null,"Entrez le nom du sous projet");
		    	
		    	  FormeSousProjet F1 = new FormeSousProjet(150,90);
		    	  F1.setName(sousProjetName);
		    	  F1.dessiner(getGraphics(), sousProjetName);
		    	  getGEOGraph().getListeDesFormes().add(F1);
		    	  getGEOGraph().repaint();
		      }
		    });
		
		// ******* Ajouter une Tâche *********************************************
			JButton ADDtache= new  JButton ("add Task",new ImageIcon("add.png"));
			ADDtache.addActionListener(new ActionListener(){
			      public void actionPerformed(ActionEvent e){
			    	  String  tacheName=JOptionPane.showInputDialog(null,"Entrez le nom de la tâche ");
			    	  String  groupName=JOptionPane.showInputDialog(null,"Entrez le nom du group ");
			    	  String  tacheDesc=JOptionPane.showInputDialog(null,"Entrez le dèscriptif de la tâche ");
			    	  String  sousProjetName=JOptionPane.showInputDialog(null,"Entrez le nom du sous projet ");
			    	  
			    	  
			    	  Forme F = new Forme(150,90);
			    	  F.setName(tacheName);
			    	  F.setGroup(groupName);
			    	  F.setDescriptif(tacheDesc);
			    	  F.setSousProjetName(sousProjetName);
			    	  getGEOGraph().getListeDesFormes().add(F);
						repaint();
			      }
			    });
			
			
				
			tool1.add(ADDProjet);
			tool1.add(ADDtache);
			tool1.add(newsousprojet);
			add(tool1, BorderLayout.NORTH);   
		
	}
		

	public static void main(String[] args) {
		
		Mainwindows  tb = new  Mainwindows ();
		
		
		tb.setLocationRelativeTo(null);
		tb.setVisible(true);
		

	}

		}
