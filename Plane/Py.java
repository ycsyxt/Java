package Plane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
public class Py extends GameProject {
	boolean left,up,right,down;
	
	public void drawself(Graphics g) {
		g.drawImage(img, (int)x, (int)y, null);
		if(left){
			x -= 3;
		}
		if(right){
			x += 3;
		}
		if(up){
			y -= 3;
		}
		if(down){
			y += 3;
		}
		
	}
	public Py(Image img, double x, double y) {
		// TODO Auto-generated constructor stub
		this.img = img;
		this.x = x;
		this.y = y;
	}
	public void addDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		}
	}
		//减
		public void minusDirection(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				left = false;
				break;
			case KeyEvent.VK_RIGHT:
				right = false;
				break;
			case KeyEvent.VK_UP:
				up = false;
				break;
			case KeyEvent.VK_DOWN:
				down = false;
				break;
			}
		
	}
}
