package ProjetIHM;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;


public interface Dessinable {

   public void dessiner(Graphics g);

   public Rectangle getRectangle();
   
   public Rectangle2D getRectangle2d();

}
