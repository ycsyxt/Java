package Plane;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class PlaneImage {
	private PlaneImage(){
		
	}
	public static Image getImage(String path) {
		BufferedImage bImage = null;
		URL url = PlaneImage.class.getClassLoader().getResource(path);
		try {
			bImage = ImageIO.read(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bImage;
	}
}
