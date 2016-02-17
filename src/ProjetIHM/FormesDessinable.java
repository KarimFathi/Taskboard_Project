package ProjetIHM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public abstract class FormesDessinable implements Dessinable {

	protected Rectangle rectangle;
	protected Color color = Color.BLACK;
	protected String name;
	protected String group;
	protected String descriptif;
	protected String sousProjetName;

	/** Creates a new instance of FormesDessinable */
	public FormesDessinable(Point position, Dimension dimention) {
		this.rectangle = new Rectangle(position, dimention);

	}

	public FormesDessinable(int x, int y, Dimension dimention) {
		this.rectangle = new Rectangle(x, y);

	}

	public abstract void dessiner(Graphics g, String nom);

	public abstract void dessiner(Graphics g, String nom, String group,
			String descriptif, String sousProjetName);

	public Rectangle getRectangle() {
		return this.rectangle;
	}

	public Point getPoint() {
		return this.rectangle.getLocation();
	}

	public void setPoint(Point p) {
		this.rectangle.setLocation(p);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getDescriptif() {
		return descriptif;
	}

	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}


	public String getSousProjetName() {
		return sousProjetName;
	}

	public void setSousProjetName(String sousProjetName) {
		this.sousProjetName = sousProjetName;
	}

	@Override
	public String toString() {
		return "FormesDessinable [rectangle=" + rectangle + ", color=" + color
				+ ", name=" + name + "]";
	}

}
