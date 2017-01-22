package in.beingzero.img;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageComparison {

	public boolean bufferedImagesEqual(BufferedImage img1, BufferedImage img2) {
	    if (img1.getWidth() == img2.getWidth() && img1.getHeight() == img2.getHeight()) {
	        for (int x = 0; x < img1.getWidth(); x++) {
	            for (int y = 0; y < img1.getHeight(); y++) {
	                if (img1.getRGB(x, y) != img2.getRGB(x, y))
	                    return false;
	            }
	        }
	    } else {
	        return false;
	    }
	    return true;
	}
	
	public boolean imgCompare(String uploadedFilePath, String downloadedFilePath) throws IOException{
	
		File f1 = new File(uploadedFilePath);
		BufferedImage first = ImageIO.read(f1);
		
		File f2 = new File(downloadedFilePath);
		BufferedImage second = ImageIO.read(f2);
		
		return bufferedImagesEqual(first, second);
	}
	
}
