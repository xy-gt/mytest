package test.testLock;

public class Lock{
	private boolean isLocked = false;
	public static void main(String[] args) throws InterruptedException {
       new Count().print();
	}
    public synchronized void lock() throws InterruptedException{
        while(isLocked){    
            wait();
        }
        isLocked = true;
    }
    public synchronized void unlock(){
        isLocked = false;
        notify();
    }
}

class Count{
   Lock lock = new Lock();
   public void print() throws InterruptedException{
       System.err.println("print");
       lock.lock();
       doAdd();
       lock.unlock();
   }
   public void doAdd() throws InterruptedException{
       lock.lock();
       //do something
       System.err.println("add");
       lock.unlock();
   }
}
 
 