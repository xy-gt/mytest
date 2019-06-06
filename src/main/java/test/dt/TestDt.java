package test.dt;
//���Զ�̬
public class TestDt {

	public static void main(String[] args) {
		Test test = new Test1();
	    Test1 test1 = (Test1)test;

	    
	}

}

class Test{
	public String a = "a";
}

class Test1 extends Test {
	public String str = "s";
}
