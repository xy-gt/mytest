package test.testLock;

public class Produce {
	public static void main(String[] args) {
		SyncStack ss = new SyncStack();
		Producers produce = new Producers(ss);
		Consumer consumer = new Consumer(ss);
		new Thread(produce).start();
		new Thread(consumer).start();

	}
}

class WOTo {
	int id;

	public WOTo(int id) {
		this.id = id;
	}

	public String toString() {
		return "woto:" + id;
	}
}

class SyncStack {
	int index = 0;
	WOTo[] arrWT = new WOTo[6];

	public synchronized void push(WOTo wt) {
		while (index == arrWT.length) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		this.notify();
		arrWT[index] = wt;
		index++;
	}

	public synchronized WOTo pop() {
		while (index == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.notify();
		index--;
		return arrWT[index];
	}
}

class Producers implements Runnable {
	SyncStack ss = null;

	Producers(SyncStack ss) {
		this.ss = ss;
	}

	public void run() {
		for (int i = 0; i < 20; i++) {
			WOTo wt = new WOTo(i);
			ss.push(wt);
			System.out.println("生产了：" + wt);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable {
	SyncStack ss = null;

	Consumer(SyncStack ss) {
		this.ss = ss;
	}

	public void run() {
		for (int i = 0; i < 20; i++) {
			WOTo wt = ss.pop();
			System.err.println("消费了：" + wt);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}