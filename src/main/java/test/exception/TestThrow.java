package test.exception;

public class TestThrow {

	public static void main(String[] args) {

       try {
		new ThrowCalss().test();
		System.out.println("~~~~~~~~~~~~~~");
	} catch (Exception e) {
		System.out.println("****************8");
	}
		
	}

}

class ThrowCalss {
	
	public void test() {
		try {
			throw new RuntimeException("手动抛出异常");
		} catch (RuntimeException e) {
           System.out.println("----------------");
		}
	}
	
}