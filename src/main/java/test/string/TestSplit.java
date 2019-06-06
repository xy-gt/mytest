package test.string;

public class TestSplit {

	public static void main(String[] args) {
          String str = "necoagent|single_box|06d624a6-5207-11e9-9c23-eb1ba72c39c1|02069af0-5207-11e9-9c1b-eb1ba72c39c1|1011|1011|1553852566|1553852574|0|0|0|8|0|||Waiting|11";
	
	     String[] strArr = str.split("\\|");
	     System.out.println(strArr.length);
	     for (int i = 0; i < strArr.length; i++) {
			String string = strArr[i];
			System.out.println(string);
			
		}
	}

}
	