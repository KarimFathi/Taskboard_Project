package ProjetIHM;
import java.awt.Color;



public class Couleur {
    Color c;
    float h,s,b;
    
    // i est l'angle en heure de 0 � 12:00
    public Couleur(int i){
    	float fi = (float) i / 12.0f;
      	h = fi;
       	System.out.println(h);
    	s = 0.7f;
    	b = 0.5f;
       	c = Color.getHSBColor(h, s, b);
    }
    
    public Color tint(){
    	float newb = b + 0.2f;
       	Color c = Color.getHSBColor(h, s, b);
       	return c;
    }
    
    public Color tone(){
    	float news = s - 0.2f;
       	Color c = Color.getHSBColor(h, news, b);
       	return c;
    }
    
    public Color shade(){
    	float newb = b - 0.2f;
       	Color c = Color.getHSBColor(h, newb, b);
       	return c;
    }
    public Color color(){
      	return c;
    }

    
};
