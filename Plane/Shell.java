package Plane;

import java.awt.Color;
import java.awt.Graphics;

public class Shell extends GameProject{
	double degree;
	public Shell() {
		x = 200;
		y = 200;
		width = 10;
		height = 10;
		degree = Math.random()*Math.PI*2;
	}
	public void draw(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.GREEN);
		g.fillOval((int)x, (int)y, width, height);
		
		g.setColor(Color.RED);
		g.fillOval(2*(int)x, 2*(int)y, width, height);
		x += 3*Math.cos(degree);
		y += 3*Math.sin(degree);
		
		if(x<0||x>490){
			degree = Math.PI-degree;
		}
		
		if(y<30||y>490){
			degree =-degree;
		}
		
		
		g.setColor(c);
	}
}
