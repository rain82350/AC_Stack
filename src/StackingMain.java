import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class StackingMain {

	// StegoImage
	static File subImage1 = new File("StegoImage1.png");
	static File subImage2 = new File("StegoImage2.png");
	static File subImage3 = new File("StegoImage3.png");
	static File subImage4 = new File("StegoImage4.png");
	// SubImage
	static File subImg24 = new File("SubImg24Position.png");

	static BufferedImage stack24Image = new BufferedImage(256, 256,
			BufferedImage.TYPE_INT_RGB);

	public static void main(String[] args) {

		ArrayList<Integer> waterValue24 = new ArrayList<Integer>();

//		StackImage stacktest = new StackImage(subImage1, subImage2);

//		waterValue24 = stacktest.getStack24Valu();

//		String imgName = "SubImg24Position.png";
//		int[][] pixel = new int[256][256];
//
//		Stack24(imgName, waterValue24);
//
//		try {
//			File ls = new File("SubImg1.png");
//			ImageIO.write(stack24Image, "png", ls);
//			stack24Image.flush();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println("SubImg1 OK.");
		
		StackImage stacktest2 = new StackImage(subImage1, subImage2, subImage3);

	}

	public static void Stack24(String Img,
			ArrayList<Integer> waterValue24) {

		BufferedImage img = null;
		Raster tmpRas = null;
		try {
			img = ImageIO.read(new File(Img));

			tmpRas = img.getData();

			System.out.println("Input OK! ");
		} catch (IOException e) {
			System.out.println(e.toString());
		}

		int height = img.getHeight();
		int width = img.getWidth();
		int[][] pixel = new int[height][width];
		int count = 0;
		
section:{
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					pixel[i][j] = tmpRas.getSample(j, i, 0);

					if (pixel[i][j] == 255) {

						stack24Image
								.setRGB(j,
										i,
										(0xff000000 | (waterValue24.get(count) << 16) | (waterValue24
												.get(count) << 8 | waterValue24
												.get(count))));
						count++;
						
					}
					
					if(count>=waterValue24.size()) break section;
					// System.out.printf( pixel[i][j] + "  ");
				}
				// System.out.println("");
			}
		}	
		
		System.out.println("WaterValue size: "+waterValue24.size());
		
	}
}
