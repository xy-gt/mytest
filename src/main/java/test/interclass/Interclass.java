package test.interclass;
//�����ڲ���
public class Interclass {

	public static void main(String[] args) {
	  new Test1.Test2();
	}

}

class Test1{
	
	
	private String s = "asd";
    static class Test2{
    	public String s1 = "asd1";
    	public Integer i1 = 1;
    	
    }
	
	
}
