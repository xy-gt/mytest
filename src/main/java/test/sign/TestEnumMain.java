package test.sign;

public class TestEnumMain {

	public static void main(String[] args) {
	   SignUser s1 = TestEnumSign.INSTANCE.getSign();
	   SignUser s2 = TestEnumSign.INSTANCE.getSign();
	   System.out.println(s1 == s2);
		
	   

	}

}
