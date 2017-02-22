import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CreateImage {

	static BufferedImage stegoImage1 = new BufferedImage(256, 256,
			BufferedImage.TYPE_INT_RGB);

	public static void main(String[] args) {
		int ctr = 0;
		// int[] stegoPixel1 = new int[256 * 256];

		for (int i = 0; i < 64; i++) {
			for (int j = 0; j < 64; j++) {

				stegoImage1.setRGB(j, i,
						(0xff000000 | (0 << 16) | (0 << 8 | 0)));

			}

		}

		try {
			File ls = new File("SubImgTest.png");
			ImageIO.write(stegoImage1, "png", ls);
			stegoImage1.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Origin Image OK.");

		Draw(stegoImage1, 56);

		try {
			File ls = new File("SubImgTestAfter.png");
			ImageIO.write(stegoImage1, "png", ls);
			stegoImage1.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("After Image OK.");
	}

	private static void Draw(BufferedImage img, int t) {

		int x = 0;
		int y = 0;
		int i = 0;
		int j = 0;

//		y = j + 32 * t;
		y = 32 * (t%8);
		if (0 <= t && t <= 7) {
			x = 0;
		} else if (8 <= t && t <= 15) {
			x = 32;
		} else if (16 <= t && t <= 23) {
			x = 64;
		} else if (24 <= t && t <= 31) {
			x = 96;
		} else if (32 <= t && t <= 39) {
			x = 128;
		} else if (40 <= t && t <= 47) {
			x = 160;
		} else if (48 <= t && t <= 55) {
			x = 192;
		} else if (56 <= t && t <= 63) {
			x = 224;
		}
		
		for (i = 0; i < 32; i++) {
			for (j = y; j < y+32; j++) {
				img.setRGB(j, x, (0xff000000 | (255 << 16) | (255 << 8 | 255)));
				
//				if (i == 31) {
//					y++;
//				}
			}
			x ++;
		}

		System.out.println("Draw OK! ");
	}
}
