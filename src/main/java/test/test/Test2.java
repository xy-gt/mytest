package test.test;

//����try cash finally ������return �����
public class Test2 implements TestInterface {

	public static void main(String[] args) {
		System.out.println(test());
		new A().test1();
		

	}
    public static String test() {
    	
    	try {
    		throw new RuntimeException();
    		//return "1";
    	} catch(Exception e) {
    		return "2";
    	} finally {
    		return "3";
    	}
    }
}

class A implements TestInterface {
	
	void test1() {
	   System.out.println(testInterface());	
	}
	
}
