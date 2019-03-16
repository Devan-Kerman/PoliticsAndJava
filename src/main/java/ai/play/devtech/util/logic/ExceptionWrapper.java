package ai.play.devtech.util.logic;

import ai.play.devtech.core.api.interfaces.EProducer;
import ai.play.devtech.core.api.interfaces.ERunnable;

public class ExceptionWrapper<A> {
	private EProducer<A> fi;
	private ERunnable r;
	public ExceptionWrapper(ERunnable r) {
		this.r = r;
	}
	public ExceptionWrapper(EProducer<A> fi) {
		this.fi = fi;
	}
	
	public A run() {
		try {
			if(fi != null)
				return fi.run();
			if(r!=null)
				r.run();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
