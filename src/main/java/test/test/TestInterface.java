package test.test;

public interface TestInterface {
	
	public default String testInterface() {
		System.out.println("sssssss");
		return "接口方法";
	}

}
