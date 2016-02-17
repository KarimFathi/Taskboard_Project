package ProjetIHM;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class jmenubar extends JMenuBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3709516534717506096L;
	private String mote;
	final JTabbedPane tabbedPane = new JTabbedPane();
	Dimension closeButtonSize = null;

	public jmenubar() {

		JMenu file = new JMenu("file");

		JMenu New = new JMenu("New");

		JMenuItem Open = new JMenuItem("Open");
		JMenu Edit = new JMenu(" Edit");
		JMenuItem Close = new JMenuItem("close");
		Close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		JMenuItem Copier = new JMenuItem("Copier ");
		JMenuItem Coller = new JMenuItem("Coller");
		JMenuItem Coper = new JMenuItem("Coper");

		// ****** Ajouter un Noueau Projet ********//////////
		JMenuItem Projet = new JMenuItem("Projet");
		Projet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mote = JOptionPane.showInputDialog(null,
						"Entre le nom du projet ");

				final JPanel content = new GEOGraph();
				JPanel tab = new JPanel();
				tab.setOpaque(false);
				JLabel labelOnglet = new JLabel(mote);
				JButton boutonFermer = new JButton(new ImageIcon("fermer.png"));

				boutonFermer.setPreferredSize(closeButtonSize);
				boutonFermer.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						int closeTabNumber = tabbedPane
								.indexOfComponent(content);
						tabbedPane.removeTabAt(closeTabNumber);

					}
				});

				tab.add(labelOnglet, BorderLayout.WEST);
				tab.add(boutonFermer, BorderLayout.EAST);

				tabbedPane.addTab(null, content);
				tabbedPane.setTabComponentAt(tabbedPane.getTabCount() - 1, tab);
				repaint();
			}
		});

		JMenuItem Tache = new JMenuItem("Task");
		this.add(file);
		this.add(Edit);

		file.add(New);
		file.add(Open);
		file.add(Close);

		New.add(Tache);
		New.add(Projet);

		Edit.add(Copier);
		Edit.add(Coller);
		Edit.add(Coper);

		this.setVisible(true);

	}

}