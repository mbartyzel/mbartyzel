package pl.bnsit.flights;

import com.google.common.eventbus.EventBus;

public class EventService {

	private EventBus eventBus = new EventBus( "main" );
	
	public void publish(Object event) {
		eventBus.post(event);
	}
	
	public void registerSubscriber( Object subscriber ) {
		eventBus.register(subscriber);
	}
}
