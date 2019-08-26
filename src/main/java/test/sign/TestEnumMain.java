package test.sign;

/**
 * 枚举实现的单例，就是用枚举替换类（枚举本身也是类）
 */
public class TestEnumMain {

	public static void main(String[] args) {
	   TestEnumSign.INSTANCE.t1();
	   TestEnumSign.INSTANCE.t1();


	  TestEnumSign testEnumSign = TestEnumSign.INSTANCE;
	  TestEnumSign testEnumSign2 = TestEnumSign.INSTANCE;

	  System.out.println(testEnumSign2 == testEnumSign);

	}

}
