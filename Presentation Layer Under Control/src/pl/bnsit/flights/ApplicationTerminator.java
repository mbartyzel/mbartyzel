package pl.bnsit.flights;


import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;

//This class run before termination and releases all resources the application has acquired. 
public class ApplicationTerminator {
	
	@Subscribe
	public void releaseResources(TerminationRequested event) {
		System.exit(0);
	}
	
	@Subscribe
	public void handleDeadEvents( DeadEvent deadEvent ) {
		//logg it via logger
		System.out.println( "Unhandled event detected: " + deadEvent.getEvent()  );
	}
}
