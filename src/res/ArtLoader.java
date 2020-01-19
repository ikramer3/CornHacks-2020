package res;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ArtLoader {
	
	public static BufferedImage art,
		mainMenuBit,
		playerl1,
		playerl2,
		playerr1,
		playerr2;
	int imgD=64;
	
	public ArtLoader() {
		initArt();
	}
	public void initArt() {
		mainMenuBit=getImageFromPNG("MainMenuBit.jpg");
		art=getImageFromPNG("spriteSheet.png");
		playerl1=crop(0*imgD,0*imgD,imgD,imgD,art);
		playerl2=crop(0*imgD,1*imgD,imgD,imgD,art);
		playerr1=crop(1*imgD,0*imgD,imgD,imgD,art);
		playerr2=crop(1*imgD,1*imgD,imgD,imgD,art);
	}
	
	public BufferedImage crop(int x,int y,int w,int h,BufferedImage image) {
		return image.getSubimage(x, y, w, h);
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
