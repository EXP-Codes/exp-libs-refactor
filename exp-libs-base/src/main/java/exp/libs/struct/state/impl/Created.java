package exp.libs.struct.state.impl;

import exp.libs.struct.state.IState;
import exp.libs.struct.state.StateMachine;

public class Created extends IState {

	public Created(StateMachine stateMachine) {
		super(stateMachine);
	}

	@Override
	public String getDes() {
		return "Created";
	}
	
	@Override
	public boolean _start() {
		stateMachine.setState(stateMachine.getRunState());
		return true;
	}

	@Override
	public boolean _pause() {
		System.out.println("StateMachine Illegal Operation : Created -> pause()");
		return false;
	}

	@Override
	public boolean _resume() {
		System.out.println("StateMachine Illegal Operation : Created -> resume()");
		return false;
	}

	@Override
	public boolean _stop() {
		stateMachine.setState(stateMachine.getStopState());
		return true;
	}

	@Override
	public String toString() {
		return "StateMachine State : Created.";
	}

}
