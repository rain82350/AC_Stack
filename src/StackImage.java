import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class StackImage {

	private BufferedImage image, image2, image3, image4;
	private int height, height2, height3, height4;
	private int width, width2, width3, width4;
	private Raster tmpRas = null;
	ArrayList<Integer> pixelArrList = new ArrayList<Integer>();
	ArrayList<Integer> pixelArrList1 = new ArrayList<Integer>();
	ArrayList<Integer> pixelArrList2 = new ArrayList<Integer>();
	ArrayList<Integer> pixelArrList3 = new ArrayList<Integer>();
	ArrayList<Integer> pixelArrList4 = new ArrayList<Integer>();
	ArrayList<Integer> waterValue = new ArrayList<Integer>();
	ArrayList<Integer> checkValue = new ArrayList<Integer>();
	ArrayList<Integer> stack24Value = new ArrayList<Integer>();
	private BufferedWriter fw = null;
	private BufferedWriter fw2 = null;

	// input 2 subimages
	StackImage(File imageFile, File imageFile2) {
		try {
			this.image = ImageIO.read(imageFile);
			tmpRas = this.image.getData();
			this.height = this.image.getHeight();
			this.width = this.image.getWidth();
			// this.arr2ArrList();
			this.image2 = ImageIO.read(imageFile2);
			tmpRas = this.image2.getData();
			this.height2 = this.image2.getHeight();
			this.width2 = this.image2.getWidth();

			stack2Subimage();
			// getGrayPixel();
			// getGrayPixel2();

		} catch (IOException e) {
			System.out.println(" Cannot find the file! ");
			e.printStackTrace();
		}
	}

	// input 3 subimages
	StackImage(File imageFile, File imageFile2, File imageFile3) {
		try {
			this.image = ImageIO.read(imageFile);
			tmpRas = this.image.getData();
			this.height = this.image.getHeight();
			this.width = this.image.getWidth();
			// this.arr2ArrList();
			this.image2 = ImageIO.read(imageFile2);
			tmpRas = this.image2.getData();
			this.height2 = this.image2.getHeight();
			this.width2 = this.image2.getWidth();

			this.image3 = ImageIO.read(imageFile3);
			tmpRas = this.image3.getData();
			this.height3 = this.image3.getHeight();
			this.width3 = this.image3.getWidth();

			stack3Subimage();

		} catch (IOException e) {
			System.out.println(" Cannot find the file! ");
			e.printStackTrace();
		}
	}

	// input 4 subimages
	StackImage(File imageFile, File imageFile2, File imageFile3, File imageFile4) {
		try {
			this.image = ImageIO.read(imageFile);
			tmpRas = this.image.getData();
			this.height = this.image.getHeight();
			this.width = this.image.getWidth();
			// this.arr2ArrList();
			this.image2 = ImageIO.read(imageFile2);
			tmpRas = this.image2.getData();
			this.height2 = this.image2.getHeight();
			this.width2 = this.image2.getWidth();
			this.image3 = ImageIO.read(imageFile3);
			tmpRas = this.image3.getData();
			this.height3 = this.image3.getHeight();
			this.width3 = this.image3.getWidth();
			this.image4 = ImageIO.read(imageFile4);
			tmpRas = this.image4.getData();
			this.height4 = this.image4.getHeight();
			this.width4 = this.image4.getWidth();

			stack4Subimage();

		} catch (IOException e) {
			System.out.println(" Cannot find the file! ");
			e.printStackTrace();
		}
	}

	public ArrayList<Integer> getGrayPixel() {

		tmpRas = this.image.getData();
		int x, y;
		int[][] pixel_1 = new int[height][width];
		File file = new File("StegoImage1Test.txt");

		for (x = 0; x < height; x++) {
			for (y = 0; y < width; y++) {

				pixel_1[x][y] = tmpRas.getSample(y, x, 0);
				this.pixelArrList1.add(pixel_1[x][y]);

				// System.out.printf( pixel_1[x][y] + "  ");
				// try {
				// String charSp = Integer.toString(pixel_1[x][y]);
				// fw = new BufferedWriter(new OutputStreamWriter(
				// new FileOutputStream(file, true), "UTF-8"));
				// fw.append(charSp);
				// fw.append(", ");
				// fw.flush();
				//
				// } catch (Exception e) {
				// e.printStackTrace();
				// }

			}
		}
		// if (fw != null) {
		// try {
		// fw.close();
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		System.out.println("PixelArrList1 has been produced ! ");
		// System.out.println("PixelArrList1 Size: " +
		// this.pixelArrList1.size());
		return this.pixelArrList1;

	}

	public ArrayList<Integer> getGrayPixel2() {

		tmpRas = this.image2.getData();
		int x, y;
		int[][] pixel_2 = new int[height][width];
		File file = new File("StegoImage2Test.txt");

		for (x = 0; x < height; x++) {
			for (y = 0; y < width; y++) {

				pixel_2[x][y] = tmpRas.getSample(y, x, 0);
				this.pixelArrList2.add(pixel_2[x][y]);

				// System.out.printf( pixel_2[x][y] + "  ");
				// try {
				// String charSp = Integer.toString(pixel_2[x][y]);
				// fw = new BufferedWriter(new OutputStreamWriter(
				// new FileOutputStream(file, true), "UTF-8"));
				// fw.append(charSp);
				// fw.append(", ");
				// fw.flush();
				//
				// } catch (Exception e) {
				// e.printStackTrace();
				// }

			}
		}
		// if (fw != null) {
		// try {
		// fw.close();
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		System.out.println("PixelArrList2 has been produced ! ");
		// System.out.println("PixelArrList2 Size: " +
		// this.pixelArrList2.size());
		return this.pixelArrList2;

	}

	public ArrayList<Integer> getGrayPixel3() {

		tmpRas = this.image3.getData();
		int x, y;
		int[][] pixel_3 = new int[height][width];
		File file = new File("StegoImage3Test.txt");

		for (x = 0; x < height; x++) {
			for (y = 0; y < width; y++) {

				pixel_3[x][y] = tmpRas.getSample(y, x, 0);
				this.pixelArrList3.add(pixel_3[x][y]);

				// System.out.printf(pixel_3[x][y] + "  ");
				// try {
				// String charSp = Integer.toString(pixel_3[x][y]);
				// fw = new BufferedWriter(new OutputStreamWriter(
				// new FileOutputStream(file, true), "UTF-8"));
				// fw.append(charSp);
				// fw.append(", ");
				// fw.flush();
				//
				// } catch (Exception e) {
				// e.printStackTrace();
				// }

			}
		}
		// if (fw != null) {
		// try {
		// fw.close();
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		System.out.println("PixelArrList3 has been produced ! ");
		// System.out.println("PixelArrList3 Size: " +
		// this.pixelArrList3.size());
		return this.pixelArrList3;
	}

	public ArrayList<Integer> getGrayPixel4(int i, int j) {

		tmpRas = this.image4.getData();
		int x, y;
		int[][] pixel_4 = new int[height][width];
		File file = new File("StegoImage4Test.txt");

		for (x = 0; x < height; x++) {
			for (y = 0; y < width; y++) {

				pixel_4[x][y] = tmpRas.getSample(y, x, 0);
				this.pixelArrList.add(pixel_4[x][y]);

				// System.out.printf(pixel_4[x][y] + "  ");
				// try {
				// String charSp = Integer.toString(pixel_4[x][y]);
				// fw = new BufferedWriter(new OutputStreamWriter(
				// new FileOutputStream(file, true), "UTF-8"));
				// fw.append(charSp);
				// fw.append(", ");
				// fw.flush();
				//
				// } catch (Exception e) {
				// e.printStackTrace();
				// }

			}
		}
		// if (fw != null) {
		// try {
		// fw.close();
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		System.out.println("PixelArrList4 has been produced ! ");
		// System.out.println("PixelArrList4 Size: " +
		// this.pixelArrList4.size());
		return this.pixelArrList4;
	}

	public void stack2Subimage() {

		int[] b1 = new int[10];
		int[] b2 = new int[10];
		String[] b1_str = new String[10];
		String[] b2_str = new String[10];
		String waterV1 = "";
		String waterV2 = "";
		ArrayList<Integer> waterValue1 = new ArrayList<Integer>();
		ArrayList<Integer> waterValue2 = new ArrayList<Integer>();
		int count = 0;
		int b = 1;
		int i = 0;
		int ii = 0;

		File file1 = new File("waterV_1.txt");
		File file2 = new File("waterV_2.txt");

		this.getGrayPixel();
		this.getGrayPixel2();
		while (count < (163840 - 1)) {
			waterV1 = "";
			waterV2 = "";
			for (i = 0; i < 10; i++) {
				b1[i] = this.pixelArrList1.get(count);
				b2[i] = this.pixelArrList2.get(count);
				b1_str[i] = Integer.toBinaryString(b1[i]);
				b2_str[i] = Integer.toBinaryString(b2[i]);

				if (b1_str[i].length() < 8 || b2_str[i].length() < 8) {
					while (b1_str[i].length() < 8) {
						StringBuffer sb = new StringBuffer();
						sb.append("0").append(b1_str[i]);// ¥ª¸É0
						b1_str[i] = sb.toString();
					}
					while (b2_str[i].length() < 8) {
						StringBuffer sb = new StringBuffer();
						sb.append("0").append(b2_str[i]);// ¥ª¸É0
						b2_str[i] = sb.toString();
					}
				}
				// System.out.println("ArrList1TempV" + i + " : " + b1[i]);
				// System.out.println("ArrList2TempV" + i + " : " + b2[i]);
				// System.out.println("ArrList1TempSTR" + i + " : " +
				// b1_str[i]);
				// System.out.println("ArrList2TempSTR" + i + " : " +
				// b2_str[i]);
				if (i < 8) {
					waterV1 = waterV1.concat(b1_str[i].charAt(7) + "");
					waterV2 = waterV2.concat(b2_str[i].charAt(7) + "");
					// System.out.println("WaterVale1: " + waterV1);
					// System.out.println("WaterVale2: " + waterV2);
				}
				count++;
			}
			// System.out.println("WaterDEC1: " + Integer.valueOf(waterV1, 2));
			// System.out.println("WaterDEC2: " + Integer.valueOf(waterV2, 2));
			waterValue1.add(Integer.valueOf(waterV1, 2));
			waterValue2.add(Integer.valueOf(waterV2, 2));
			// try {
			// String charSp = Integer.toString(waterValue2.get(ii));
			// fw = new BufferedWriter(new OutputStreamWriter(
			// new FileOutputStream(file2, true), "UTF-8"));
			// fw.append(charSp);
			// fw.append(", ");
			// fw.flush();
			//
			//
			//
			// } catch (Exception e) {
			// e.printStackTrace();
			// }
			// ii++;

			// System.out.println("Round " + b + " OK!");
			// b++;
			// count = count + 10;
		}
		// if (fw != null) {
		// try {
		// fw.close();
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		System.out.println("WaterV1ArrList Size: " + waterValue1.size());
		System.out.println("WaterV1ArrList Size: " + waterValue2.size());
		// Lagrange method

		int x = 0;
		int sub1V = 0;
		int m = 251;
		int count2 = 0;
		File file3 = new File("stack24Value.txt");
		String subValue1 = "";
		Polynomial p1 = new Polynomial(1, 1);
		Polynomial c = new Polynomial(-1, 0); // -1
		Polynomial cc = new Polynomial(-2, 0); // -2
		String[] s = new String[2];
		int[] t = new int[2];

		while (count2 < 16384) {

			Polynomial c2 = new Polynomial(waterValue1.get(count2), 0);
			Polynomial c3 = new Polynomial(waterValue2.get(count2), 0);
			Polynomial p2 = ((p1.plus(cc)).times(c)).times(c2);
			Polynomial p3 = p1.plus(c).times(c3);
			Polynomial p4 = p2.plus(p3);

			// System.out.println("P4(x): "+p4);
			subValue1 = p4.toString();
			s = Crop(subValue1);
			// System.out.println("Test subValue: " + subValue1);
			// System.out.println("subValue1: " + s[1]);
			// System.out.println("subValue2: " + s[0]);

			if (Integer.parseInt(s[1].trim()) > m) {
				t[0] = Integer.parseInt(s[1].trim()) % m;
			} else if (Integer.parseInt(s[1].trim()) < 0) {
				t[0] = Integer.parseInt(s[1].trim()) + m;
			} else if (0 <= Integer.parseInt(s[1].trim())
					&& Integer.parseInt(s[0].trim()) < m) {
				t[0] = Integer.parseInt(s[1].trim());
			}
			// System.out.println("Integer1: " + t[0]);

			if (Integer.parseInt(s[0].trim()) > m) {
				t[1] = Integer.parseInt(s[0].trim()) % m;
			} else if (Integer.parseInt(s[0].trim()) < 0) {
				t[1] = Integer.parseInt(s[0].trim()) + m;
			} else if (0 <= Integer.parseInt(s[0].trim())
					&& Integer.parseInt(s[0].trim()) < m) {
				t[1] = Integer.parseInt(s[0].trim());
			}
			// System.out.println("Integer2: " + t[1]);
			this.stack24Value.add(t[0]);
			this.stack24Value.add(t[1]);
			count2++;
			ii++;
		}

		for (x = 0; x < this.stack24Value.size(); x++) {
			System.out.print(this.stack24Value.get(x) + " ");
			try {
				String charSp = Integer.toString(stack24Value.get(x));
				fw = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream(file3, true), "UTF-8"));
				fw.append(charSp);
				fw.append(", ");
				fw.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		System.out.println(" Stack Value has been produced ! ");
		if (fw != null) {
			try {
				fw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void stack3Subimage() {

	}

	public void stack4Subimage() {

	}

	public static String[] Crop(String f) {
		char sign = 0;
		String str = "";
		String[] s = new String[2];
		int j = 0;
		for (int i = 0; i < f.length(); i++) {

			if (f.charAt(i) == '-') {
				sign = '-';
			}
			if (Character.isDigit(f.charAt(i))) {
				str += f.charAt(i);
			}
			if (f.charAt(i) == 'x' || i == (f.length() - 1)) {
				// System.out.println(" C : "+sign+str);
				s[j] = sign + str;
				sign = 0;
				str = "";
				j++;
			}
		}
		return s;
	}

}
