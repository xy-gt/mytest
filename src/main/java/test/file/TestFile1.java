package test.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFile1 {

	public static void main(String[] args) throws IOException {

		System.out.println("偏移量------------------------------------------------------------");
		String s = "1234567890asdfghjkl";
		byte[] b = s.getBytes();
		File file = new File("D:\\work\\ideawork\\my_test\\src\\main\\java\\test\\file\\a.abc");
		try {
			FileOutputStream out = new FileOutputStream(file);
			out.write("sssssssss".getBytes());
			out.write(b, 0, 2);
			out.write(b,8,10);
			out.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("文件复制------------------------------------------------------------");
		/*
		 * File file = new File("E:2.jpg"); FileInputStream in = new
		 * FileInputStream(file); BufferedInputStream ins = new BufferedInputStream(in);
		 * FileOutputStream out = new FileOutputStream(new File("E:21.jpg"));
		 * BufferedOutputStream outs = new BufferedOutputStream(out); long start =
		 * System.currentTimeMillis(); byte[] s = new byte[10]; int i = 0; int j = 0;
		 * while ((j = ins.read(s)) != -1) { outs.write(s); i++; } out.flush();
		 * in.close(); out.close(); long end = System.currentTimeMillis();
		 * System.out.println(end - start); System.out.println(i + "��");
		 */

	/*	System.out.println("临时文件------------------------------------------------------------");
	 
		String pathTemp = "D:\\work\\eclipsework\\test\\src\\test\\file";
		File fileTemp = File.createTempFile("aws", ".temp",new File(pathTemp));
		
		//fileTemp.createNewFile();
		try {
			Thread.sleep(10000);
			
			fileTemp.deleteOnExit(); // 令临时文件在JVM关闭的时候自动删除
			//fileTemp.delete(); // 立刻删除临时文件
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
