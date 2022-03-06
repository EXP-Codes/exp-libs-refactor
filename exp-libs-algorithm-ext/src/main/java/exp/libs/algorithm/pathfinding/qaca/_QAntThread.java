package exp.libs.algorithm.pathfinding.qaca;

import java.util.concurrent.Callable;

/**
 * <PRE>
 * 量子蚂蚁行为执行线程
 * </PRE>
 * 
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a> 
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
final class _QAntThread implements Callable<QRst> {

	private final _QAnt qAnt;

	private final QRst bestRst;

	protected _QAntThread(final _QAnt qAnt, final QRst bestRst) {
		this.qAnt = qAnt;
		this.bestRst = bestRst;
	}

	@Override
	public QRst call() throws Exception {
		qAnt.solve(bestRst);
		return qAnt.getResult();
	}
	
}
