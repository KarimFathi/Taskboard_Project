package ProjetIHM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

public class Forme extends FormesDessinable {
	Color bgColor, fgColor;

	public Forme(Point position) {
		super(position, new Dimension(150, 90));
	}

	public Forme(int x, int y) {
		super(x, y, new Dimension(150, 90));
	}

	public void dessiner(Graphics g, String nom, String groupe,
			String descriptif, String sousProjetName) {
		Couleur c = new Couleur((int) (200 * Math.random()));
		fgColor = c.tint();
		bgColor = c.shade();
		//g.setColor(fgColor);
		g.fill3DRect(rectangle.x, rectangle.y, rectangle.width,
				rectangle.height, true);
		g.setColor(bgColor);
		g.drawString(nom, rectangle.x + 55, rectangle.y + 20);
		g.drawString(group, rectangle.x + 20, rectangle.y + 45);
		g.drawString(descriptif, rectangle.x + 20, rectangle.y + 65);
		g.drawString(sousProjetName, rectangle.x + 20, rectangle.y + 85);
		

	}
	

	@Override
	public void dessiner(Graphics g) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void dessiner(Graphics g, String nom) {
		// TODO Auto-generated method stub

	}

	@Override
	public Rectangle2D getRectangle2d() {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}