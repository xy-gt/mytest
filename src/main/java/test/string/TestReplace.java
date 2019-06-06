package test.string;

public class TestReplace {

	public static void main(String[] args) {
		String str = "00001203900434343000000"; 
		String newStr = str.replaceAll("^(0+)", "*"); 
		System.out.println(newStr);
		
		
		System.out.println("___________________________");
		String str2 = "0000120003090988000"; 
		String newStr2 = str2.replaceFirst("^0*", "*"); 
		System.out.println(newStr2);
	}

}
