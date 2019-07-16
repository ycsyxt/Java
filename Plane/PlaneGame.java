package Plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.JFrame;

public class PlaneGame extends JFrame {
	int planeX = 400;
	int planeY = 750;
			
	Image meigui = PlaneImage.getImage("Image/meigui.png");
	Image bg = PlaneImage.getImage("Image/test.png");
	@Override
	public void paint(Graphics g) {
			g.drawImage(bg, 0, 0, null);
			g.drawImage(meigui, planeX, planeY, null);
			planeY--;
		
	}
	class PaintTread extends Thread{
		@Override
		public void run() {
			while(true){
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
				
		}
	}
	/**
	 * 初始化窗口
	 */
	public void launchframe() {
		this.setTitle("飞机大战");
		this.setVisible(true);
		this.setLocation(100, 100);
		this.setSize(800,800);
		
		this.addWindowListener(new WindowAdapter() {
			public void windClosing(WindowEvent e){
				System.exit(0);
			}
		});
		new PaintTread().start();
	}
	public static void main(String[] args) {
		PlaneGame planeGame = new PlaneGame();
		planeGame.launchframe();
	}
}
