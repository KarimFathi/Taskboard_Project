package ProjetIHM1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;


public class Fenetre extends JFrame {
	
	private JPanel container = new JPanel();
	private JTabbedPane onglet = new JTabbedPane(JTabbedPane.NORTH_EAST);	
	private int nbreOnglet = 0;
	private ZDialogInfo zInfo = new ZDialogInfo();
	
	private JMenuBar menuBar = new JMenuBar();
	
	private JMenu file = new JMenu("File");	
		private JMenuItem newProject = new JMenuItem("New Project");
		private JMenuItem openProject = new JMenuItem("Open Project");
		private JMenuItem saveProject = new JMenuItem("Save Project");
		private JMenuItem closeProject = new JMenuItem("Close Project");
		private JMenuItem printProject = new JMenuItem("Print Project");
		private JMenuItem exit = new JMenuItem("Exit");

	private JMenu board = new JMenu("Board");
		private JMenuItem newTask = new JMenuItem("New Task");
		private JMenu formTask = new JMenu("Form Task");
			private JRadioButtonMenuItem carre = new JRadioButtonMenuItem("Carre");
			private JRadioButtonMenuItem rectangle = new JRadioButtonMenuItem("Rectangle");
			private JRadioButtonMenuItem rond = new JRadioButtonMenuItem("Rond");			
			private ButtonGroup bgForm = new ButtonGroup();
		private JMenu colorTask  = new JMenu("Color Task");
			private JRadioButtonMenuItem bleu = new JRadioButtonMenuItem("Blue");
			private JRadioButtonMenuItem rouge = new JRadioButtonMenuItem("Red");
			private JRadioButtonMenuItem vert = new JRadioButtonMenuItem("Green");
			private ButtonGroup bgColor = new ButtonGroup();
		private JMenu morph = new JMenu("Morphing");
			private JCheckBoxMenuItem reduire = new JCheckBoxMenuItem("Reduce");
			private JCheckBoxMenuItem agrandir = new JCheckBoxMenuItem("Enlarge");
			private ButtonGroup bgMorph = new ButtonGroup();
		private JMenuItem undo = new JMenuItem("Undo");
		private JMenuItem redo = new JMenuItem("Redo");
		private JMenuItem saveTask = new JMenuItem("Save Task");
		private JMenuItem modifyTask = new JMenuItem("Modify Task");		
		private JMenuItem deleteTask = new JMenuItem("Delete Task");
		private JMenuItem addComment = new JMenuItem("Add Comment");
		private JMenuItem addUser = new JMenuItem("Add User");
		private JMenuItem modifyUser = new JMenuItem("Modify Task");
		private JMenuItem deleteUser= new JMenuItem("Delete User");		
		
	private JMenu aPropos = new JMenu("à Propos");
		private JMenuItem aProposItem = new JMenuItem("?");
	
	
	private JToolBar toolBar = new JToolBar();
		private JButton BnouvelTache = new JButton("New Task");
		private JButton Bavant = new JButton("Undo");
		private JButton Bapres = new JButton("Redo");
		private JButton Bbleu = new JButton("Blue");
		private JButton Brouge = new JButton("Red");
		private JButton Bvert = new JButton("Green");
		private JButton Bcarre = new JButton("Square");
		private JButton Brectangle = new JButton("Rectangle");
		private JButton Brond = new JButton("Round");		
		private JButton Breduire = new JButton("Reduce");
		private JButton Bagrandir = new JButton("Enlarge");
		private JButton BInfosProjet = new JButton("Infos Projet ?");	
	
		
	public Fenetre() {
		this.setTitle("Animation");
		this.setSize(1200, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		container.add(onglet, BorderLayout.CENTER);
		
		this.setContentPane(container);
		this.initMenu();
		this.initToolBar();
		this.setVisible(true);		
	}
	
	public void initMenu() {
		//Menu File
		newProject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
		newProject.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				ZDialog zd = new ZDialog(null, "Informations du projet", true);				
				zInfo = zd.showZDialog();
				
				if (zInfo.toString().compareTo("Aucune information !") != 0)
					onglet.add("Projet N°"+(++nbreOnglet), new Panneau(Color.cyan));				
			}
		});
		
		file.add(newProject);
		openProject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
		file.add(openProject);
		file.addSeparator();
		saveProject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
		file.add(saveProject);
		closeProject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
		closeProject.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int selected = onglet.getSelectedIndex();//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
				if(selected > -1)//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
					onglet.remove(selected);
			}
		});	
		file.add(closeProject);
		file.addSeparator();
		printProject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
		file.add(printProject);
		file.addSeparator();
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				JOptionPane jop2 = new JOptionPane();
				int t1 = jop2.showConfirmDialog(null, "Vous souhaitez quiter l'interface ?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (t1==0)
						System.exit(0);
			}
		});
		file.add(exit);
		
		//Menu Board
		newTask.addActionListener(new NouvelleTacheListener());
		board.add(newTask);
		//----------------------------------------
		bgForm.add(carre);
		bgForm.add(rectangle);
		bgForm.add(rond);		
		FormeListener fl = new FormeListener();//listener des formes
		carre.addActionListener(fl);
		rectangle.addActionListener(fl);
		rond.addActionListener(fl);
		formTask.add(carre);
		formTask.add(rectangle);
		formTask.add(rond);
		rectangle.setSelected(true);//la forme par default
		board.add(formTask);
		//----------------------------------------
		bgColor.add(bleu);
		bgColor.add(rouge);
		bgColor.add(vert);
		ColorListener cl = new ColorListener();//listener des couleurs
		bleu.addActionListener(cl);
		rouge.addActionListener(cl);
		vert.addActionListener(cl);
		colorTask.add(bleu);
		colorTask.add(rouge);
		colorTask.add(vert);
		bleu.setSelected(true);//couleur par defaut
		board.add(colorTask);
		//----------------------------------------
		bgMorph.add(reduire);
		bgMorph.add(agrandir);
		reduire.addActionListener(new MorphListener());		
		morph.add(reduire);
		morph.add(agrandir);
		agrandir.setSelected(true);//le morphing par default
		board.add(morph);
		//----------------------------------------
		board.addSeparator();
		board.add(undo);
		board.add(redo);
		board.addSeparator();
		board.add(saveTask);
		board.add(modifyTask);
		board.add(deleteTask);
		board.addSeparator();
		board.add(addComment);
		board.addSeparator();
		board.add(addUser);
		board.add(modifyUser);
		board.add(deleteUser);
		
		//Menu À propos
		aProposItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane jop = new JOptionPane();
				ImageIcon img = new ImageIcon("images/personnage.jpg");        
				String mess = "Salut ! \n J'espère que vous vous amusez bien !\n";
				mess += "\n Allez, A+ !";        
				jop.showMessageDialog(null, mess, "À propos", JOptionPane.INFORMATION_MESSAGE, img);        
			}            
		});
		aPropos.add(aProposItem);
		
		//barre de menus et ajout de mnémoniques ! 
		file.setMnemonic('f'); // éffectuer un Alt + f pour séléctionner le menu animation
		menuBar.add(file);
		board.setMnemonic('b');
		menuBar.add(board);
		aPropos.setMnemonic('p');
		menuBar.add(aPropos);  
		
		//Ajout de la barre de menus sur la fenêtre
		this.setJMenuBar(menuBar);
	}
	
	
	
	private void initToolBar(){
		BnouvelTache.addActionListener(new NouvelleTacheListener());
		BInfosProjet.addActionListener(new InformationsProjetListener());		
		
	    BnouvelTache.setBackground(Color.white);	
	    Bavant.setBackground(Color.white);
	    Bapres.setBackground(Color.white);
	    Bbleu.setBackground(Color.blue);
	    Brouge.setBackground(Color.red);
	    Bvert.setBackground(Color.green);
	    Bcarre.setBackground(Color.white);
	    Brectangle.setBackground(Color.white);
	    Brond.setBackground(Color.white);
	    Breduire.setBackground(Color.white);
	    Bagrandir.setBackground(Color.white);
	    BInfosProjet.setBackground(Color.white);
	    
	    toolBar.add(BnouvelTache);
	    toolBar.addSeparator();
	    toolBar.add(Bavant);
	    toolBar.add(Bapres);
	    toolBar.addSeparator();
	    toolBar.add(Bbleu);
	    toolBar.add(Brouge);
	    toolBar.add(Bvert);
	    toolBar.addSeparator();
	    toolBar.add(Bcarre);
	    toolBar.add(Brectangle);
	    toolBar.add(Brond);
	    toolBar.addSeparator();
	    toolBar.add(Breduire);
	    toolBar.add(Bagrandir);
	    toolBar.addSeparator(new Dimension(480,0));
	    toolBar.add(BInfosProjet);
	    
	    
	    this.add(toolBar, BorderLayout.NORTH);
	}
	
	public class NouvelleTacheListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			JOptionPane jop = new JOptionPane();    	
			int option = jop.showConfirmDialog(null, "Voulez-vous Créer une nouvelle tache ?", "Lancement de la tache", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			//if (option == JOptionPane.OK_OPTION)
				//pan.newtask
		}
	}
	
	public class InformationsProjetListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {			
			JOptionPane jop = new JOptionPane();
			jop.showMessageDialog(null, zInfo.toString(), "Informations personnage", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	class FormeListener implements ActionListener{
	    public void actionPerformed(ActionEvent e) {     
	    	//pan.setForme(((JRadioButtonMenuItem)e.getSource()).getText());
	    }
	}
	
	class ColorListener implements ActionListener{
	    public void actionPerformed(ActionEvent e) {     
	    }    
	}

	  class MorphListener implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	      //Si la case est cochée, activation du mode morphing
	      //if(morph.isSelected())pan.setMorph(true);
	        //Sinon rien !
	      //else pan.setMorph(false);
	    }    
	}	

}
