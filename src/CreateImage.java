import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class CreateImage {

	static BufferedImage stegoImage1 = new BufferedImage(256, 256,
			BufferedImage.TYPE_INT_RGB);

	public static void main(String[] args) {
		int ctr = 0;

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

		Scanner sc = new Scanner(System.in);
		int[] blockPosition = new int[32];
		int blocknumber = 32;

		for (int i = 0; i < blocknumber; i++) {
			System.out.print("Input a integer number: ");
			blockPosition[i] = sc.nextInt();
		}
		Arrays.sort(blockPosition);
		for (int i = 0; i < blocknumber; i++) {
			System.out.print(blockPosition[i] + " ");
		}

		Draw(stegoImage1, blockPosition);

		try {
			File ls = new File("SubImg24Position.png");
			ImageIO.write(stegoImage1, "png", ls);
			stegoImage1.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("After Image OK.");
	}

	private static void Draw(BufferedImage img, int[] t) {

		int x = 0;
		int y = 0;
		int i = 0;
		int j = 0;

		for (int p = 0; p < t.length; p++) {
			y = 32 * (t[p] % 8);
			if (0 <= t[p] && t[p] <= 7) {
				x = 0;
			} else if (8 <= t[p] && t[p] <= 15) {
				x = 32;
			} else if (16 <= t[p] && t[p] <= 23) {
				x = 64;
			} else if (24 <= t[p] && t[p] <= 31) {
				x = 96;
			} else if (32 <= t[p] && t[p] <= 39) {
				x = 128;
			} else if (40 <= t[p] && t[p] <= 47) {
				x = 160;
			} else if (48 <= t[p] && t[p] <= 55) {
				x = 192;
			} else if (56 <= t[p] && t[p] <= 63) {
				x = 224;
			}
			for (i = 0; i < 32; i++) {
				for (j = y; j < y + 32; j++) {
					img.setRGB(j, x, (0xff000000 | (255 << 16) | (255 << 8 | 255)));

				}
				x++;
			}
		}
		

		System.out.println("Draw OK! ");
	}
}
