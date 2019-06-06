package test.collback;
//测试回调
public class Main {
	public static void main(String[] args) {
		People people = new People();
		Callback callback = new Callback() {
			@Override
			public void printFinished(String msg) {
				System.out.println("打印机告诉我的消息是 ---> " + msg);
			}

			@Override
			public void printFinished2(String msg) {
				System.out.println("回调消息是2 --->"+ msg);
				
			}

			@Override
			public void printFinished3(String msg) {
				System.out.println("回调消息是3 --->"+ msg);
				
			}
		};
		System.out.println("需要打印的内容是 ---> " + "打印一份简历");
		people.goToPrintSyn(callback, "打印一份简历");
	}
}

class People {

	Printer printer = new Printer();

	/*
	 * 同步回调
	 */
	public void goToPrintSyn(Callback callback, String text) {
		printer.print(callback, text);
	}

	/*
	 * 异步回调
	 */
	public void goToPrintASyn(Callback callback, String text) {
		new Thread(new Runnable() {
			public void run() {
				printer.print(callback, text);
			}
		}).start();
	}
}

class Printer {
	public void print(Callback callback, String text) {
		System.out.println("正在打印 . . . ");
		try {
			Thread.currentThread();
			Thread.sleep(3000);// 毫秒
		} catch (Exception e) {
		}
		callback.printFinished2("打印完成");
	}
}
