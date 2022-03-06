package exp.libs.struct.state;

import exp.libs.struct.state.impl.Stop;
import exp.libs.struct.state.impl.Created;
import exp.libs.struct.state.impl.Running;
import exp.libs.struct.state.impl.Sleep;

/**
 * <PRE>
 * 状态模式 - 状态机
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="https://exp-blog.com" target="_blank"https://exp-blog.com/a>
 * @version   2022-03-06
 * @author    EXP: exp.lqb@foxmail.com
 * @since     JDK 1.8+
 */
public class StateMachine {

	private final Created createdState;
	
	private final Running runState;
	
	private final Sleep sleepState;
	
	private final Stop stopState;
	
	protected IState state;
	
	protected StateMachine() {
		this.createdState = new Created(this);
		this.runState = new Running(this);
		this.sleepState = new Sleep(this);
		this.stopState = new Stop(this);
		
		this.state = createdState;
	}
	
	public final void setState(IState state) {
		this.state = state;
	}
	
	public final IState getState() {
		return state;
	}

	public final Created getCreatedState() {
		return createdState;
	}

	public final Running getRunState() {
		return runState;
	}

	public final Sleep getSleepState() {
		return sleepState;
	}

	public final Stop getStopState() {
		return stopState;
	}
	
}
