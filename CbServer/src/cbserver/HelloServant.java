package cbserver;

import org.omg.CORBA.ORB;

import HelloApp.HelloPOA;

public class HelloServant extends HelloPOA {

	private ORB orb;
	
	@Override
	public String msg() {
		return "HELLO APP UP AND RUNNING";
	}

	@Override
	public void msg(String newMsg) {
	}

	public void setOrb(ORB orb) {
		this.orb = orb;
	}
}
