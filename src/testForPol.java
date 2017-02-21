
public class testForPol {

	public static void main(String[] args) {
//		String polynomial= "-2x^1+3x^1+6";
//	    String[] parts = polynomial.split("x\\^\\d+\\+?");
//	    for (String part : parts) {
//	        System.out.println(part);
//	    }
//	    System.out.println(parts[0]);
		String p = "-57x + 194"; 
		
		String[] s = new String[2];
		s = Crop(p);
		System.out.println("S0: "+ s[0]);
		System.out.println("S1: "+ s[1]);
		
		
	}
	public static String[] Crop (String f){
		char sign = 0 ;
		String str = "";
		String[] s = new String[2];
		int j = 0;
		for (int i =0; i<f.length();i++){
			
			if(f.charAt(i)=='-'){
				sign = '-';
			}
			if (Character.isDigit(f.charAt(i))){
				str += f.charAt(i);
				
			
				
			}
			if(f.charAt(i)=='x'||i==(f.length()-1)){
				System.out.println(" C : "+sign+str);
				s[j]=sign+str;
				sign = 0;
				str= "";
				j++;
			}
			
		}
		return s;
	}

}
