package exp.libs.struct.queue.sc;

/**
 * <PRE>
 * 流式并发队列元素
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank"https://exp-blog.com/a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public abstract class SCQBean<E> implements Runnable {

	private boolean isDone;
	
	private E e;
	
	private byte[] lock;
	
	public SCQBean(E e) {
		this.isDone = false;
		this.e = e;
		this.lock = new byte[1];
	}
	
	@Override
	public void run() {
		handle(e);
		
		synchronized (lock) {
			isDone = true;
		}
	}
	
	protected abstract void handle(E e);

	public boolean isDone() {
		if(isDone == true) {
			return true;
			
		} else {
			synchronized (lock) {
				return isDone;
			}
		}
	}

	public E getBean() {
		return e;
	}
	
}
