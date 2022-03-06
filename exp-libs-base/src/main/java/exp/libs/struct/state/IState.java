package exp.libs.struct.state;

/**
 * <PRE>
 * 状态接口.
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank">https://exp-blog.com</a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public abstract class IState {

	protected StateMachine stateMachine;
	
	public IState(StateMachine stateMachine) {
		this.stateMachine = stateMachine;
	}
	
	public abstract String getDes();
	
	public abstract boolean _start();
	
	public abstract boolean _pause();
	
	public abstract boolean _resume();
	
	public abstract boolean _stop();

}
