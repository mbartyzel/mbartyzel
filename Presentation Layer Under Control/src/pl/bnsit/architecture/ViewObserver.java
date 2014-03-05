package pl.bnsit.architecture;

public interface ViewObserver {
	void updateViewModel(String property, Object value);

	void ready();
}
