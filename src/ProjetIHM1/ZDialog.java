package ProjetIHM1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;

public class ZDialog extends JDialog {
  private ZDialogInfo zInfo = new ZDialogInfo();
  private boolean sendData; // pour envoyer les données
  private JLabel nomLabel, equipeLabel, cheveuxLabel, descriptionLabel;
  private JRadioButton tranche1, tranche2, tranche3, tranche4;
  private JComboBox equipe;
  private JTextField nom, description;

  public ZDialog(JFrame parent, String title, boolean modal){
    super(parent, title, modal);
    this.setSize(600, 270);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
    this.initComponent();
  }

  public ZDialogInfo showZDialog(){
    this.sendData = false;
    this.setVisible(true);
    return this.zInfo;  
  }

  private void initComponent(){
    //Le nom  (un champ de saisie)
    JPanel panNom = new JPanel();
    panNom.setBackground(Color.white);
    panNom.setPreferredSize(new Dimension(220, 60));
    nom = new JTextField();
    nom.setPreferredSize(new Dimension(100, 25));
    panNom.setBorder(BorderFactory.createTitledBorder("Nom du projet")); //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    nomLabel = new JLabel("Nom :");
    panNom.add(nomLabel);
    panNom.add(nom);

    //Le groupe  (une combo)
    JPanel panEquipe = new JPanel();
    panEquipe.setBackground(Color.white);
    panEquipe.setPreferredSize(new Dimension(220, 60));
    panEquipe.setBorder(BorderFactory.createTitledBorder("Groupe affecté au projet"));
    equipe = new JComboBox();
    equipe.addItem("Equipe Alpha");
    equipe.addItem("Equipe Beta");
    equipe.addItem("Equpe Gama");
    equipeLabel = new JLabel("Equipe :");
    panEquipe.add(equipeLabel);
    panEquipe.add(equipe);

    //Les Taches  (des boutons radios)
    JPanel panTache = new JPanel();
    panTache.setBackground(Color.white);
    panTache.setBorder(BorderFactory.createTitledBorder("Nombre de taches à réaliser"));
    panTache.setPreferredSize(new Dimension(500, 60));
    tranche1 = new JRadioButton("0 - 15 taches");
    tranche1.setSelected(true);
    tranche2 = new JRadioButton("15 - 30 taches");
    tranche3 = new JRadioButton("30 - 50 taches");
    tranche4 = new JRadioButton("+ de 50 taches");
    ButtonGroup bg = new ButtonGroup();
    bg.add(tranche1);
    bg.add(tranche2);
    bg.add(tranche3);
    bg.add(tranche4);
    panTache.add(tranche1);
    panTache.add(tranche2);
    panTache.add(tranche3);
    panTache.add(tranche4);

    //La description (un champ de saisie)
    JPanel panDescription = new JPanel();
    panDescription.setBackground(Color.white);
    panDescription.setPreferredSize(new Dimension(400, 60));
    description = new JTextField("");
    description.setPreferredSize(new Dimension(300, 25));
    panDescription.setBorder(BorderFactory.createTitledBorder("Description du projet"));
    descriptionLabel = new JLabel("Description : ");
    panDescription.add(descriptionLabel);
    panDescription.add(description);


    JPanel content = new JPanel();
    content.setBackground(Color.white);
    content.add(panNom);
    content.add(panEquipe);
    content.add(panTache);
    content.add(panDescription);

    JPanel control = new JPanel();
    JButton okBouton = new JButton("OK");    
    okBouton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {        
        zInfo = new ZDialogInfo(nom.getText(), (String)equipe.getSelectedItem(), getTache(), getDescription());
        setVisible(false);
      }

      public String getTache(){
        return (tranche1.isSelected()) ? tranche1.getText() : 
               (tranche2.isSelected()) ? tranche2.getText() : 
               (tranche3.isSelected()) ? tranche3.getText() : 
               (tranche4.isSelected()) ? tranche4.getText() : 
                tranche1.getText();  
      }

      public String getDescription(){
        return (description.getText().equals("")) ? "" : description.getText();
      }      
    });

    JButton cancelBouton = new JButton("Annuler");
    cancelBouton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {
        setVisible(false);
      }      
    });

    control.add(okBouton);
    control.add(cancelBouton);

    this.getContentPane().add(content, BorderLayout.CENTER);
    this.getContentPane().add(control, BorderLayout.SOUTH);
  }  
}
