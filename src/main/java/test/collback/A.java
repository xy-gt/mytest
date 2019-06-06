package test.collback;

public  class A {
  public static void test() {
	  System.out.println("��̬����");
  }
  public  void test1() {
	  System.out.println("�Ǿ�̬����");
  }
  public static void main(String[] args) {
	  A a = new B();
	  a.test1();
 }
}

class B extends A {
	public  void test1() {
		  System.out.println("�Ǿ�̬����B");
	  }
	public static void test() {
		  System.out.println("��̬����B");
	  }
}
