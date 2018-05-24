package puzzleClassifier;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Image {

	BufferedImage img = null;
	File file  = null;
	
	/**
	 * properties of input images
	 */
	public Image(String imgPath) {
		file = new File(imgPath);
		//load image file
		try {
			img = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		img.getClass();
		try {
			file = new File("IMG_piesNew.jpg");
			ImageIO.write(img, "jpg", file);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
