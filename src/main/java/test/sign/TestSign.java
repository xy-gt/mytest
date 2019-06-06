package test.sign;

 class Sign {
	static class SignFactory{
		private static Sign sign = new Sign();
		
	}

	public static Sign getSign() {
		return SignFactory.sign;
		
	}
}

class TestSign {
	public static void main(String[] args) {
	  new A().a();
	}
}

class A {
	public void a() {
		Sign s1 = Sign.getSign();
		Sign s2 = Sign.getSign();
		
		System.out.println(s1==s2);
	}
}