package res;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ArtLoader {
	
	BufferedImage art;
	public ArtLoader() {
		initArt();
	}
	public void initArt() {
		
	}
	
	public BufferedImage getImageFromPNG(String filepath) {
		try {
			return ImageIO.read(ArtLoader.class.getResourceAsStream(filepath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
