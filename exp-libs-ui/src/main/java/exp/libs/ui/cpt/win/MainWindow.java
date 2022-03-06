package exp.libs.ui.cpt.win;


/**
 * <PRE>
 * swing主窗口
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a> 
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
@SuppressWarnings("serial")
public abstract class MainWindow extends _SwingWindow {

	protected MainWindow() {
		super("MainWindow");
	}
	
	protected MainWindow(String name) {
		super(name);
	}
	
	protected MainWindow(String name, int width, int height) {
		super(name, width, height);
	}
	
	protected MainWindow(String name, int width, int height, boolean relative) {
		super(name, width, height, relative);
	}
	
	protected MainWindow(String name, int width, int height, boolean relative, Object... args) {
		super(name, width, height, relative, args);
	}
	
	@Override
	protected final boolean isMainWindow() {
		return true;
	}
	
}
