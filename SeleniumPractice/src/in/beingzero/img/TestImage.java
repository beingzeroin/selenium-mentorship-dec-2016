package in.beingzero.img;

import java.io.IOException;

public class TestImage {

	public static void main(String[] args) throws IOException {
		
		ImageComparison ic = new ImageComparison();
		boolean result = ic.imgCompare("/Users/sandeepkumar/Desktop/Bz_98_156.jpg", "/Users/sandeepkumar/Desktop/niki.png");
		System.out.println(result);
	}
	
}
