package exp.libs.ui.cpt.win;


/**
 * <PRE>
 * swing弹出式子窗口
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
@SuppressWarnings("serial")
public abstract class PopChildWindow extends _SwingWindow {

	protected PopChildWindow() {
		super("PopChildWindow");
	}
	
	protected PopChildWindow(String name) {
		super(name);
	}
	
	protected PopChildWindow(String name, int width, int height) {
		super(name, width, height);
	}
	
	protected PopChildWindow(String name, int width, int height, boolean relative) {
		super(name, width, height, relative);
	}
	
	protected PopChildWindow(String name, int width, int height, boolean relative, Object... args) {
		super(name, width, height, relative, args);
	}
	
	@Override
	protected final boolean isMainWindow() {
		return false;
	}
	
	@Deprecated
	@Override
	protected final void beforeExit() {
		// Undo
	}
	
}
