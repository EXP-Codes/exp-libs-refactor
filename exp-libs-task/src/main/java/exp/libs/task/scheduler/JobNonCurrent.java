package exp.libs.task.scheduler;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * <PRE>
 * 禁止并发执行的任务接口.
 * ---------------------------
 * 注：原接口 org.quartz.Job 默认是允许并发执行的.
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
@DisallowConcurrentExecution	// 声明此任务接口不允许并发执行
public interface JobNonCurrent extends Job {

	/**
	 * <PRE>
	 * 业务逻辑实现接口.
	 * -----------------
	 *  需注意此接口不允许抛出任何非JobExecutionException的异常, 连RuntimeException也不行.
	 *  因此在实现时需注意把代码try catch起来.
	 * </PRE>
	 */
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException;
	
}
