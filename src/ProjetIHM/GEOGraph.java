package ProjetIHM;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GEOGraph extends JPanel implements MouseListener,
		MouseMotionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GEOGraph() {
		addMouseListener(this);
		addMouseMotionListener(this);

	}

	private FormesDessinable objetEnDeplacement = null;
	private ArrayList<FormesDessinable> listeDesFormes = new ArrayList<FormesDessinable>();

	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g2D = (Graphics2D) g;
		g2D.draw3DRect(5, 5, 314, 30, true);
		g2D.drawString("LES SOUS PROJETS ", 10, 25);

		g.draw3DRect(330, 5, 298, 30, false);
		g2D.drawString("TACHES EN ATTENTE  ", 330, 25);

		g.draw3DRect(638, 5, 290, 30, false);
		g2D.drawString("TACHES EN COURS  ", 638, 25);

		g.draw3DRect(938, 5, 298, 30, false);
		g2D.drawString("TACHES ACHEVEES  ", 938, 25);

		g.drawLine(0, 40, 1233, 40);

		g.drawLine(325, 0, 325, 900);

		g.drawLine(633, 0, 633, 900);

		g.drawLine(933, 0, 933, 900);

		g.drawLine(1233, 0, 1233, 900);

		for (FormesDessinable f : listeDesFormes)
			//if (f instanceof Forme ){
				
			if (f instanceof FormeSousProjet){
				f.dessiner(g, f.getName());
			}else{
				f.dessiner(g, f.getName(), f.getGroup(), f.getDescriptif(), f.getSousProjetName());	
				System.out.print("Je suis dans le cas de la tache");
			}
			

	}

	// ** ajouter un rectangle en cliquant sur la sousrue //***********
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2 && !e.isConsumed()) {

			Forme F = new Forme(new Point(e.getPoint()));
			 String  tacheName=JOptionPane.showInputDialog(null,"Entrez le nom de la t‚che ");
	    	  String  groupName=JOptionPane.showInputDialog(null,"Entrez le nom du group ");
	    	  String  tacheDesc=JOptionPane.showInputDialog(null,"Entrez le dËscriptif de la t‚che ");
	    	  String  sousProjetName=JOptionPane.showInputDialog(null,"Entrez le nom du sous projet ");
		    	
	    	  F.setGroup(groupName);
	    	  F.setName(tacheName);
	    	  F.setDescriptif(tacheDesc);
	    	  F.setSousProjetName(sousProjetName);
			listeDesFormes.add(F);
			repaint();
		}
	}

	// ***********************************************

	// pour puvoir faire bouger l'objet je detecte si j'ai bien click√© sur un
	// objet
	public void mousePressed(MouseEvent e) {
		FormesDessinable FD = getObjet(e.getPoint());
		if (FD == null)
			return;
		objetEnDeplacement = FD;
	}

	// je fait le setPoint pour lui donner les nouvelles coordonn√© puis reapint
	public void mouseDragged(MouseEvent e) {
		if (objetEnDeplacement != null) {
			objetEnDeplacement.setPoint(e.getPoint());
			repaint();
		}
	}

	public ArrayList<FormesDessinable> getListeDesFormes() {
		return listeDesFormes;
	}

	// revoie l'objet a partir du point sur le quel on a clik√©
	public FormesDessinable getObjet(Point p) {
		for (FormesDessinable F : listeDesFormes) {
			if (F.getRectangle().contains(p))
				return F;
		}
		return null;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		objetEnDeplacement = null;

	}

	public FormesDessinable getObjetEnDeplacement() {
		return objetEnDeplacement;
	}

	public void setObjetEnDeplacement(FormesDessinable objetEnDeplacement) {
		this.objetEnDeplacement = objetEnDeplacement;
	}

	public void setListeDesFormes(ArrayList<FormesDessinable> listeDesFormes) {
		this.listeDesFormes = listeDesFormes;
	}

}
