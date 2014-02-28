package pl.bnsit.java.foundations.swing.mvp;



public class Runner {

	public static void main(String[] args) {
		Form form = new Form();
		Presenter presenter = new Presenter(form);
		form.addListener( new Listener(presenter) );
		presenter.start();
	}	
}
