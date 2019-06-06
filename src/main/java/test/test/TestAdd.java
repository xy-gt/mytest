package test.test;

public class TestAdd {
	
	public static void main(String[] args) {
		byte a = 16;
		int b = 22;
		//a+=b;
		a = (byte) (a + (byte)b);
		System.out.println(a);
		System.out.println(b);
	}

}
