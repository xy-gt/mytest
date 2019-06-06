package test.templet;

public class Enter {

	public static void main(String[] args) {
		System.out.println("����ģ�巽��ģʽ");
		new Son().tests();

	}

}

class Son extends Person{
   public void tests() {
     System.out.println("ģ�巽��ģʽ�������");
     test();
   }

   @Override
   public void test2() {
     System.out.println("ģ�巽��ģʽ����ʵ��");

   }

}
