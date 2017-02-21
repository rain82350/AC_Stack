import java.io.File;


public class StackingMain {

	static File subImage1 = new File("StegoImage1.png");
	static File subImage2 = new File("StegoImage2.png");
	static File subImage3 = new File("StegoImage3.png");
	static File subImage4 = new File("StegoImage4.png");
	
	public static void main(String[] args) {
		
		StackImage stacktest = new StackImage(subImage1, subImage2);
		
	}

}
