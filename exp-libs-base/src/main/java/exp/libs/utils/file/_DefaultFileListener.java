package exp.libs.utils.file;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;

/**
 * <PRE>
 * 文件监控器的默认事件监听器
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
class _DefaultFileListener implements FileAlterationListener {

	@Override
	public void onStart(FileAlterationObserver observer) {
		System.out.println("onStart");	// 每次扫描开始时均会触发
	}

	@Override
	public void onDirectoryCreate(File directory) {
		System.out.println("onDirectoryCreate : ".concat(directory.getName()));
	}

	@Override
	public void onDirectoryChange(File directory) {
		System.out.println("onDirectoryChange : ".concat(directory.getName()));
	}

	@Override
	public void onDirectoryDelete(File directory) {
		System.out.println("onDirectoryDelete : ".concat(directory.getName()));
	}

	@Override
	public void onFileCreate(File file) {
		System.out.println("onFileCreate : ".concat(file.getName()));
	}

	@Override
	public void onFileChange(File file) {
		System.out.println("onFileChange : ".concat(file.getName()));
	}

	@Override
	public void onFileDelete(File file) {
		System.out.println("onFileDelete : ".concat(file.getName()));
	}

	@Override
	public void onStop(FileAlterationObserver observer) {
		System.out.println("onStop");	// 每次扫描结束时均会触发
	}

}
