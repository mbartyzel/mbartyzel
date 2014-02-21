package pl.bnsit.flights.viewmodel;

public interface ViewObserver {
	void updateViewModel(String property, Object value);
}
